package com.example.demo.module.system_management.service;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;

public interface SystemManagementService {

    AccountRoleDTO getRole(String username);
}