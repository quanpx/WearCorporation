package com.example.demo.service.product.impl;

import com.example.demo.bean.sp11.SP11ResponseBean;
import com.example.demo.dto.category.CategoryBriefDTO;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;
import com.example.demo.mapping.product.ProductMapping;
import com.example.demo.proxies.product.ProductSP11WebServiceProxy;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("sp11")
public class ProductServiceSP11Impl implements ProductService {

    @Autowired
    private ProductMapping productMapping;

    @Autowired
    private ProductSP11WebServiceProxy webServiceProxy;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long productId) {
        SP11ResponseBean<HashMap<String, Object>> responseBean =
                this.webServiceProxy.findById(productId);

        return responseBean.isSuccess() ?
                this.productMapping.detailBeanToDetailDTO(responseBean.getData()) : null;
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        SP11ResponseBean<List<HashMap<String, Object>>> responseBean =
                this.webServiceProxy.findAll();

        return responseBean.isSuccess() ?
                this.productMapping.briefBeansToBriefDTOs(responseBean.getData()) : null;
    }

    @Override
    public List<CategoryBriefDTO> getAllCategories() {
        SP11ResponseBean<List<HashMap<String, Object>>> responseBean =
                this.webServiceProxy.getAllCategories();

        return responseBean.isSuccess() ?
                this.productMapping.categoryBriefBeansToCategoryBriefDTO(responseBean.getData()) : null;
    }
}
