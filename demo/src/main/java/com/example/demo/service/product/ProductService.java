package com.example.demo.service.product;

import com.example.demo.dto.product.ProductDetailDTO;

public interface ProductService {

    ProductDetailDTO getProductDetailDTOById(Long productId);

}
