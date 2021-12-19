package com.example.demo.mapping.product;

import com.example.demo.bean.sp02.product.SP02ProductDetailBean;
import com.example.demo.dto.category.CategoryBriefDTO;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;

import java.util.HashMap;
import java.util.List;

public interface ProductMapping {

    ProductBriefDTO briefBeanToBriefDTO(HashMap<String, Object> briefData);
    List<ProductBriefDTO> briefBeansToBriefDTOs(List<HashMap<String, Object>> briefDataList);

    ProductDetailDTO detailBeanToDetailDTO(HashMap<String, Object> detailData);
    ProductDetailDTO detailBeanToDetailDTO(SP02ProductDetailBean detailBean);

    CategoryBriefDTO categoryBriefBeanToCategoryBriefDTO(HashMap<String, Object> briefData);
    List<CategoryBriefDTO> categoryBriefBeansToCategoryBriefDTO(List<HashMap<String, Object>> briefDataList);

    ProductBriefDTO detailBeanToBriefDTO(SP02ProductDetailBean bean);
    List<ProductBriefDTO> detailBeansToBriefDTOs(List<SP02ProductDetailBean> detailBeanList);

}
