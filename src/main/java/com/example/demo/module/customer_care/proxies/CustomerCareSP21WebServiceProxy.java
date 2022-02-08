package com.example.demo.module.customer_care.proxies;

import com.example.demo.module.customer_care.bean.sp21.SP21FeedBackBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ResponseCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ResponseFeedbackBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "sp21-api", url = "http://it4492sp21.herokuapp.com")
public interface CustomerCareSP21WebServiceProxy {

    @GetMapping("/product/{id}/comment")
    List<SP21ProductCommentBean> getAllCommentByProductId(@PathVariable("id") Integer productId);

    @PostMapping("/feedback")
    SP21ResponseFeedbackBean sendFeedback(@RequestBody SP21FeedBackBean sp21FeedBackBean);

    @PostMapping("/product/{id}/comment")
    SP21ResponseCommentBean sendComment(@PathVariable("id") Integer productId, @RequestBody SP21ProductCommentBean sp21ProductCommentBean);


}
