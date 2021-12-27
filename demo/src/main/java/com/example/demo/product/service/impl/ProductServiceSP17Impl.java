package com.example.demo.product.service.impl;

import com.example.demo.product.bean.sp17.SP17ProductDetailBean;
import com.example.demo.client_ui.dto.category.CategoryBriefDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.product.mapping.ProductMapping;
import com.example.demo.product.proxies.ProductSP17WebServiceProxy;
import com.example.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("sp17")
public class ProductServiceSP17Impl implements ProductService {

    @Autowired
    private ProductMapping productMapping;

    @Autowired
    ProductSP17WebServiceProxy webServiceProxy;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long productId) {
        List<SP17ProductDetailBean> detailBean = this.webServiceProxy.getProductById(productId);
        if (detailBean == null || detailBean.isEmpty()) return null;
        return this.productMapping.detailBeanToDetailDTO(detailBean.get(0));
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        List<SP17ProductDetailBean> detailBeanList = this.webServiceProxy.getAllProduct();
        if (detailBeanList == null) return null;
        List<ProductBriefDTO> briefDTOList = new LinkedList<>();
        for (SP17ProductDetailBean detailBean : detailBeanList)
            briefDTOList.add(this.productMapping.detailBeanToBriefDTO(detailBean));

        return briefDTOList;
    }

    @Override
    public List<CategoryBriefDTO> getAllCategories() {
        // TODO
        return null;
    }
}
