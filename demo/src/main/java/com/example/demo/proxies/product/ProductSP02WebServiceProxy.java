package com.example.demo.proxies.product;

import com.example.demo.bean.sp02.product.SP02ProductDetailBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "sp02-api", url = "https://ltct-product-ms.herokuapp.com/api/v1")
public interface ProductSP02WebServiceProxy {

    @GetMapping("/products/{id}")
    SP02ProductDetailBean getProductById(@PathVariable Long id);

    @GetMapping("/products")
    List<SP02ProductDetailBean> getAllProduct();
}
