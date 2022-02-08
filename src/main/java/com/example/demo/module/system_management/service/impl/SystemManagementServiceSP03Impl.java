package com.example.demo.module.system_management.service.impl;

import com.example.demo.client_ui.dto.account.AccountRoleDTO;
import com.example.demo.client_ui.dto.account.UserRoleDTO;
import com.example.demo.client_ui.dto.config.ThemeDTO;
import com.example.demo.client_ui.dto.config.ThemeRequest;
import com.example.demo.config.module.ModuleConfig;
import com.example.demo.module.account.bean.UserRole;
import com.example.demo.module.system_management.bean.sp03.ModuleCode;
import com.example.demo.module.system_management.bean.sp03.SP03ModuleBean;
import com.example.demo.module.system_management.bean.sp03.SP03RoleConfigBean;
import com.example.demo.module.system_management.bean.sp03.SP03ThemeConfigBean;
import com.example.demo.module.system_management.bean.sp03.TeamCode;
import com.example.demo.module.system_management.mapping.SystemManagementMapping;
import com.example.demo.module.system_management.proxies.SystemManagementSP03WebServiceProxy;
import com.example.demo.module.system_management.service.SystemManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sp03-sys-management")
@Slf4j
public class SystemManagementServiceSP03Impl implements SystemManagementService {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ModuleConfig moduleConfig;

    @Autowired
    private SystemManagementMapping systemManagementMapping;

    @Autowired
    private SystemManagementSP03WebServiceProxy webServiceProxy;

    @Override
    public AccountRoleDTO getRoleByEmail(String email) {
        return null;
    }

    @Override
    public AccountRoleDTO getRole(UserRole userRole) {
         try {
             SP03RoleConfigBean configBean = this.webServiceProxy.getRole(userRole);
             if (configBean == null)
                 return AccountRoleDTO.GUEST_ROLE;

             if (configBean.getRole() == 0) return AccountRoleDTO.BUYER;
             if (configBean.getRole() == 1) return AccountRoleDTO.SALESMAN;
             if (configBean.getRole() == 2) return AccountRoleDTO.IT_TECHNICIAN;
             if (configBean.getRole() == 3) return AccountRoleDTO.SHIPPING_MANAGER;
         } catch (Exception e) {
             log.error(e.getMessage(), e.getCause());
             return AccountRoleDTO.GUEST_ROLE;
         }
         return AccountRoleDTO.GUEST_ROLE;
    }

    @Override
    public UserRoleDTO setRole(UserRole userRole) {

        try {
            SP03RoleConfigBean configBean = this.webServiceProxy.setRole(userRole);
            return objectMapper.convertValue(configBean, UserRoleDTO.class);
        } catch (Exception ignore) {
            log.error(ignore.getMessage(), ignore.getCause());
            return null;
        }

    }

    @Override
    public ThemeDTO getTheme(ThemeRequest themeRequest) {
        try {
            SP03ThemeConfigBean configBean = this.webServiceProxy.getConfig(themeRequest);
            ThemeDTO themeDTO = new ThemeDTO();
            themeDTO.setFontSize(configBean.getFontSize());
            themeDTO.setLanguage(configBean.getLanguage());
            themeDTO.setTheme(configBean.getTheme());
            themeDTO.setUserId(configBean.getUserId());
            return themeDTO;
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
            return null;
        }

    }

    @Override
    public String getTeamName(ModuleCode moduleCode) {
        try {
            SP03ModuleBean bean=new SP03ModuleBean();
            bean.setModule(moduleCode.getValue());
            List<Map<String, Object>> res = this.webServiceProxy.getModule(bean);
            System.out.println(res);
            if (res == null || res.isEmpty()) return null;
            Map<String, Object> data = res.get(0);
            if (!data.containsKey("team_code")) return null;

            for (TeamCode teamCode : TeamCode.values())
                if (teamCode.getValue().equals(data.get("team_code")))
                    return this.systemManagementMapping.teamCodeToTeamName(teamCode);
        } catch (Exception e) {
            return null;
        }

        return null;
    }

    @Override
    public void loadModules(ModuleCode... moduleCodes) {
        if (moduleCodes == null || moduleCodes.length == 0)
            moduleCodes = ModuleCode.values();

        for (ModuleCode moduleCode : moduleCodes) {
            String moduleName = this.systemManagementMapping.moduleCodeToModuleName(moduleCode);
            if (moduleName == null) continue;
            String teamName = this.getTeamName(moduleCode);
            if (teamName == null) continue;
            this.moduleConfig.setTeamForModule(moduleName, teamName);
        }
    }

    @Override
    public String setModule(ModuleCode moduleCode, String teamName) {
        String module = this.systemManagementMapping.moduleCodeToModuleName(moduleCode);
        if (module == null) return "Failed";
        TeamCode teamCode = this.systemManagementMapping.teamNameToTeamCode(teamName);
        if (teamCode == null) return "Failed";

        if (teamCode == TeamCode.SP02) {
            this.moduleConfig.setTeamForModule(module, teamName);
            return "Success!";
        }

        Map<String, Object> params = new HashMap<>();
        params.put("module", moduleCode.getValue());
        params.put("team_code", teamCode.getValue());

        try {
            Map<String, Object> res = this.webServiceProxy.setModule(params);
            if (res != null && res.get("Message").equals("Success!")) {
                this.moduleConfig.setTeamForModule(module, teamName);
                return "Success";
            }
        } catch (Exception e) {
            return "Failed";
        }

        return "Failed";
    }
}
