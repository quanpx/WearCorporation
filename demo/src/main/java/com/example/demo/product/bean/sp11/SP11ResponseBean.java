package com.example.demo.product.bean.sp11;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP11ResponseBean<T> {

    @JsonProperty("success")
    private boolean isSuccess;

    @JsonProperty("data")
    private T data;

    @JsonProperty("message")
    private String message;

}
