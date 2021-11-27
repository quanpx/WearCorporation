package com.example.demo.bean;

import lombok.Data;

import java.util.List;

@Data
public class ProductBean {

    private Long id;

    private String name;

    private String imageUrl;

    private List<String> similarImageUrlList;

    private boolean isAvailability;

    private String brand;

    private double price;

    private int stars;
}
