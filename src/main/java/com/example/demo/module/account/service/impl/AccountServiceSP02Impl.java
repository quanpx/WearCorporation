package com.example.demo.module.account.service.impl;

import com.example.demo.client_ui.dto.account.AccountDTO;
import com.example.demo.client_ui.dto.account.AccountLoginFormDTO;
import com.example.demo.client_ui.dto.account.AccountRegisterFormDTO;
import com.example.demo.module.account.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sp02-account")
public class AccountServiceSP02Impl implements AccountService {

    public static Integer ID_COUNT = 22;

    private final List<AccountDTO> ACCOUNT_LIST = Arrays.asList(
            new AccountDTO(21,"sp02", "ltct.sp02@gmail.com", "sp02",null,
                    "ltct", "sp02", "HUST", "123456",
                    "/images/avater.jpg", null, null, null, null, null)
    );

    private final Set<AccountDTO> ACCOUNT_SET = new HashSet<>(ACCOUNT_LIST);

    private boolean isValidEmail(String email) {
        if (email == null || !email.contains("@")) return false;
        for (AccountDTO dto : this.ACCOUNT_SET)
            if (dto.getEmail().equals(email))
                return false;

        return true;
    }

    @Override
    public AccountDTO login(AccountLoginFormDTO formDTO) {
        for (AccountDTO dto : this.ACCOUNT_SET)
            if (dto.getUsername().equals(formDTO.getUsername()) &&
                    dto.getPassword().equals(formDTO.getPassword()))
                return dto;
        return null;
    }

    @Override
    public AccountDTO signup(AccountRegisterFormDTO formDTO) {
        if (formDTO == null) return null;
        if (!isValidEmail(formDTO.getEmail())) return null;

        AccountDTO savedAccount = new AccountDTO(ID_COUNT, formDTO.getUsername(),formDTO.getEmail(),
                formDTO.getPassword(),null, formDTO.getFirstName(), formDTO.getLastName(),
                formDTO.getCountry(), null, null, null,null,null,null,null);
        this.ACCOUNT_SET.add(savedAccount);
        ID_COUNT += 1;

        return savedAccount;
    }
}
