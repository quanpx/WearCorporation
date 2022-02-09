package com.example.demo.module.customer_care.proxies;

import com.example.demo.module.customer_care.bean.sp06.SP06ProductCommentBean;
import com.example.demo.module.customer_care.bean.sp06.SP06ResponseCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ProductCommentBean;
import com.example.demo.module.customer_care.bean.sp21.SP21ResponseCommentBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "sp06-api", url = "http://ltct-laravel.herokuapp.com/api")

public interface CustomerCareSP06WebServiceProxy {
    @GetMapping("/products/{id}/comment")
    List<SP06ProductCommentBean> getAllCommentByProductId(@PathVariable("id") Integer productId);

    @PostMapping("/products/{id}/comment")
    SP06ResponseCommentBean sendComment(@PathVariable("id") Integer productId, @RequestBody SP06ProductCommentBean sp06ProductCommentBean);
}
