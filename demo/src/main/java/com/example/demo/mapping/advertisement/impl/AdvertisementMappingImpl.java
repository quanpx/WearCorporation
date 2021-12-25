package com.example.demo.mapping.advertisement.impl;

import com.example.demo.bean.sp09.advertisement.SP09AdvertisementBean;
import com.example.demo.dto.advertisement.AdvertisementBriefDTO;
import com.example.demo.mapping.advertisement.AdvertisementMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class AdvertisementMappingImpl implements AdvertisementMapping {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AdvertisementBriefDTO beanToBriefDTO(HashMap<String, Object> data) {
        if (data == null) return null;
        SP09AdvertisementBean bean =
                this.objectMapper.convertValue(data, SP09AdvertisementBean.class);
        AdvertisementBriefDTO dto = new AdvertisementBriefDTO();

        dto.setId(bean.getId());
        dto.setAdvUrl(bean.getAdvUrl());
        dto.setContent(bean.getContent());
        dto.setTitle(bean.getTitle());
        dto.setImageUrl(bean.getImageUrl());

        return dto;
    }

    @Override
    public List<AdvertisementBriefDTO> beansToBriefDTOs(List<HashMap<String, Object>> data) {
        if (data == null) return null;
        List<AdvertisementBriefDTO> dtoList = new LinkedList<>();

        data.forEach(d -> dtoList.add(this.beanToBriefDTO(d)));

        return dtoList;
    }
}
