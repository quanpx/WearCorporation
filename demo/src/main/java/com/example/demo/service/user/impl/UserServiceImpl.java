package com.example.demo.service.user.impl;

import com.example.demo.bean.UserBean;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapping.UserMapping;
import com.example.demo.proxies.UserWebServiceProxy;
import com.example.demo.service.user.UserService;

public class UserServiceImpl implements UserService {

    private final UserWebServiceProxy userWebServiceProxy;
    private final UserMapping userMapping;
    public UserServiceImpl(UserWebServiceProxy userWebServiceProxy,UserMapping userMapping)
    {
        this.userWebServiceProxy=userWebServiceProxy;
        this.userMapping=userMapping;
    }
    @Override
    public UserDTO getUserInfo(int userId) {
        UserBean user=userWebServiceProxy.getUserById(userId);

        return userMapping.beanToUserDTO(user) ;
    }
    
}
