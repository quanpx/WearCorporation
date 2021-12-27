package com.example.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserLoginDTO {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
}
