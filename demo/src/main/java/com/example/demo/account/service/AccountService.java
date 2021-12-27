package com.example.demo.account.service;

import com.example.demo.bean.user.SP14RegisterResponse;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.client_ui.dto.user.UserDTO;

public interface AccountService {
    SP14ResponseBean register(UserDTO userRegisterDTO);

    SP14ResponseBean login(UserDTO userLogin);

    SP14ResponseBean getUser(String token);
}
