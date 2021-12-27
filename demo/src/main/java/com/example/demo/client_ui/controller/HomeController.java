package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.advertisement.AdvertisementBriefDTO;
import com.example.demo.advertisement.service.AdvertisementService;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController extends BaseController {

    private final Map<String, AdvertisementService> advServiceMap;
    private final Map<String, ProductService> productServiceMap;

    @Autowired
    public HomeController(Map<String, AdvertisementService> advServiceMap,
                          Map<String, ProductService> productServiceMap) {
        this.advServiceMap = advServiceMap;
        this.productServiceMap = productServiceMap;
    }

    @GetMapping("/")
    public String displayHomepage(Model model) {
        List<AdvertisementBriefDTO> advBriefList = this.advServiceMap.get(
                this.moduleConfig.getAdvertisementTeam()).getAllAdvertisementBriefDTOs();
        List<ProductBriefDTO> productBriefDTOList = this.productServiceMap.get(
                this.moduleConfig.getProductTeam()).getAllProductBriefDTO();

        model.addAttribute("advList", advBriefList.size() > 2 ?
                advBriefList.subList(0, 3) : advBriefList);
        model.addAttribute("productList", productBriefDTOList.size() > 5 ?
                productBriefDTOList.subList(0, 6) : productBriefDTOList);

        return "index";
    }
    
}
