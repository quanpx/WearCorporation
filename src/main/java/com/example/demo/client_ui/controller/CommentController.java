package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.feedback.FeedbackDTO;
import com.example.demo.client_ui.dto.product.ProductReviewDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.customer_care.service.CustomerCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class CommentController {
    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private Map<String, CustomerCareService> customerCareServiceMap;

    @GetMapping
    public ModelAndView getFeedback()
    {
        if (currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login");
        ModelAndView mv = new ModelAndView();
        mv.addObject("feedback",new FeedbackDTO());
        mv.setViewName("contact");
        return mv;

    }
//    @PostMapping("/{id}/comment")
//    public String sendComment(@PathVariable Integer id, @ModelAttribute("comment") ProductReviewDTO productReviewDTO)
//    {
////        if (currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
////            return new ModelAndView("redirect:/account/login");
//
//        ModelAndView mv=new ModelAndView();
////        CustomerCareService customerCareService=customerCareServiceMap.get(moduleConfig.getCustomerCareTeam());
////        String message=customerCareService.sendFeedback(feedbackDTO);
//        String message = productReviewDTO.getContent();
//        System.out.println(message);
//        return "product-detail";
//    }
}
