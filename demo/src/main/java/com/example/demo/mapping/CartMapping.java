package com.example.demo.mapping;

import com.example.demo.bean.CartBean;
import com.example.demo.dto.CartDTO;

public interface CartMapping {
   CartDTO beanToCartDTO(CartBean cart);
}
