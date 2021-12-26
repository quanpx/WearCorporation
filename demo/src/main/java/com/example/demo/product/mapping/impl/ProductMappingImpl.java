package com.example.demo.product.mapping.impl;

import com.example.demo.product.bean.sp02.SP02ProductDetailBean;
import com.example.demo.product.bean.sp11.SP11CategoryBriefBean;
import com.example.demo.product.bean.sp11.SP11ProductBriefBean;
import com.example.demo.product.bean.sp11.SP11ProductDetailBean;
import com.example.demo.product.bean.sp17.SP17ProductDetailBean;
import com.example.demo.client_ui.dto.category.CategoryBriefDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.product.mapping.ProductMapping;
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

        SP11ProductBriefBean briefBean = this.objectMapper.convertValue(briefData, SP11ProductBriefBean.class);
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

        SP11ProductDetailBean detailBean = this.objectMapper.convertValue(detailData, SP11ProductDetailBean.class);
        ProductDetailDTO detailDTO = new ProductDetailDTO();

        detailDTO.setBrand(detailBean.getBrand());
        detailDTO.setId(detailBean.getId());
        detailDTO.setPrice(detailBean.getPrice());
        detailDTO.setName(detailBean.getName());
        detailDTO.setImageUrl(detailBean.getMainImageUrl());
        detailDTO.setDescription(detailBean.getDetail());

        return detailDTO;
    }

    @Override
    public ProductDetailDTO detailBeanToDetailDTO(SP02ProductDetailBean bean) {
        return bean == null ? null : this.objectMapper.convertValue(bean, ProductDetailDTO.class);
    }

    @Override
    public ProductDetailDTO detailBeanToDetailDTO(SP17ProductDetailBean detailBean) {
        if (detailBean == null) return null;
        ProductDetailDTO detailDTO = new ProductDetailDTO();

        detailDTO.setId(detailBean.getId());
        detailDTO.setPrice(detailBean.getPrice());
        detailDTO.setName(detailBean.getName());
        detailDTO.setDescription(detailBean.getDescription());
        detailDTO.setImageUrl(detailBean.getImage());

        return detailDTO;
    }

    @Override
    public CategoryBriefDTO categoryBriefBeanToCategoryBriefDTO(HashMap<String, Object> briefData) {
        if (briefData == null) return null;

        SP11CategoryBriefBean categoryBriefBean =
                this.objectMapper.convertValue(briefData, SP11CategoryBriefBean.class);
        CategoryBriefDTO categoryBriefDTO = new CategoryBriefDTO();

        categoryBriefDTO.setId(categoryBriefBean.getId());
        categoryBriefDTO.setName(categoryBriefBean.getName());
        categoryBriefDTO.setDescription(categoryBriefBean.getDescription());
        categoryBriefDTO.setTax(categoryBriefBean.getTax());
        categoryBriefDTO.setUnit(categoryBriefBean.getUnit());

        return categoryBriefDTO;
    }

    @Override
    public List<CategoryBriefDTO> categoryBriefBeansToCategoryBriefDTO(
            List<HashMap<String, Object>> briefDataList) {
        if (briefDataList == null) return null;
        List<CategoryBriefDTO> categoryBriefDTOList = new LinkedList<>();

        briefDataList.forEach(briefData -> categoryBriefDTOList.add(
                this.categoryBriefBeanToCategoryBriefDTO(briefData)));

        return categoryBriefDTOList;
    }

    @Override
    public ProductBriefDTO detailBeanToBriefDTO(SP02ProductDetailBean bean) {
        if (bean == null) return null;
        ProductBriefDTO dto = new ProductBriefDTO();

        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setPrice(bean.getPrice());
        dto.setImageUrl(bean.getImageUrl());

        return dto;
    }

    @Override
    public ProductBriefDTO detailBeanToBriefDTO(SP17ProductDetailBean bean) {
        if (bean == null) return null;
        ProductBriefDTO briefDTO = new ProductBriefDTO();

        briefDTO.setId(bean.getId());
        briefDTO.setName(bean.getName());
        briefDTO.setPrice(bean.getPrice());
        briefDTO.setImageUrl(bean.getImage());

        return briefDTO;
    }

    @Override
    public List<ProductBriefDTO> detailBeansToBriefDTOs(List<SP02ProductDetailBean> detailBeanList) {
        if (detailBeanList == null) return null;
        List<ProductBriefDTO> dtoList = new LinkedList<>();

        detailBeanList.forEach(detailBean -> dtoList.add(this.detailBeanToBriefDTO(detailBean)));

        return dtoList;
    }
}
