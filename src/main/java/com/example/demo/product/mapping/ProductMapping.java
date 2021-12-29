package com.example.demo.product.mapping;

import com.example.demo.client_ui.dto.category.CategoryDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;
import com.example.demo.product.bean.sp17.SP17ProductDetailBean;

import java.util.HashMap;
import java.util.List;

public interface ProductMapping {

    ProductBriefDTO briefBeanToBriefDTO(HashMap<String, Object> briefData);
    List<ProductBriefDTO> briefBeansToBriefDTOs(List<HashMap<String, Object>> briefDataList);

    ProductDetailDTO detailBeanToDetailDTO(HashMap<String, Object> detailData);
    ProductDetailDTO detailBeanToDetailDTO(SP17ProductDetailBean detailBean);

    CategoryDTO categoryBriefBeanToCategoryBriefDTO(HashMap<String, Object> briefData);
    List<CategoryDTO> categoryBriefBeansToCategoryBriefDTO(List<HashMap<String, Object>> briefDataList);

    ProductBriefDTO detailBeanToBriefDTO(SP17ProductDetailBean bean);

    ProductBriefDTO detailDTOToBriefDTO(ProductDetailDTO detailDTO);
}
