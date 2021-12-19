package com.example.demo.service.product.impl;

import com.example.demo.bean.sp17.SP17ResponseBean;
import com.example.demo.dto.category.CategoryBriefDTO;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;
import com.example.demo.mapping.product.ProductMapping;
import com.example.demo.proxies.product.SP17ProductWebServiceProxy;
import com.example.demo.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("sp17")
public class SP17ProductServiceImpl implements ProductService {

    private final ProductMapping productMapping;
    private final SP17ProductWebServiceProxy productWebServiceProxy;

    @Autowired
    public SP17ProductServiceImpl(ProductMapping productMapping,
                                  SP17ProductWebServiceProxy productWebServiceProxy) {
        this.productMapping = productMapping;
        this.productWebServiceProxy = productWebServiceProxy;
    }

    @Override
    public ProductDetailDTO getProductDetailDTOById(Long productId) {
        SP17ResponseBean<HashMap<String, Object>> responseBean =
                this.productWebServiceProxy.findById(productId);

        return responseBean.isSuccess() ?
                this.productMapping.detailBeanToDetailDTO(responseBean.getData()) : null;
    }

    @Override
    public List<ProductBriefDTO> getAllProductBriefDTO() {
        SP17ResponseBean<List<HashMap<String, Object>>> responseBean =
                this.productWebServiceProxy.findAll();

        return responseBean.isSuccess() ?
                this.productMapping.briefBeansToBriefDTOs(responseBean.getData()) : null;
    }

    @Override
    public List<CategoryBriefDTO> getAllCategories() {
        SP17ResponseBean<List<HashMap<String, Object>>> responseBean =
                this.productWebServiceProxy.getAllCategories();

        return responseBean.isSuccess() ?
                this.productMapping.categoryBriefBeansToCategoryBriefDTO(responseBean.getData()) : null;
    }
}
