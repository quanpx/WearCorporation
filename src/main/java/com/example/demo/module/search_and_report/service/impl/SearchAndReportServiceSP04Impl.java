package com.example.demo.module.search_and_report.service.impl;

import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.module.search_and_report.bean.sp04.SP04ProductBean;
import com.example.demo.module.search_and_report.mapping.SearchAndReportMapping;
import com.example.demo.module.search_and_report.proxies.SearchAndReportSP04WebServiceProxy;
import com.example.demo.module.search_and_report.service.SearchAndReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("sp04-search-and-report")
public class SearchAndReportServiceSP04Impl implements SearchAndReportService {

    @Autowired
    private SearchAndReportSP04WebServiceProxy sp04WebServiceProxy;

    @Autowired
    private SearchAndReportMapping searchAndReportMapping;

    @Override
    public List<ProductBriefDTO> searchProduct(String keyword) {

        try {
            List<SP04ProductBean> sp04ProductBeanList = this.sp04WebServiceProxy.searchProduct(keyword);
            if (sp04ProductBeanList == null) return null;
            List<ProductBriefDTO> productBriefDTOList = new LinkedList<>();
            for (SP04ProductBean sp04ProductBean : sp04ProductBeanList) {
                ProductBriefDTO briefDTO =
                        this.searchAndReportMapping.productBeanToProductBriefDTO(sp04ProductBean);
                if (briefDTO != null) productBriefDTOList.add(briefDTO);
            }

            return productBriefDTOList;
        } catch (Exception ignore) {
            return null;
        }
    }
}
