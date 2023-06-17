package com.linet.shoppingmallusingspringboot.service.impl;

import com.linet.shoppingmallusingspringboot.dao.UserDao;
import com.linet.shoppingmallusingspringboot.dto.UserRegisterRequest;
import com.linet.shoppingmallusingspringboot.model.User;
import com.linet.shoppingmallusingspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao. createUser(userRegisterRequest) ;
    }
}
