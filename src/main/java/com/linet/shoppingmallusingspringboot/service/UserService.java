package com.linet.shoppingmallusingspringboot.service;

import com.linet.shoppingmallusingspringboot.dto.UserLoginRequest;
import com.linet.shoppingmallusingspringboot.dto.UserRegisterRequest;
import com.linet.shoppingmallusingspringboot.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest) ;

    User login(UserLoginRequest userLoginRequest) ;

}
