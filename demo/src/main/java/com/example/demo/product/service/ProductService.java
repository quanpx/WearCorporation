package com.example.demo.product.service;

import com.example.demo.client_ui.dto.category.CategoryBriefDTO;
import com.example.demo.client_ui.dto.product.ProductBriefDTO;
import com.example.demo.client_ui.dto.product.ProductDetailDTO;

import java.util.List;

public interface ProductService {

    ProductDetailDTO getProductDetailDTOById(Long productId);
    List<ProductBriefDTO> getAllProductBriefDTO();

    List<CategoryBriefDTO> getAllCategories();
}
