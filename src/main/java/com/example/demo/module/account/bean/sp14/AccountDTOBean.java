package com.example.demo.module.account.bean.sp14;

import com.example.demo.client_ui.dto.account.AccountDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountDTOBean {


    @JsonProperty("token")
    private String token;

    @JsonProperty("data")
    private AccountDTO data;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private Integer status;

}
