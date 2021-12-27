package com.example.demo.bean.user;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP08ResponeBean {
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private HashMap<String,Object> data;
    @JsonProperty("msg")
    private String message;
}
