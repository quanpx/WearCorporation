package com.example.demo.proxies.user;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.user.SP08ResponeBean;
import com.example.demo.bean.user.SP14LoginRespone;
import com.example.demo.bean.user.SP14RegisterResponse;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.dto.user.UserLoginDTO;
import com.example.demo.dto.user.UserRegisterDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-api", url = "https://module-user-ltct.herokuapp.com/api")
public interface UserWebServiceProxy {

    @PostMapping("/login")
    SP14LoginRespone login(@RequestBody UserLoginDTO userLogin);
    @PostMapping("/register")
    SP14RegisterResponse register(@RequestBody UserRegisterDTO userRegister);
    @GetMapping("/user")
    SP14ResponseBean getUser(@RequestHeader("Authorization") String bearer);
    
}