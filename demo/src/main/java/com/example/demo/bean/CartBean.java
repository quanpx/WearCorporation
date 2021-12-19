package com.example.demo.bean;

import java.util.List;

public class CartBean {
   private int id;
   private List<ProductDetailBean> products;
   public void setId(int id)
   {
       this.id=id;
   }
   public void setProducts(List<ProductDetailBean> products)
   {
       this.products=products;
   }
    
}
