package com.example.demo.client_ui.dto.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetailDTO {

    private Long orderId;

    private String orderDate;

    private Float totalPrice;

    private Float subTotal;

    private String paymentMethod;

    private String status;

    private List<ProductOrderDTO> productList;
}
