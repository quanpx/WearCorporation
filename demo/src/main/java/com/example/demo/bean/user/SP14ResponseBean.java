package com.example.demo.bean.user;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP14ResponseBean {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("token")
    private String token;

    @JsonProperty("user")
    private HashMap<String,Object> user;
    
    @JsonProperty("message")
    private String message;
}
