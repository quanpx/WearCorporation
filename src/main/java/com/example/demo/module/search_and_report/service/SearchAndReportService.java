package com.example.demo.module.search_and_report.service;

import com.example.demo.client_ui.dto.product.ProductBriefDTO;

import java.util.List;

public interface SearchAndReportService {

    List<ProductBriefDTO> searchProduct(String keyword);
}
