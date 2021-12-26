package com.example.demo.product.proxies;

import com.example.demo.product.bean.sp17.SP17ProductDetailBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "sp17-api", url = "https://laptrinhcautrucapi.herokuapp.com")
public interface ProductSP17WebServiceProxy {

    @GetMapping("/product/show")
    List<SP17ProductDetailBean> getAllProduct();

    @GetMapping("/product/id")
    List<SP17ProductDetailBean> getProductById(@RequestParam("id") Long productId);
}
