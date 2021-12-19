package com.example.demo.proxies;

import com.example.demo.bean.CartBean;

import org.springframework.stereotype.Component;


public interface CartWebServiceProxy {
    public CartBean getCartInfo(int cartId);
}
