package com.example.demo.mapping.product.impl;


import com.example.demo.bean.product.sp17.SP17ProductBriefBean;
import com.example.demo.bean.product.sp17.SP17ProductDetailBean;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;
import com.example.demo.mapping.product.ProductMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class ProductMappingImpl implements ProductMapping {

    private final ObjectMapper objectMapper;

    @Autowired
    public ProductMappingImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ProductBriefDTO briefBeanToBriefDTO(HashMap<String, Object> briefData) {
        if (briefData == null) return null;

        SP17ProductBriefBean briefBean = this.objectMapper.convertValue(briefData, SP17ProductBriefBean.class);
        ProductBriefDTO briefDTO = new ProductBriefDTO();

        briefDTO.setImageUrl(briefBean.getMainImageUrl());
        briefDTO.setPrice(briefBean.getPrice());
        briefDTO.setId(briefBean.getId());
        briefDTO.setName(briefBean.getName());

        return briefDTO;
    }

    @Override
    public List<ProductBriefDTO> briefBeansToBriefDTOs(List<HashMap<String, Object>> briefDataList) {
        if (briefDataList == null) return null;
        List<ProductBriefDTO> briefDTOList = new LinkedList<>();

        briefDataList.forEach(briefData -> briefDTOList.add(this.briefBeanToBriefDTO(briefData)));

        return briefDTOList;
    }

    @Override
    public ProductDetailDTO detailBeanToDetailDTO(HashMap<String, Object> detailData) {
        if (detailData == null) return null;

        SP17ProductDetailBean detailBean = this.objectMapper.convertValue(detailData, SP17ProductDetailBean.class);
        ProductDetailDTO detailDTO = new ProductDetailDTO();

        detailDTO.setBrand(detailBean.getBrand());
        detailDTO.setId(detailBean.getId());
        detailDTO.setPrice(detailBean.getPrice());
        detailDTO.setName(detailBean.getName());
        detailDTO.setImageUrl(detailBean.getMainImageUrl());
        detailDTO.setDescription(detailBean.getDetail());

        return detailDTO;
    }
}
