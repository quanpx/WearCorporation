package com.example.demo.module.customer_care.service.impl;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.service.CustomerCareService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sp06-customer-care")
public class CustomerCareServiceSP06Impl implements CustomerCareService {

    @Override
    public List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId) {
        return null;
    }

    @Override
    public String sendFeedback(FeedbackDTO feedbackDTO) {
        return null;
    }

    @Override
    public String sendComment(ProductReviewDTO productReviewDTO) {
        return null;
    }
}
