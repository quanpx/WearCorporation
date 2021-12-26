package com.example.demo.product.proxies;

import com.example.demo.product.bean.sp11.SP11ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;


@FeignClient(name = "sp11-api", url = "https://limitless-shelf-91096.herokuapp.com/api")
public interface ProductSP11WebServiceProxy {

    @GetMapping("/products")
    SP11ResponseBean<List<HashMap<String, Object>>> findAll();
    @GetMapping("/products/{id}")
    SP11ResponseBean<HashMap<String, Object>> findById(@PathVariable Long id);

    @GetMapping("/categories")
    SP11ResponseBean<List<HashMap<String, Object>>> getAllCategories();
}
