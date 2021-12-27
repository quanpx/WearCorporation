package com.example.demo.mapping.impl;

import com.example.demo.bean.UserBean;
import com.example.demo.bean.user.SP08ResponeBean;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.mapping.UserMapping;

import org.springframework.stereotype.Component;

@Component
public class UserMappingImpl implements UserMapping {

    @Override
    public UserDTO beanToUserDTO(SP08ResponeBean responeBean) {
        // TODO Auto-generated method stub
        return new UserDTO();
    }
    
}
