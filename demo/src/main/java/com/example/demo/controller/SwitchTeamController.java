package com.example.demo.controller;

import com.example.demo.service.switch_team.SwitchTeamService;
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
            @RequestParam(value = "product-team", required = false) String productTeam
    ) {
        List<String> response = new LinkedList<>();
        if (productTeam != null)
            response.add(this.switchTeamService.switchProductTeam(productTeam));

        return response;
    }
}
