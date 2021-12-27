package com.example.demo.client_ui.dto.product;

import lombok.Data;

@Data
public class ProductBriefDTO {

    private Long id;

    private String name;

    private String imageUrl;

    private Double price;
}
