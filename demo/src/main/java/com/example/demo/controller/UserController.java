package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.user.SP08ResponeBean;
import com.example.demo.bean.user.SP14LoginRespone;
import com.example.demo.bean.user.SP14RegisterResponse;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.dto.user.UserLoginDTO;
import com.example.demo.dto.user.UserRegisterDTO;
import com.example.demo.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView mav=new ModelAndView();
        UserLoginDTO loginDTO=new UserLoginDTO();
        UserRegisterDTO registerDTO =new UserRegisterDTO();
        mav.addObject("loginModel", loginDTO);
        mav.addObject("registerModel", registerDTO);
        mav.setViewName("login");
        return mav;
    }
    @PostMapping("/register")
    public SP14RegisterResponse register(@ModelAttribute UserRegisterDTO userRegisterDTO,BindingResult result)
    {
        System.out.println(userRegisterDTO);
        SP14RegisterResponse response= userService.register(userRegisterDTO);
        return response;
    }
   @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("loginModel") UserLoginDTO userLoginDTO,BindingResult result)
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("login");
        mav.addObject("loginModel", userLoginDTO);
        System.out.println(userLoginDTO);
       // SP14LoginRespone respone=userService.login(userLoginDTO);
        return mav;
    }
    @GetMapping(value = {"/user"})
    public SP14ResponseBean getUserInfo(HttpServletRequest request)
    {   
        String token=request.getHeader("Authorization");
        SP14ResponseBean response=userService.getUser(token);

        return response;
    }
}
