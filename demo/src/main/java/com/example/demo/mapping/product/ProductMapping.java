package com.example.demo.mapping.product;

import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;

import java.util.HashMap;
import java.util.List;

public interface ProductMapping {

    ProductBriefDTO briefBeanToBriefDTO(HashMap<String, Object> briefData);

    List<ProductBriefDTO> briefBeansToBriefDTOs(List<HashMap<String, Object>> briefDataList);

    ProductDetailDTO detailBeanToDetailDTO(HashMap<String, Object> detailData);

}
