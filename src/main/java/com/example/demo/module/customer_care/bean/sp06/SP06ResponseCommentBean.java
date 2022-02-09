package com.example.demo.module.customer_care.bean.sp06;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP06ResponseCommentBean {
    @JsonProperty("success")
    private String success;
}
