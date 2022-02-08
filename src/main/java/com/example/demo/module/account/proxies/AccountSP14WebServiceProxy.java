package com.example.demo.module.account.proxies;

import java.util.Map;

import com.example.demo.client_ui.dto.account.AccountLoginFormDTO;
import com.example.demo.client_ui.dto.account.AccountRegisterFormDTO;
import com.example.demo.module.account.bean.AccountResponseBean;
import com.example.demo.module.account.bean.sp14.SP14AccountBean;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-api", url = "http://ltct-customer.herokuapp.com/api")
public interface AccountSP14WebServiceProxy {
    @PostMapping("/login")
     AccountResponseBean<SP14AccountBean> login(@RequestHeader("Accept") String accept,
            @RequestBody AccountLoginFormDTO userLogin);

    @PostMapping("/register")
    ResponseEntity<Map<String,String>> signup(@RequestHeader("Accept") String accept,
                          @RequestBody AccountRegisterFormDTO userRegister);

    @GetMapping("/user")
    AccountResponseBean<SP14AccountBean> getUser(@RequestHeader("Authorization") String bearer);

}
