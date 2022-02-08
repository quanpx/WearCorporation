package com.example.demo.module.customer_care.mapping.impl;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.bean.sp21.SP21FeedBackBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.mapping.CustomerCareMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerCareMappingImpl implements CustomerCareMapping {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ProductReviewDTO commentBeanToReviewDTO(SP21ProductCommentBean commentBean) {
        if (commentBean == null) return null;
        ProductReviewDTO reviewDTO = new ProductReviewDTO();

        reviewDTO.setReviewId(commentBean.getId());
        reviewDTO.setContent(commentBean.getComment());
        reviewDTO.setDate(commentBean.getCreatedAt());
        reviewDTO.setUserId(commentBean.getUserId());

        return reviewDTO;
    }

    @Override
    public SP21FeedBackBean feedBackDtoToBean(FeedbackDTO feedbackDTO) {
        SP21FeedBackBean sp21FeedBackBean=new SP21FeedBackBean();
        sp21FeedBackBean.setContent(feedbackDTO.getContent());
        return sp21FeedBackBean;
    }

    @Override
    public SP21ProductCommentBean commentDtoToBean(ProductReviewDTO productReviewDTO) {
        SP21ProductCommentBean sp21ProductCommentBean = new SP21ProductCommentBean();
        sp21ProductCommentBean.setComment((productReviewDTO.getContent()));
        return sp21ProductCommentBean;
    }
}
