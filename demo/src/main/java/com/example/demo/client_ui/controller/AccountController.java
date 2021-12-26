package com.example.demo.client_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    @GetMapping
    public String getAccountPage(Model model) {
        return "account";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }

}
