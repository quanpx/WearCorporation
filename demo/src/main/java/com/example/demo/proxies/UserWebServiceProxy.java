package com.example.demo.proxies;

import com.example.demo.bean.UserBean;

public interface UserWebServiceProxy {
   public UserBean getUserById(int userId); 
}
