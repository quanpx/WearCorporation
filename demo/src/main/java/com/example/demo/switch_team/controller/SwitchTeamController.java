package com.example.demo.switch_team.controller;

import com.example.demo.switch_team.service.SwitchTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/admin/switch-team")
public class SwitchTeamController {

    @Autowired
    private SwitchTeamService switchTeamService;

    @GetMapping
    public List<String> switchTeam(
            @RequestParam(value = "product-team", required = false) String productTeam,
            @RequestParam(value = "order-team", required = false) String orderTeam,
            @RequestParam(value = "cart-team", required = false) String cartTeam,
            @RequestParam(value = "account-team", required = false) String accountTeam,
            @RequestParam(value = "delivery-team", required = false) String deliveryTeam,
            @RequestParam(value = "advertisement-team", required = false) String advertisementTeam,
            @RequestParam(value = "sys-management-team", required = false) String sysManagementTeam,
            @RequestParam(value = "customer-care-team", required = false) String customerCareTeam,
            @RequestParam(value = "inventory-team", required = false) String inventoryTeam,
            @RequestParam(value = "search-and-report-team", required = false) String searchAndReportTeam
    ) {
        List<String> response = new LinkedList<>();
        if (productTeam != null)
            response.add(this.switchTeamService.switchProductTeam(productTeam));
        if (orderTeam != null)
            response.add(this.switchTeamService.switchOrderTeam(orderTeam));
        if (cartTeam != null)
            response.add(this.switchTeamService.switchCartTeam(cartTeam));
        if (accountTeam != null)
            response.add(this.switchTeamService.switchAccountTeam(accountTeam));
        if (deliveryTeam != null)
            response.add(this.switchTeamService.switchDeliveryTeam(deliveryTeam));
        if (advertisementTeam != null)
            response.add(this.switchTeamService.switchAdvertisementTeam(advertisementTeam));
        if (sysManagementTeam != null)
            response.add(this.switchTeamService.switchSystemManagementTeam(sysManagementTeam));
        if (customerCareTeam != null)
            response.add(this.switchTeamService.switchCustomerCareTeam(customerCareTeam));
        if (inventoryTeam != null)
            response.add(this.switchTeamService.switchInventoryTeam(inventoryTeam));
        if (searchAndReportTeam != null)
            response.add(this.switchTeamService.switchSearchAndReportTeam(searchAndReportTeam));

        return response;
    }
}
