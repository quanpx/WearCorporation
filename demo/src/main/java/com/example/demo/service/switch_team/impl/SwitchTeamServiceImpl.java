package com.example.demo.service.switch_team.impl;

import com.example.demo.config.product.ProductModuleConfig;
import com.example.demo.service.switch_team.SwitchTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SwitchTeamServiceImpl implements SwitchTeamService {

    public static final List<String> AVAILABLE_PRODUCT_TEAM = Arrays.asList("sp02", "sp17");

    @Autowired
    private ProductModuleConfig productModuleConfig;

    /**
     *
     * @param productTeam - must not be null
     */
    @Override
    public String switchProductTeam(String productTeam) {
        if (!AVAILABLE_PRODUCT_TEAM.contains(productTeam))
            return "Hệ thống chưa tích hợp API quản lý sản phẩm với nhóm " + productTeam;

        String old = this.productModuleConfig.getTeam();
        if (old.equals(productTeam))
            return "Hệ thống hiện đang sử dụng API quản lý sản phầm của nhóm " + productTeam + " rồi ah";

        this.productModuleConfig.setTeam(productTeam);
        return "Đã chuyển thành công product team: " + old + " -> " + productTeam;
    }
}
