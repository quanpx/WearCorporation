package com.example.demo.module.search_and_report.mapping.impl;

import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.module.search_and_report.bean.sp04.SP04ProductBean;
import com.example.demo.module.search_and_report.mapping.SearchAndReportMapping;
import org.springframework.stereotype.Component;

@Component
public class SearchAndReportMappingImpl implements SearchAndReportMapping {

    @Override
    public ProductBriefDTO productBeanToProductBriefDTO(SP04ProductBean productBean) {
        if (productBean == null) return null;
        ProductBriefDTO briefDTO = new ProductBriefDTO();

        briefDTO.setId(productBean.getId());
        briefDTO.setPrice(productBean.getPrice());
        briefDTO.setName(productBean.getName());
        briefDTO.setImageUrl(productBean.getImage());

        return briefDTO;
    }
}
