package com.example.demo.bean.sp09;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP09ResponseBean<T> {

    @JsonProperty("statusCode")
    private Long statusCode;

    private T data;
}
