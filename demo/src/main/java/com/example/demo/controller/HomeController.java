package com.example.demo.controller;

import com.example.demo.dto.advertisement.AdvertisementBriefDTO;
import com.example.demo.service.advertisement.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController extends BaseController {

    private final Map<String, AdvertisementService> advServiceMap;

    @Autowired
    public HomeController(Map<String, AdvertisementService> advServiceMap) {
        this.advServiceMap = advServiceMap;
    }

    @GetMapping("/")
    public String displayHomepage(Model model) {
        List<AdvertisementBriefDTO> advBriefList = this.advServiceMap.get(
                this.moduleConfig.getAdvertisementTeam()).getAllAdvertisementBriefDTOs();

        model.addAttribute("advList", advBriefList.subList(0, 3));

        return "index";
    }
    
}
