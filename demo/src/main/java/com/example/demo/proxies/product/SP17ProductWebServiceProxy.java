package com.example.demo.proxies.product;

import com.example.demo.bean.sp17.SP17ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;


@FeignClient(name = "sp17-product-api", url = "https://limitless-shelf-91096.herokuapp.com/api")
public interface SP17ProductWebServiceProxy {

    @GetMapping("/products")
    SP17ResponseBean<List<HashMap<String, Object>>> findAll();
    @GetMapping("/products/{id}")
    SP17ResponseBean<HashMap<String, Object>> findById(@PathVariable Long id);

    @GetMapping("/categories")
    SP17ResponseBean<List<HashMap<String, Object>>> getAllCategories();
}
