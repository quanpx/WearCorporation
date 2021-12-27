package com.example.demo.product.service.impl;

import com.example.demo.product.bean.sp02.SP02ProductDetailBean;
import com.example.demo.client_ui.dto.category.CategoryBriefDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.product.mapping.ProductMapping;
import com.example.demo.product.proxies.ProductSP02WebServiceProxy;
import com.example.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sp02")
public class ProductServiceSP02Impl implements ProductService {
    
    @Autowired
    private ProductSP02WebServiceProxy webServiceProxy;

    @Autowired
    private ProductMapping productMapping;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long productId) {
        SP02ProductDetailBean detailBean = this.webServiceProxy.getProductById(productId);

        return productMapping.detailBeanToDetailDTO(detailBean);
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        List<SP02ProductDetailBean> detailBeanList =
                this.webServiceProxy.getAllProduct();

        return this.productMapping.detailBeansToBriefDTOs(detailBeanList);
    }

    @Override
    public List<CategoryBriefDTO> getAllCategories() {
        return null;
    }
}
