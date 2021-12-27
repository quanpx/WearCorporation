package com.example.demo.client_ui.controller;

import com.example.demo.config.ModuleConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected ModuleConfig moduleConfig;
}
