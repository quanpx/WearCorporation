package com.example.demo.module.customer_care.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "sp06-api", url = "http://ltct-laravel.herokuapp.com/api")

public interface CustomerCareSP06WebServiceProxy {
}
