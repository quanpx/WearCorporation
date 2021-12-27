package com.example.demo.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRegisterDTO {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("password_confirmation")
    private String password_confirmation;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
}
