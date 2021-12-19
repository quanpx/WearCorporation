package com.example.demo.service.product;

import com.example.demo.dto.category.CategoryBriefDTO;
import com.example.demo.dto.product.ProductBriefDTO;
import com.example.demo.dto.product.ProductDetailDTO;

import java.util.List;

public interface ProductService {

    ProductDetailDTO getProductDetailDTOById(Long productId);
    List<ProductBriefDTO> getAllProductBriefDTO();

    List<CategoryBriefDTO> getAllCategories();
}
