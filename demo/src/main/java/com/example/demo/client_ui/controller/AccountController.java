package com.example.demo.client_ui.controller;

import java.net.http.HttpClient.Redirect;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.account.mapping.AccountMapping;
import com.example.demo.account.service.AccountService;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.client_ui.dto.user.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Autowired
    private Map<String, AccountService> accountServiceMap;

    @Autowired
    private AccountMapping<SP14ResponseBean> accountMapping;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("userModel", new UserDTO());
        mav.addObject("action", "/account/login");
        mav.setViewName("login");
        return mav;
    }

    @PostMapping("/register")
    public SP14ResponseBean register(@ModelAttribute UserDTO userRegisterDTO) {
        AccountService accountService = accountServiceMap.get(this.moduleConfig.getAccountTeam());
        SP14ResponseBean response = accountService.register(userRegisterDTO);
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, RedirectAttributes redirectAttributes,
            @ModelAttribute("loginModel") UserDTO userLoginDTO) {

        try {
            AccountService accountService = accountServiceMap.get(this.moduleConfig.getAccountTeam());
            SP14ResponseBean response = accountService.login(userLoginDTO);
            UserDTO user = accountMapping.beanToUserDTO(response);

            if (response != null) {
                redirectAttributes.addFlashAttribute("user", user);
                return "redirect:/";
            } else {

                model.addAttribute("loginModel", userLoginDTO);
                model.addAttribute("registerModel", new UserDTO());
                return "login";
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            model.addAttribute("loginModel", userLoginDTO);
            model.addAttribute("registerModel", new UserDTO());
           return "login";
        }

    }

    @GetMapping(value = { "/user" })
    public SP14ResponseBean getUserInfo(HttpServletRequest request) {

        AccountService accountService = accountServiceMap.get(this.moduleConfig.getAccountTeam());
        String token = request.getHeader("Authorization");
        SP14ResponseBean response = accountService.getUser(token);

        return response;
    }

}
