package com.example.demo.service.product.impl;

import com.example.demo.dto.category.CategoryBriefDTO;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;
import com.example.demo.mapping.product.ProductMapping;
import com.example.demo.proxies.product.ProductSP17WebServiceProxy;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sp17")
public class ProductServiceSP17Impl implements ProductService {

    @Autowired
    private ProductMapping productMapping;

    @Autowired
    ProductSP17WebServiceProxy webServiceProxy;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long productId) {
        // TODO
        return null;
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        // TODO
        return null;
    }

    @Override
    public List<CategoryBriefDTO> getAllCategories() {
        // TODO
        return null;
    }
}
