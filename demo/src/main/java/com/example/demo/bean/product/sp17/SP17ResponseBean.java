package com.example.demo.bean.product.sp17;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;

@Data
public class SP17ResponseBean {

    @JsonProperty("success")
    private boolean isSuccess;

    @JsonProperty("data")
    private HashMap<String, Object> data;

    @JsonProperty("message")
    private String message;

}
