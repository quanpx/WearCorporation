package com.example.demo.service.product.impl;

import com.example.demo.bean.sp02.product.SP02ProductDetailBean;
import com.example.demo.bean.sp17.category.SP17CategoryBriefBean;
import com.example.demo.dto.category.CategoryBriefDTO;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;
import com.example.demo.mapping.product.ProductMapping;
import com.example.demo.proxies.product.SP02ProductWebServiceProxy;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sp02")
public class SP02ProductServiceImpl implements ProductService {
    
    @Autowired
    private SP02ProductWebServiceProxy productWebServiceProxy;

    @Autowired
    private ProductMapping productMapping;

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long productId) {
        SP02ProductDetailBean detailBean = this.productWebServiceProxy.getProductById(productId);

        return productMapping.detailBeanToDetailDTO(detailBean);
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        List<SP02ProductDetailBean> detailBeanList =
                this.productWebServiceProxy.getAllProduct();

        return this.productMapping.detailBeansToBriefDTOs(detailBeanList);
    }

    @Override
    public List<CategoryBriefDTO> getAllCategories() {
        return null;
    }
}
