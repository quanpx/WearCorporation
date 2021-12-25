package com.example.demo.mapping.advertisement;

import com.example.demo.dto.advertisement.AdvertisementBriefDTO;

import java.util.HashMap;
import java.util.List;

public interface AdvertisementMapping {

    AdvertisementBriefDTO beanToBriefDTO(HashMap<String, Object> bean);
    List<AdvertisementBriefDTO> beansToBriefDTOs(List<HashMap<String, Object>> beans);
}
