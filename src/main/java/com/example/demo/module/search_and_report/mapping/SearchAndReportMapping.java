package com.example.demo.module.search_and_report.mapping;

import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.module.search_and_report.bean.sp04.SP04ProductBean;

public interface SearchAndReportMapping {

    ProductBriefDTO productBeanToProductBriefDTO(SP04ProductBean productBean);
}
