package com.example.demo.module.search_and_report.proxies;

import com.example.demo.module.search_and_report.bean.sp04.SP04ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "sp04-api", url = "https://ltct-sp04-search-engine.herokuapp.com")
public interface SearchAndReportSP04WebServiceProxy {

    @GetMapping("/products")
    List<SP04ProductBean> searchProduct(@RequestParam String keyword);
}
