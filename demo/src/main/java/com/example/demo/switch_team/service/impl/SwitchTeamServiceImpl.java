package com.example.demo.switch_team.service.impl;

import com.example.demo.config.ModuleConfig;
import com.example.demo.switch_team.service.SwitchTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SwitchTeamServiceImpl implements SwitchTeamService {

    public static final List<String> AVAILABLE_PRODUCT_TEAM = Arrays.asList("sp02", "sp17", "sp11");
    public static final List<String> AVAILABLE_ORDER_TEAM = Arrays.asList("sp02");
    public static final List<String> AVAILABLE_INVENTORY_TEAM = Arrays.asList("sp02");
    public static final List<String> AVAILABLE_ACCOUNT_TEAM = Arrays.asList("sp02");
    public static final List<String> AVAILABLE_CUSTOMER_CARE_TEAM = Arrays.asList("sp02");
    public static final List<String> AVAILABLE_DELIVERY_TEAM = Arrays.asList("sp02");
    public static final List<String> AVAILABLE_ADVERTISEMENT_TEAM = Arrays.asList("sp02", "sp09");
    public static final List<String> AVAILABLE_CART_TEAM = Arrays.asList("sp02");
    public static final List<String> AVAILABLE_SYS_MANAGEMENT_TEAM = Arrays.asList("sp02");
    public static final List<String> AVAILABLE_SEARCH_AND_REPORT_TEAM = Arrays.asList("sp02");

    @Autowired
    private ModuleConfig moduleConfig;

    /**
     *
     * @param productTeam - must not be null
     */
    @Override
    public String switchProductTeam(String productTeam) {
        if (!AVAILABLE_PRODUCT_TEAM.contains(productTeam))
            return "Hệ thống chưa tích hợp Module quản lý sản phẩm với nhóm " + productTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(productTeam))
            return "Hệ thống hiện đang sử dụng Module quản lý sản phầm của nhóm " + productTeam + " rồi ah";

        this.moduleConfig.setProductTeam(productTeam);
        return "Đã chuyển thành công Module quản lý sản phẩm từ " + old + " -> " + productTeam;
    }

    @Override
    public String switchAccountTeam(String accountTeam) {
        if (!AVAILABLE_ACCOUNT_TEAM.contains(accountTeam))
            return "Hệ thống chưa tích hợp Module quản lý tài khoản với nhóm " + accountTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(accountTeam))
            return "Hệ thống hiện đang sử dụng Module quản lý tài khoản của nhóm " + accountTeam + " rồi ah";

        this.moduleConfig.setProductTeam(accountTeam);
        return "Đã chuyển thành công Module quản lý tài khoản từ " + old + " -> " + accountTeam;
    }

    @Override
    public String switchCartTeam(String cartTeam) {
        if (!AVAILABLE_CART_TEAM.contains(cartTeam))
            return "Hệ thống chưa tích hợp Module quản lý giỏ hàng với nhóm " + cartTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(cartTeam))
            return "Hệ thống hiện đang sử dụng Module quản lý giỏ hàng của nhóm " + cartTeam + " rồi ah";

        this.moduleConfig.setProductTeam(cartTeam);
        return "Đã chuyển thành công Module quản lý giỏ hàng từ " + old + " -> " + cartTeam;
    }

    @Override
    public String switchAdvertisementTeam(String advertisementTeam) {
        if (!AVAILABLE_ADVERTISEMENT_TEAM.contains(advertisementTeam))
            return "Hệ thống chưa tích hợp Module quảng cáo - khuyến mãi với nhóm " + advertisementTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(advertisementTeam))
            return "Hệ thống hiện đang sử dụng Module quảng cáo - khuyến mãi của nhóm " + advertisementTeam + " rồi ah";

        this.moduleConfig.setProductTeam(advertisementTeam);
        return "Đã chuyển thành công Module quảng cáo - khuyến mãi từ " + old + " -> " + advertisementTeam;
    }

    @Override
    public String switchCustomerCareTeam(String customerCareTeam) {
        if (!AVAILABLE_CUSTOMER_CARE_TEAM.contains(customerCareTeam))
            return "Hệ thống chưa tích hợp Module chăm sóc khách hàng với nhóm " + customerCareTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(customerCareTeam))
            return "Hệ thống hiện đang sử dụng Module chăm sóc khách hàng của nhóm " + customerCareTeam + " rồi ah";

        this.moduleConfig.setProductTeam(customerCareTeam);
        return "Đã chuyển thành công Module chăm sóc khách hàng từ " + old + " -> " + customerCareTeam;
    }

    @Override
    public String switchInventoryTeam(String inventoryTeam) {
        if (!AVAILABLE_INVENTORY_TEAM.contains(inventoryTeam))
            return "Hệ thống chưa tích hợp Module quản lý kho với nhóm " + inventoryTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(inventoryTeam))
            return "Hệ thống hiện đang sử dụng Module quản lý kho của nhóm " + inventoryTeam + " rồi ah";

        this.moduleConfig.setProductTeam(inventoryTeam);
        return "Đã chuyển thành công Module quản lý kho từ " + old + " -> " + inventoryTeam;
    }

    @Override
    public String switchDeliveryTeam(String deliveryTeam) {
        if (!AVAILABLE_DELIVERY_TEAM.contains(deliveryTeam))
            return "Hệ thống chưa tích hợp Module giao hàng với nhóm " + deliveryTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(deliveryTeam))
            return "Hệ thống hiện đang sử dụng Module giao hàng của nhóm " + deliveryTeam + " rồi ah";

        this.moduleConfig.setProductTeam(deliveryTeam);
        return "Đã chuyển thành công Module giao hàng từ " + old + " -> " + deliveryTeam;
    }

    @Override
    public String switchOrderTeam(String orderTeam) {
        if (!AVAILABLE_ORDER_TEAM.contains(orderTeam))
            return "Hệ thống chưa tích hợp Module quản lý đơn hàng với nhóm " + orderTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(orderTeam))
            return "Hệ thống hiện đang sử dụng Module quản lý đơn hàng của nhóm " + orderTeam + " rồi ah";

        this.moduleConfig.setProductTeam(orderTeam);
        return "Đã chuyển thành công Module quản lý đơn hàng từ " + old + " -> " + orderTeam;
    }

    @Override
    public String switchSystemManagementTeam(String systemManagementTeam) {
        if (!AVAILABLE_SYS_MANAGEMENT_TEAM.contains(systemManagementTeam))
            return "Hệ thống chưa tích hợp Module quản lý hệ thống - cấu hình với nhóm " + systemManagementTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(systemManagementTeam))
            return "Hệ thống hiện đang sử dụng Module quản lý hệ thống - cấu hình của nhóm " + systemManagementTeam + " rồi ah";

        this.moduleConfig.setProductTeam(systemManagementTeam);
        return "Đã chuyển thành công Module quản lý hệ thống - cấu hình từ " + old + " -> " + systemManagementTeam;
    }

    @Override
    public String switchSearchAndReportTeam(String searchAndReportTeam) {
        if (!AVAILABLE_SEARCH_AND_REPORT_TEAM.contains(searchAndReportTeam))
            return "Hệ thống chưa tích hợp Module tìm kiếm - báo cáo với nhóm " + searchAndReportTeam;

        String old = this.moduleConfig.getProductTeam();
        if (old.equals(searchAndReportTeam))
            return "Hệ thống hiện đang sử dụng Module tìm kiếm - báo cáo của nhóm " + searchAndReportTeam + " rồi ah";

        this.moduleConfig.setProductTeam(searchAndReportTeam);
        return "Đã chuyển thành công Module tìm kiếm - báo cáo từ " + old + " -> " + searchAndReportTeam;
    }
}
