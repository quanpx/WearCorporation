package com.example.demo.mapping;

import com.example.demo.bean.UserBean;
import com.example.demo.dto.UserDTO;

public interface UserMapping {
 UserDTO beanToUserDTO(UserBean user);   
}
