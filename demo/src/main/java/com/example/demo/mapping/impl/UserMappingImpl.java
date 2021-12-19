package com.example.demo.mapping.impl;

import com.example.demo.bean.UserBean;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapping.UserMapping;

public class UserMappingImpl implements UserMapping {

    @Override
    public UserDTO beanToUserDTO(UserBean user) {
        // TODO Auto-generated method stub
        return new UserDTO();
    }
    
}
