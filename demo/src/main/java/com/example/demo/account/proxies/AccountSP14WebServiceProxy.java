package com.example.demo.account.proxies;

import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.client_ui.dto.user.UserDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-api", url = "https://module-user-ltct.herokuapp.com/api")
public interface AccountSP14WebServiceProxy {
    
    @PostMapping("/login")
    SP14ResponseBean login(@RequestBody UserDTO userLogin);

    @PostMapping("/register")
    SP14ResponseBean register(@RequestBody UserDTO userRegister);

    @GetMapping("/user")
    SP14ResponseBean getUser(@RequestHeader("Authorization") String bearer);
    
}
