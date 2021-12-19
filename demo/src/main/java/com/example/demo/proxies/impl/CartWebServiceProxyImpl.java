package com.example.demo.proxies.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.CartBean;
import com.example.demo.bean.ProductDetailBean;
import com.example.demo.proxies.CartWebServiceProxy;

import org.springframework.stereotype.Component;

@Component 
public class CartWebServiceProxyImpl implements CartWebServiceProxy {

    @Override
    public CartBean getCartInfo(int cartId) {
        // TODO Auto-generated method stub
        CartBean cart=new CartBean();
        cart.setId(1);

        List<ProductDetailBean> products=new ArrayList<>();
        ProductDetailBean prod=new ProductDetailBean();
        prod.setId(1);
        prod.setName("Coat");
        prod.setQuantity(2);
        prod.setPrice(54);
        
        ProductDetailBean prod2=new ProductDetailBean();
        prod2.setId(2);
        prod2.setName("Jean");
        prod2.setQuantity(2);
        prod2.setPrice(54);
        
        products.add(prod);
        products.add(prod2);
        cart.setProducts(products);
        return cart;
    }
    
}
