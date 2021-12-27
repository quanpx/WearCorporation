package com.example.demo.bean.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SP14LoginRespone {
    
@JsonProperty("token")
 private String token;
 @JsonProperty("message")
 private String message;
}
