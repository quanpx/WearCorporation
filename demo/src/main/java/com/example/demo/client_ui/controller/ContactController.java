package com.example.demo.client_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController extends BaseController {

    @GetMapping
    public String getContactPage(Model model) {
        return "contact";
    }
}
