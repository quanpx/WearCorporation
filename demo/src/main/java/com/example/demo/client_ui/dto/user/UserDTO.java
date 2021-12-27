package com.example.demo.client_ui.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("username")
    private String username; 

    @JsonProperty("password")
    private String password;

    @JsonProperty("password_confirmation")
    private String passwordConfirmation;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

}
