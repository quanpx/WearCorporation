package com.example.demo.controller;

import com.example.demo.config.ModuleConfig;
import com.example.demo.dto.category.CategoryBriefDTO;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {

    private final Map<String, ProductService> productServiceMap;

    @Autowired
    public ProductController(Map<String, ProductService> productServiceMap) {
        this.productServiceMap = productServiceMap;
    }

    @GetMapping
    public String displayProductList(Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        List<ProductBriefDTO> productBriefDTOList = productService.getAllProductBriefDTO();
        List<CategoryBriefDTO> categoryBriefDTOList = productService.getAllCategories();

        model.addAttribute("productList", productBriefDTOList);
        model.addAttribute("categories", categoryBriefDTOList);

        return "product-list";
    }

    @GetMapping("/{id}")
    public String displayProductDetail(@PathVariable Long id, Model model) {
        ProductService productService = this.productServiceMap.get(this.moduleConfig.getProductTeam());
        ProductDetailDTO productDetailDTO = productService.getProductDetailDTOById(id);

        model.addAttribute("product", productDetailDTO);

        return "product-detail";
    }

}
