package com.example.demo.module.account.bean.sp14;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SP14ErrorBean {

    @JsonProperty("message")
    private String message;

    @JsonProperty("errors")
    private Map<String, List<String>> errors;
}
