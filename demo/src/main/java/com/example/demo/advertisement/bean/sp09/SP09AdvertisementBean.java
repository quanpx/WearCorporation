package com.example.demo.advertisement.bean.sp09;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SP09AdvertisementBean {

    private Long id;

    private String title;

    private String content;

    @JsonProperty("advertismentUrl")
    private String advUrl;

    private String imageUrl;

    private String type;

    @JsonProperty("advertisingDisplayType")
    private String advDisplayType;

    @JsonProperty("advertisementPosition")
    private String advPosition;

    private String status;
}
