package com.example.demo.service.user.impl;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.UserBean;
import com.example.demo.bean.user.SP08ResponeBean;
import com.example.demo.bean.user.SP14LoginRespone;
import com.example.demo.bean.user.SP14RegisterResponse;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.dto.user.UserLoginDTO;
import com.example.demo.dto.user.UserRegisterDTO;
import com.example.demo.mapping.UserMapping;
import com.example.demo.proxies.user.UserWebServiceProxy;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

  
    private final UserWebServiceProxy userWebServiceProxy;

    private final UserMapping userMapping;
    @Autowired
    public UserServiceImpl(UserWebServiceProxy userWebServiceProxy,UserMapping userMapping)
    {
        this.userWebServiceProxy=userWebServiceProxy;
        this.userMapping=userMapping;
    }
    @Override
    public SP14RegisterResponse register(UserRegisterDTO userRegisterDTO) {
        SP14RegisterResponse response=userWebServiceProxy.register(userRegisterDTO);
        return response;
    }
    @Override
    public SP14LoginRespone login(UserLoginDTO userLogin) {
        SP14LoginRespone respone =userWebServiceProxy.login(userLogin);
        return respone;
    }
    @Override
    public SP14ResponseBean getUser(String token) {
      return userWebServiceProxy.getUser(token);
    }
    
}
