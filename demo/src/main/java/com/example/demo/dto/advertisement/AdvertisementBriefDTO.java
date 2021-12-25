package com.example.demo.dto.advertisement;

import lombok.Data;

@Data
public class AdvertisementBriefDTO {

    private Long id;

    private String title;

    private String content;

    private String advUrl;

    private String imageUrl;
}
