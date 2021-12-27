package com.example.demo.service.user;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.bean.user.SP08ResponeBean;
import com.example.demo.bean.user.SP14LoginRespone;
import com.example.demo.bean.user.SP14RegisterResponse;
import com.example.demo.bean.user.SP14ResponseBean;
import com.example.demo.dto.user.UserDTO;
import com.example.demo.dto.user.UserLoginDTO;
import com.example.demo.dto.user.UserRegisterDTO;


public interface UserService {
    SP14RegisterResponse register(UserRegisterDTO userRegisterDTO);
    SP14LoginRespone login(UserLoginDTO userLogin);
    SP14ResponseBean getUser(String token);
   
}
