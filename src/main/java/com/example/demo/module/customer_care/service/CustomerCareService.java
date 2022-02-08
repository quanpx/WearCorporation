package com.example.demo.module.customer_care.service;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.bean.sp21.SP21FeedBackBean;

import java.util.List;

public interface CustomerCareService {

    List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId);

    String sendFeedback(FeedbackDTO feedbackDTO);

    String sendComment(ProductReviewDTO productReviewDTO);
}
