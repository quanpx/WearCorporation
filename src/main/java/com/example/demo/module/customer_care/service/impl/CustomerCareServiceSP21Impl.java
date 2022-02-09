package com.example.demo.module.customer_care.service.impl;

import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.module.customer_care.bean.sp21.SP21FeedBackBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ResponseCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ResponseFeedbackBean;
import com.example.demo.module.customer_care.mapping.CustomerCareMapping;
import com.example.demo.module.customer_care.proxies.CustomerCareSP21WebServiceProxy;
import com.example.demo.module.customer_care.service.CustomerCareService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("sp21-customer-care")
@Slf4j
public class CustomerCareServiceSP21Impl implements CustomerCareService {


    @Autowired
    private CurrentAccount currentAccount;

    private final CustomerCareMapping customerCareMapping;
    private final CustomerCareSP21WebServiceProxy webServiceProxy;


    @Autowired
    private CustomerCareServiceSP21Impl(CustomerCareMapping customerCareMapping,
                                        CustomerCareSP21WebServiceProxy webServiceProxy) {
        this.customerCareMapping = customerCareMapping;
        this.webServiceProxy = webServiceProxy;
    }

    @Override
    public List<ProductReviewDTO> getAllProductReviewByProductId(Integer productId) {
        List<SP21ProductCommentBean> commentBeanList = null;
        try {
            commentBeanList = this.webServiceProxy.getAllCommentByProductId(productId);
        } catch (Exception ignore) {
            return null;
        }

        if (commentBeanList == null || commentBeanList.isEmpty()) return null;
        List<ProductReviewDTO> reviewDTOList = new LinkedList<>();

        for (SP21ProductCommentBean commentBean : commentBeanList) {
            ProductReviewDTO reviewDTO = this.customerCareMapping.commentBeanToReviewDTO(commentBean);
            if (reviewDTO != null) reviewDTOList.add(reviewDTO);
        }

        return reviewDTOList;
    }

    @Override
    public String sendFeedback(FeedbackDTO feedbackDTO) {

        try
        {
            SP21FeedBackBean sp21FeedBackBean=this.customerCareMapping.feedBackDtoToBean(feedbackDTO);
            sp21FeedBackBean.setUserId(currentAccount.getId());
            sp21FeedBackBean.setId(25);
            SP21ResponseFeedbackBean sp21Response=this.webServiceProxy.sendFeedback(sp21FeedBackBean);
            System.out.println(sp21Response);
            return sp21Response.getSuccess();
        }catch (Exception ex)
        {
            log.error(ex.getMessage(),ex.getCause());
            return null;
        }
    }

    @Override
    public String sendComment(ProductReviewDTO productReviewDTO) {
        try
        {
            SP21ProductCommentBean sp21ProductCommentBean=this.customerCareMapping.commentDtoToBean(productReviewDTO);
            sp21ProductCommentBean.setComment(productReviewDTO.getContent());
            sp21ProductCommentBean.setProductId(productReviewDTO.getProductId());
            sp21ProductCommentBean.setUserId(currentAccount.getId());
            sp21ProductCommentBean.setPhoto("NULL");
            SP21ResponseCommentBean sp21ResponseCommentBean = this.webServiceProxy.sendComment(sp21ProductCommentBean.getProductId(), sp21ProductCommentBean);
            System.out.println();
            return  sp21ResponseCommentBean.getSuccess();

        }catch (Exception ex)
        {
            log.error(ex.getMessage(),ex.getCause());
            return null;
        }
    }

}
