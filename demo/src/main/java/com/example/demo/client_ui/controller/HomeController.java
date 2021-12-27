package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.advertisement.AdvertisementBriefDTO;
import com.example.demo.advertisement.service.AdvertisementService;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.user.UserDTO;
import com.example.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        public ModelAndView displayHomepage(@ModelAttribute("user") UserDTO user) {
                System.out.println(user);
                List<AdvertisementBriefDTO> advBriefList = this.advServiceMap.get(
                                this.moduleConfig.getAdvertisementTeam()).getAllAdvertisementBriefDTOs();
                List<ProductBriefDTO> productBriefDTOList = this.productServiceMap.get(
                                this.moduleConfig.getProductTeam()).getAllProductBriefDTO();
                ModelAndView model = new ModelAndView();
                model.addObject("advList", advBriefList.size() > 2 ? advBriefList.subList(0, 3) : advBriefList);
                model.addObject("productList", productBriefDTOList.size() > 5 ? productBriefDTOList.subList(0, 6)
                                : productBriefDTOList);
                model.addObject("userModel", user);
                model.setViewName("index");

                return model;
        }

}
