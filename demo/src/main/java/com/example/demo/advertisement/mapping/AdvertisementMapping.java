package com.example.demo.advertisement.mapping;

import com.example.demo.client_ui.dto.advertisement.AdvertisementBriefDTO;

import java.util.HashMap;
import java.util.List;

public interface AdvertisementMapping {

    AdvertisementBriefDTO beanToBriefDTO(HashMap<String, Object> bean);
    List<AdvertisementBriefDTO> beansToBriefDTOs(List<HashMap<String, Object>> beans);
}
