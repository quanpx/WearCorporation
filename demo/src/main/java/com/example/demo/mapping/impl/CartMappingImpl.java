package com.example.demo.mapping.impl;

import com.example.demo.bean.CartBean;
import com.example.demo.dto.CartDTO;
import com.example.demo.mapping.CartMapping;

import org.springframework.stereotype.Component;

@Component
public class CartMappingImpl implements CartMapping {

    @Override
    public CartDTO beanToCartDTO(CartBean cart) {
        // TODO Auto-generated method stub
        return new CartDTO();
    }
    
}
