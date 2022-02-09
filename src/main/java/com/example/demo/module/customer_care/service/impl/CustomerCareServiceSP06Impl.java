package com.example.demo.module.customer_care.service.impl;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.module.customer_care.bean.sp06.SP06ProductCommentBean;
import com.example.demo.module.customer_care.bean.sp06.SP06ResponseCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ResponseCommentBean;
import com.example.demo.module.customer_care.mapping.CustomerCareMapping;
import com.example.demo.module.customer_care.proxies.CustomerCareSP06WebServiceProxy;
import com.example.demo.module.customer_care.proxies.CustomerCareSP21WebServiceProxy;
import com.example.demo.module.customer_care.service.CustomerCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


import java.util.LinkedList;
import java.util.List;

@Service("sp06-customer-care")
@Slf4j

public class CustomerCareServiceSP06Impl implements CustomerCareService {
    @Autowired
    private CurrentAccount currentAccount;

    private final CustomerCareMapping customerCareMapping;
    private final CustomerCareSP06WebServiceProxy webServiceProxy;


    @Autowired
    private CustomerCareServiceSP06Impl(CustomerCareMapping customerCareMapping,
                                        CustomerCareSP06WebServiceProxy webServiceProxy) {
        this.customerCareMapping = customerCareMapping;
        this.webServiceProxy = webServiceProxy;
    }
    @Override
    public List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId) {
        List<SP06ProductCommentBean> commentBeanList = null;
        try {
            commentBeanList = this.webServiceProxy.getAllCommentByProductId(productId);
        } catch (Exception ignore) {
            return null;
        }

        if (commentBeanList == null || commentBeanList.isEmpty()) return null;
        List<ProductReviewDTO> reviewDTOList = new LinkedList<>();

        for (SP06ProductCommentBean commentBean : commentBeanList) {
            ProductReviewDTO reviewDTO = this.customerCareMapping.commentBeanToReviewDTOSP06(commentBean);
            if (reviewDTO != null) reviewDTOList.add(reviewDTO);
        }

        return reviewDTOList;
    }

    @Override
    public String sendFeedback(FeedbackDTO feedbackDTO) {
        return null;
    }

    @Override
    public String sendComment(ProductReviewDTO productReviewDTO) {
        try
        {
            SP06ProductCommentBean sp06ProductCommentBean=this.customerCareMapping.commentDtoToBeanSP06(productReviewDTO);
            sp06ProductCommentBean.setComment(productReviewDTO.getContent());
            sp06ProductCommentBean.setProductId(productReviewDTO.getProductId());
            sp06ProductCommentBean.setUserId(currentAccount.getId());
            sp06ProductCommentBean.setPhoto("NULL");
            SP06ResponseCommentBean sp06ResponseCommentBean = this.webServiceProxy.sendComment(sp06ProductCommentBean.getProductId(), sp06ProductCommentBean);
            return  sp06ResponseCommentBean.getSuccess();

        }catch (Exception ex)
        {
            log.error(ex.getMessage(),ex.getCause());
            return null;
        }
    }
}
