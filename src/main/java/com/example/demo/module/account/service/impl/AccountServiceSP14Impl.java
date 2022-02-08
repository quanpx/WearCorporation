package com.example.demo.module.account.service.impl;


import com.example.demo.client_ui.dto.account.AccountDTO;
import com.example.demo.client_ui.dto.account.AccountLoginFormDTO;
import com.example.demo.client_ui.dto.account.AccountRegisterFormDTO;
import com.example.demo.module.account.bean.AccountResponseBean;
import com.example.demo.module.account.bean.sp14.AccountDTOBean;
import com.example.demo.module.account.bean.sp14.SP14AccountBean;
import com.example.demo.module.account.bean.sp14.SP14ErrorBean;
import com.example.demo.module.account.proxies.AccountSP14WebServiceProxy;
import com.example.demo.module.account.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service("sp14-account")
@Slf4j
public class AccountServiceSP14Impl implements AccountService {

    private final String ACCEPT_HEADER = "application/json";

    @Autowired
    private AccountSP14WebServiceProxy accountSP14WebServiceProxy;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AccountDTO login(AccountLoginFormDTO formDTO) {
        try {
            AccountResponseBean<SP14AccountBean> responseBean = accountSP14WebServiceProxy.login(ACCEPT_HEADER,
                    formDTO);
            AccountDTO accountDTO = new AccountDTO();

            SP14AccountBean sp14AccountBean = responseBean.getData();

          
            accountDTO.setId(sp14AccountBean.getId());
            accountDTO.setEmail(sp14AccountBean.getEmail());
            accountDTO.setUsername(sp14AccountBean.getUsername());
            accountDTO.setPhone(sp14AccountBean.getPhone());

            // }else
            // {
            // SP14ErrorMessageBean
            // errorMessageBean=objectMapper.convertValue(responseBeanEntity.get("data"),
            // SP14ErrorMessageBean.class);
            // accountDTO.setInvalidEmail((String)errorMessageBean.getErrors().get("email"));
            // accountDTO.setInvalidPassword((String)errorMessageBean.getErrors().get("password"));
            // accountDTO.setInvalidPhone((String)errorMessageBean.getErrors().get("phone"));
            // accountDTO.setInvalidUsername((String)errorMessageBean.getErrors().get("username"));;
            // }

            return accountDTO;
        } catch (Exception excpt) {
            log.error(excpt.getMessage(), excpt.getCause());
            return null;
        }
    }

    @Override
    public Object signup(AccountRegisterFormDTO formDTO) {
        try {

            formDTO.setRole("User");
            RestTemplate rest = new RestTemplate();
            String url = "http://ltct-customer.herokuapp.com/api/register";
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            HttpEntity<AccountRegisterFormDTO> form = new HttpEntity<>(formDTO, headers);

            ResponseEntity<AccountDTOBean> resp = rest.exchange(url, HttpMethod.POST, form,AccountDTOBean.class );
            return resp.getBody().getData();
        }catch (HttpStatusCodeException ex)
        {
            ObjectMapper objectMapper=new ObjectMapper();
           String errorResponse=ex.getResponseBodyAsString();
            try {
                SP14ErrorBean errorBean=objectMapper.readValue(errorResponse,SP14ErrorBean.class);
                return errorBean;
            } catch (JsonProcessingException e) {
                log.error(e.getMessage(),e.getCause());
                return ex.getResponseBodyAsString();
            }

        }
    }

}
