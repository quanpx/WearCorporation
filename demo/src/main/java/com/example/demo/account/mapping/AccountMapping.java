package com.example.demo.account.mapping;

import com.example.demo.client_ui.dto.user.UserDTO;

public interface AccountMapping<T> {

    UserDTO beanToUserDTO(T user);
}
