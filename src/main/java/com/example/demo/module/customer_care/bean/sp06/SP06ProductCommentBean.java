package com.example.demo.module.customer_care.bean.sp06;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP06ProductCommentBean {
    private Integer id;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("user_id")
    private Integer userId;

    private String comment;

    private String photo;

    @JsonProperty("date")
    private String date;


}
