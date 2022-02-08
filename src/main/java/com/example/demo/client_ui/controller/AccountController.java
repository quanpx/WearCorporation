package com.example.demo.client_ui.controller;

import com.example.demo.client_ui.dto.account.*;
import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.client_ui.dto.order.OrderBriefDTO;
import com.example.demo.client_ui.dto.order.OrderDetailDTO;
import com.example.demo.config.account.CurrentAccount;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.account.bean.sp14.SP14ErrorBean;
import com.example.demo.module.account.service.AccountService;
import com.example.demo.module.cart.service.CartService;
import com.example.demo.module.order.service.OrderService;
import com.example.demo.module.system_management.service.SystemManagementService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private CurrentAccount currentAccount;

    @Autowired
    private ModuleConfig moduleConfig;

    private final Map<String, OrderService> orderServiceMap;

    private final Map<String, CartService> cartServiceMap;



    private final Map<String, AccountService> accountServiceMap;

    private final Map<String, SystemManagementService> sysManagementServiceMap;

    @Autowired
    private AccountController(Map<String, OrderService> orderServiceMap,
                              Map<String, AccountService> accountServiceMap,
                              Map<String, SystemManagementService> sysManagementServiceMap,
                              Map<String, CartService> cartServiceMap) {
        this.orderServiceMap = orderServiceMap;
        this.accountServiceMap = accountServiceMap;
        this.sysManagementServiceMap = sysManagementServiceMap;
        this.cartServiceMap = cartServiceMap;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(ModelMap model) {
        AccountLoginFormDTO loginFormDTO = new AccountLoginFormDTO();
        model.addAttribute("loginForm", loginFormDTO);

        return new ModelAndView("login", model);
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("loginForm") AccountLoginFormDTO formDTO,
            ModelMap model, HttpServletRequest request) {
        AccountService accountService = this.accountServiceMap.get(this.moduleConfig.getAccountTeam());
        SystemManagementService systemManagementService = this.sysManagementServiceMap
                .get(this.moduleConfig.getSysManagementTeam());

        AccountDTO accountDTO = accountService.login(formDTO);
        String notice = null;

        if (accountDTO == null)
            notice = "Failed";
        else {

            this.currentAccount.setId(accountDTO.getId());
            this.currentAccount.setEmail(accountDTO.getEmail());
            this.currentAccount.setFullname(accountDTO.getUsername());
            this.currentAccount.setPhone(accountDTO.getPhone());
            this.currentAccount.setRole(systemManagementService.getRole(
                    new UserRole(accountDTO.getId(), AccountRoleDTO.BUYER.getValue())));
            if (this.currentAccount.getRole() == AccountRoleDTO.SALESMAN)
                this.currentAccount.setAdmin(true);
            if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
                notice = "Failed";
        }

        model.addAttribute("notice", notice);
        model.addAttribute("account", this.currentAccount);

        return this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE ?
                new ModelAndView("login", model) : new ModelAndView("redirect:" +
                (request.getHeader("referer").contains("login") ? "/" :
                        request.getHeader("referer")), model);
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        this.currentAccount.setId(null);
        this.currentAccount.setEmail(null);
        this.currentAccount.setRole(AccountRoleDTO.GUEST_ROLE);

        return "redirect:/";
    }

    @GetMapping("/signup")
    public ModelAndView getSignInPage(ModelMap model) {
        AccountRegisterFormDTO registerFormDTO = new AccountRegisterFormDTO();
        model.addAttribute("registerForm", registerFormDTO);

        return new ModelAndView("signup", model);
    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute("registerForm") AccountRegisterFormDTO formDTO,
            ModelMap model) {
        AccountService accountService = this.accountServiceMap.get(this.moduleConfig.getAccountTeam());
        SystemManagementService systemManagementService = this.sysManagementServiceMap
                .get(this.moduleConfig.getSysManagementTeam());
        AccountDTO accountDTO=null;
        Object obj=accountService.signup(formDTO);
        if(obj instanceof AccountDTO) {
            accountDTO = (AccountDTO) obj;
        }else if(obj instanceof SP14ErrorBean)
        {
            SP14ErrorBean sp14ErrorBean=(SP14ErrorBean) obj;
            System.out.println(sp14ErrorBean);
            model.addAttribute("message",sp14ErrorBean.getMessage());
            List<String> errors=new ArrayList<>();
            for (Map.Entry<String,List<String>> entry:sp14ErrorBean.getErrors().entrySet())
            {
                 errors.add(entry.getValue().get(0));
            }
            model.addAttribute("errors",errors);

        }

        if (accountDTO == null) {
            model.addAttribute("notice", accountDTO);
            return new ModelAndView("signup", model);
        }

        CartService cartService = cartServiceMap.get(this.moduleConfig.getCartTeam());
        cartService.createCart(new UserDTO(accountDTO.getId()));

        if (systemManagementService.setRole(new UserRole(accountDTO.getId(), AccountRoleDTO.BUYER.getValue()))==null) {
            model.addAttribute("notice", "Failed to set role for user");
            return new ModelAndView("signup", model);
        }

        model.addAttribute("loginForm", new AccountLoginFormDTO());
        return new ModelAndView("redirect:/account/login", model);
    }

    @GetMapping("/address")
    public ModelAndView getAddressPage(ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        return new ModelAndView("address", model);
    }

    @GetMapping("/profile")
    public ModelAndView getProfilePage(ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        ModelAndView mv = new ModelAndView();
        mv.addObject("profile", this.currentAccount);
        mv.setViewName("profile");

        return mv;
    }

    @GetMapping("/orders")
    public ModelAndView getOrderPage(ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        OrderService orderService = this.orderServiceMap.get(this.moduleConfig.getOrderTeam());

        List<OrderBriefDTO> orderBriefDTOList =
                orderService.getAllOrderDTOByUserId(this.currentAccount.getId());
        if (orderBriefDTOList != null)
            model.addAttribute("orderList", orderBriefDTOList);

        return new ModelAndView("order", model);
    }

    @GetMapping("/orders/{id}")
    public ModelAndView getOrderDetailPage(@PathVariable Integer id, ModelMap model) {
        if (this.currentAccount.getRole() == AccountRoleDTO.GUEST_ROLE)
            return new ModelAndView("redirect:/account/login", model);

        OrderService orderService = this.orderServiceMap.get(this.moduleConfig.getOrderTeam());

        OrderDetailDTO orderDetailDTO = orderService.getOrderDTOById(id);
        if (orderDetailDTO != null)
            model.addAttribute("order", orderDetailDTO);

        return new ModelAndView("order-detail", model);
    }

}
