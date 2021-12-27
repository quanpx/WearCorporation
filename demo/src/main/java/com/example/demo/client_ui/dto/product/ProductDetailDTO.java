package com.example.demo.client_ui.dto.product;

import lombok.Data;

import java.util.List;

@Data
public class ProductDetailDTO {

    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private List<String> similarImageUrlList;

    private boolean isAvailability;

    private String brand;

    private double price;

    private int stars;
}
