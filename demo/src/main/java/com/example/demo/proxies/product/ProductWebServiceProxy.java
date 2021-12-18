package com.example.demo.proxies.product;

import com.example.demo.bean.product.sp17.SP17ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-api", url = "https://limitless-shelf-91096.herokuapp.com/api")
public interface ProductWebServiceProxy {

    @GetMapping("/products")
    SP17ResponseBean findAll();

    @GetMapping("/products/{id}")
    SP17ResponseBean findById(@PathVariable Long id);

}
