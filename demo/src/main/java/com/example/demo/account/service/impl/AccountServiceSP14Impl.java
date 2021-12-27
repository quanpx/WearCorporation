package com.example.demo.account.service.impl;

import com.example.demo.account.mapping.AccountMapping;
import com.example.demo.account.proxies.AccountSP14WebServiceProxy;
import com.example.demo.account.service.AccountService;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.client_ui.dto.user.UserDTO;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sp14")
public class AccountServiceSP14Impl implements AccountService {
     @Autowired
    private AccountSP14WebServiceProxy accountSP14WebServiceProxy;

    @Autowired
    private AccountMapping<SP14ResponseBean> userMapping;

    @Override
    public SP14ResponseBean register(UserDTO userRegisterDTO) {
        SP14ResponseBean response = accountSP14WebServiceProxy.register(userRegisterDTO);
        return response;
    }

    @Override
    public SP14ResponseBean login(UserDTO userLogin) {
        SP14ResponseBean respone = accountSP14WebServiceProxy.login(userLogin);
        return respone;
    }

    @Override
    public SP14ResponseBean getUser(String token) {
        return accountSP14WebServiceProxy.getUser(token);
    }
}
