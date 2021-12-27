package com.example.demo.mapping;


import com.example.demo.bean.user.SP08ResponeBean;
import com.example.demo.dto.user.UserDTO;


public interface UserMapping {
 UserDTO beanToUserDTO(SP08ResponeBean responeBean);   
}
