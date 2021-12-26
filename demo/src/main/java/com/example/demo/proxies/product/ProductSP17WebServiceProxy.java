package com.example.demo.proxies.product;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "sp17-api", url = "https://limitless-shelf-91096.herokuapp.com/api")
public interface ProductSP17WebServiceProxy {
}
