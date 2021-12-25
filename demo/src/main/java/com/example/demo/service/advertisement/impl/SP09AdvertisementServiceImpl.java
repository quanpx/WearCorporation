package com.example.demo.service.advertisement.impl;

import com.example.demo.bean.sp09.SP09ResponseBean;
import com.example.demo.dto.advertisement.AdvertisementBriefDTO;
import com.example.demo.mapping.advertisement.AdvertisementMapping;
import com.example.demo.proxies.advertisement.SP09AdvertisementWebServiceProxy;
import com.example.demo.service.advertisement.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("sp09")
public class SP09AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private SP09AdvertisementWebServiceProxy webServiceProxy;

    @Autowired
    private AdvertisementMapping advertisementMapping;

    @Override
    public List<AdvertisementBriefDTO> getAllAdvertisementBriefDTOs() {
        SP09ResponseBean<List<HashMap<String, Object>>> response =
                this.webServiceProxy.getAllAdvertisements();

        return response.getStatusCode() == 200 ?
                this.advertisementMapping.beansToBriefDTOs(response.getData()) : null;
    }
}
