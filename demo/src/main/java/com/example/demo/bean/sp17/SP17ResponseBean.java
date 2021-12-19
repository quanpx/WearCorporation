package com.example.demo.bean.sp17;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP17ResponseBean<T> {

    @JsonProperty("success")
    private boolean isSuccess;

    @JsonProperty("data")
    private T data;

    @JsonProperty("message")
    private String message;

}
