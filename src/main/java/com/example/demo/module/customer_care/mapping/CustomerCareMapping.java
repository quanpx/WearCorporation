package com.example.demo.module.customer_care.mapping;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.bean.sp21.SP21FeedBackBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;

public interface CustomerCareMapping {

    ProductReviewDTO commentBeanToReviewDTO(SP21ProductCommentBean commentBean);

    SP21FeedBackBean feedBackDtoToBean(FeedbackDTO feedbackDTO);

    SP21ProductCommentBean commentDtoToBean(ProductReviewDTO productReviewDTO);
}
