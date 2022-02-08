package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.cart.ProductCartAddFormDTO;
import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.customer_care.service.CustomerCareService;
import com.example.demo.module.inventory.service.InventoryService;
import com.example.demo.module.product.service.ProductService;
import com.example.demo.module.search_and_report.service.SearchAndReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, ProductService> productServiceMap;

    private final Map<String, CustomerCareService> customerCareServiceMap;

    private final Map<String, InventoryService> inventoryServiceMap;

    private final Map<String, SearchAndReportService> searchAndReportServiceMap;

    @Autowired
    private ShopController(Map<String, ProductService> productServiceMap,
                           Map<String, CustomerCareService> customerCareServiceMap,
                           Map<String, InventoryService> inventoryServiceMap,
                           Map<String, SearchAndReportService> searchAndReportServiceMap) {
        this.productServiceMap = productServiceMap;
        this.customerCareServiceMap = customerCareServiceMap;
        this.inventoryServiceMap = inventoryServiceMap;
        this.searchAndReportServiceMap = searchAndReportServiceMap;
    }

    @GetMapping
    public String getShopPage(@RequestParam(name = "category_id", required = false) Integer categoryId,
                              @RequestParam(name = "keyword", required = false) String keyword,
                              Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        SearchAndReportService searchAndReportService =
                this.searchAndReportServiceMap.get(this.moduleConfig.getSearchAndReportTeam());

        List<ProductBriefDTO> productBriefDTOList = null;
        HashMap<String, Object> params = new HashMap<>();
        if (keyword != null) {
            productBriefDTOList = searchAndReportService.searchProduct(keyword);
        } else {
            if (categoryId != null) params.put("category_id", categoryId);
            productBriefDTOList = productService.getProductByFilter(params);
        }
        if (productBriefDTOList != null) {
            model.addAttribute("productList", productBriefDTOList);
            model.addAttribute("isLogin", currentAccount.getRole() != AccountRoleDTO.GUEST_ROLE);
            model.addAttribute("userId", currentAccount.getId());
            model.addAttribute("teamNum", this.moduleConfig.getProductTeam().equals("sp17-product") ? 17 : 11);
        }
        List<CategoryDTO> categoryDTOList = productService.getAllCategories();
        if (categoryDTOList != null)
            model.addAttribute("categories", categoryDTOList);

        return "shop";
    }

    @GetMapping("/products/{id}")
    public String getProductDetailById(@PathVariable Integer id, Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        InventoryService inventoryService = this.inventoryServiceMap.get(this.moduleConfig.getInventoryTeam());

        ProductDetailDTO productDetailDTO = productService.getProductDetailDTOById(id);
        List<ProductBriefDTO> relatedProductList;

        if (productDetailDTO == null)
            return "redirect:/error";

        HashMap<String, Object> params = new HashMap<>();
        if (productDetailDTO.getCategoryDTO() != null) {
            params.put("category_id", productDetailDTO.getCategoryDTO().getId());
            relatedProductList = productService.getProductByFilter(params);
        } else {
            relatedProductList = productService.getAllProductBriefDTO();
        }

        List<ProductReviewDTO> productReviewDTOList = this.customerCareServiceMap.get(
                this.moduleConfig.getCustomerCareTeam()).getAllProductReviewByProductId(productDetailDTO.getId());
        model.addAttribute("reviews", productReviewDTOList);

        model.addAttribute("product", productDetailDTO);
        model.addAttribute("quantity",
                inventoryService.getProductQuantityInInventory(productDetailDTO.getId(), null));
        model.addAttribute("notice", null);
        model.addAttribute("relatedProductList", relatedProductList.size() > 4 ?
                relatedProductList.subList(0, 4) : relatedProductList);

        ProductCartAddFormDTO productCart= new ProductCartAddFormDTO();
        productCart.setImageUrl(productDetailDTO.getImageUrl());
        productCart.setId(productDetailDTO.getId());
        productCart.setPrice(productDetailDTO.getPrice());
        productCart.setName(productDetailDTO.getName());
        model.addAttribute("productCartForm", productCart);

        return "product-detail";
    }

}
