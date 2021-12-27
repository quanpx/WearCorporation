package com.example.demo.account.service.impl;

import com.example.demo.account.service.AccountService;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.client_ui.dto.user.UserDTO;

import org.springframework.stereotype.Service;

@Service("sp08")
public class AccountServiceSP08Impl implements AccountService {

    @Override
    public SP14ResponseBean register(UserDTO userRegisterDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SP14ResponseBean login(UserDTO userLogin) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SP14ResponseBean getUser(String token) {
        // TODO Auto-generated method stub
        return null;
    }

}
