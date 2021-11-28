package com.example.demo.controller;

import com.example.demo.dto.ProductDetailDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String displayProductList(Model model) {
        return "product-list";
    }

    @GetMapping("/{id}")
    public String displayProductDetail(@PathVariable Long id, Model model) {
        ProductDetailDTO productDetailDTO = this.productService.getProductDetailDTOById(id);
        // get more similar products

        model.addAttribute("product", productDetailDTO);

        return "product-detail";
    }

}
