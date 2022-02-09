package com.example.demo.module.customer_care.mapping.impl;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.module.customer_care.bean.sp06.SP06FeedBackBean;
import com.example.demo.module.customer_care.bean.sp06.SP06ProductCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21FeedBackBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.mapping.CustomerCareMapping;

public class CustomerCareMappingImplSP06 implements CustomerCareMapping {

    @Override
    public ProductReviewDTO commentBeanToReviewDTO(SP21ProductCommentBean commentBean) {
        return null;
    }

    @Override
    public SP21FeedBackBean feedBackDtoToBean(FeedbackDTO feedbackDTO) {
        return null;
    }

    @Override
    public SP21ProductCommentBean commentDtoToBean(ProductReviewDTO productReviewDTO) {
        return null;
    }

    @Override
    public ProductReviewDTO commentBeanToReviewDTOSP06(SP06ProductCommentBean commentBean) {
        if (commentBean == null) return null;
        ProductReviewDTO reviewDTO = new ProductReviewDTO();

        reviewDTO.setReviewId(commentBean.getId());
        reviewDTO.setContent(commentBean.getComment());
        reviewDTO.setDate(commentBean.getDate());
        reviewDTO.setUserId(commentBean.getUserId());

        return reviewDTO;
    }

    @Override
    public SP06FeedBackBean feedBackDtoToBeanSP06(FeedbackDTO feedbackDTO) {
        return null;
    }

    @Override
    public SP06ProductCommentBean commentDtoToBeanSP06(ProductReviewDTO productReviewDTO) {
        SP06ProductCommentBean sp06ProductCommentBean = new SP06ProductCommentBean();
        sp06ProductCommentBean.setComment((productReviewDTO.getContent()));
        return sp06ProductCommentBean;
    }
}
