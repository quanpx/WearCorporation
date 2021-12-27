package com.example.demo.account.mapping.impl;

import com.example.demo.account.mapping.AccountMapping;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.client_ui.dto.user.UserDTO;

import org.springframework.stereotype.Component;

@Component
public class AccountMappingImpl implements AccountMapping<SP14ResponseBean> {

    @Override
    public UserDTO beanToUserDTO(SP14ResponseBean user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getUser().get("email").toString());
        userDTO.setUsername(user.getUser().get("username").toString());
        userDTO.setPhone(user.getUser().get("phone").toString());
        userDTO.setId(user.getUser().get("id").toString());
        return userDTO;
    }
}
