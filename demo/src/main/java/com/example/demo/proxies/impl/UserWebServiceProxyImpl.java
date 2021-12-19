package com.example.demo.proxies.impl;

import com.example.demo.bean.UserBean;
import com.example.demo.proxies.UserWebServiceProxy;

public class UserWebServiceProxyImpl implements UserWebServiceProxy{

    @Override
    public UserBean getUserById(int userId) {
        // TODO Auto-generated method stub
        UserBean user=new UserBean();
        user.setId(1);
        user.setName("Phung Quan");
        user.setAddress("Ha Noi");
        user.setAge(21);
        user.setPhone("0964789xxx");
        
        return user;
    }
    
}
