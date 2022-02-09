package com.example.demo.module.customer_care.bean.sp21;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class SP21ResponseCommentBean {
    @JsonProperty("success")
    private String success;
}
