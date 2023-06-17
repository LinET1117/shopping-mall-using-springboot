package com.linet.shoppingmallusingspringboot.dao;

import com.linet.shoppingmallusingspringboot.dto.UserRegisterRequest;
import com.linet.shoppingmallusingspringboot.model.User;

public interface UserDao {
    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest) ;

}
