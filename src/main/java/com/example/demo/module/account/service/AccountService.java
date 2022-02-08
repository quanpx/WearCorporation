package com.example.demo.module.account.service;

import com.example.demo.client_ui.dto.account.AccountDTO;
import com.example.demo.client_ui.dto.account.AccountLoginFormDTO;
import com.example.demo.client_ui.dto.account.AccountRegisterFormDTO;

public interface AccountService {

    AccountDTO login(AccountLoginFormDTO formDTO);

    Object signup(AccountRegisterFormDTO formDTO);
}
