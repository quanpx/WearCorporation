package com.example.demo.client_ui.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserDTO;
import com.example.demo.client_ui.dto.cart.CartDTO;
import com.example.demo.client_ui.dto.checkout.CheckoutDTO;
import com.example.demo.client_ui.dto.checkout.PaymentInfo;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.order.bean.OrderRequestBean;
import com.example.demo.module.order.mapping.OrderMapping;
import com.example.demo.module.order.service.OrderService;
import com.example.demo.module.payment.bean.SP10PaymentResponseBean;
import com.example.demo.module.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class PaymentController {

    private PaymentInfo paymentInfo;

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private OrderMapping orderMapping;

    @Autowired
    private Map<String, CartService> cartServiceMap;

    @Autowired
    private Map<String, OrderService> orderServiceMap;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment-confirmation")
    public String getPaymentConfirmationPage(@ModelAttribute("checkoutForm") CheckoutDTO checkoutDTO, ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        OrderService orderService = orderServiceMap.get(this.moduleConfig.getOrderTeam());

        CartService cartService = cartServiceMap.get(this.moduleConfig.getCartTeam());
        CartDTO cartDTO= cartService.getCartByAccountId(new UserDTO(this.currentAccount.getId()));

        OrderRequestBean orderRequestBean=orderMapping.dtoToOrderRequest(checkoutDTO, cartDTO);
        orderRequestBean.setUserId(this.currentAccount.getId());
        OrderDetailDTO orderDetailDTO=orderService.createOrder(orderRequestBean);


       // Save payment info
        if (!checkoutDTO.getPaymentMethod().equals("cod")) {

            PaymentInfo payment = new PaymentInfo();
            payment.setCardNumber(checkoutDTO.getCardNumber());
            payment.setName(checkoutDTO.getCardHolder());
            payment.setCvv(checkoutDTO.getCvv());
            payment.setType(checkoutDTO.getPaymentMethod());
            payment.setExpired(checkoutDTO.getExpiredDate());
            payment.setMoney(orderDetailDTO.getTotalPrice());
            this.paymentInfo = payment;
        }

        model.addAttribute("order", orderDetailDTO);

        return "payment-confirmation";
    }

    @PostMapping("/payment-confirmation")
    public String paymentConfirmation(@ModelAttribute("order") OrderDetailDTO orderDetailDTO, ModelMap model) {

        OrderService orderService = orderServiceMap.get(this.moduleConfig.getOrderTeam());
        CartService cartService = cartServiceMap.get(this.moduleConfig.getCartTeam());
        if (!orderDetailDTO.getPaymentMethod().equals("cod")) {
            SP10PaymentResponseBean responseBean = paymentService.payment(paymentInfo);
            
            String notice = null;
            if (responseBean.getStatus() == 137) {
                notice = responseBean.getMessage();
                model.addAttribute("notEnough", notice);

                return "payment-confirmation";
            }
        }

        // Update order Info
        Map<String,String> update=new HashMap<>();
        update.put("status","active");
         //orderService.updateOrder(orderDetailDTO.getOrderId(), updateOrder);

        RestTemplate rest=new RestTemplate();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(30000);
        factory.setReadTimeout(30000);
        rest.setRequestFactory(factory);

        String url = "http://binhnguyen-tech.stackstaging.com/OrderModule/order/"+orderDetailDTO.getOrderId();

        HttpEntity<Map<String,String>> requestUpdate =new HttpEntity<>(update);
        rest.exchange(url, HttpMethod.PATCH, requestUpdate,String.class);
        cartService.resetCart(new UserDTO(this.currentAccount.getId()));

        return "redirect:/payment-successful";
    }

    @GetMapping("/payment-successful")
    public String getPaymentSuccessfulPage(Model model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return "redirect:/account/login";

        return "payment-successful";
    }


}
