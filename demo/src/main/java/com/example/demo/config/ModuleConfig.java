package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("md-config")
public class ModuleConfig {

    private String productTeam;
    private String advertisementTeam;
    private String cartTeam;
    private String accountTeam;
    private String inventoryTeam;
    private String deliveryTeam;
    private String sysManagementTeam;
    private String customerCareTeam;
    private String searchAndReportTeam;
    private String orderTeam;
}
