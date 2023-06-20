package com.linet.shoppingmallusingspringboot.service.impl;

import com.linet.shoppingmallusingspringboot.dao.UserDao;
import com.linet.shoppingmallusingspringboot.dto.UserLoginRequest;
import com.linet.shoppingmallusingspringboot.dto.UserRegisterRequest;
import com.linet.shoppingmallusingspringboot.model.User;
import com.linet.shoppingmallusingspringboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log= LoggerFactory.getLogger(UserServiceImpl.class) ;

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
            //check email
        if (user != null) {
            log.warn("該 email {} 已被註冊!", userRegisterRequest.getEmail()) ;
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST) ;
        }
            // create email
            return userDao. createUser(userRegisterRequest) ;
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {

        User user = userDao.getUserByEmail(userLoginRequest.getEmail());

        if (user == null) {
            log.warn("該 email {} 尚未註冊", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword().equals(userLoginRequest.getPassword())) {
            return user;

        } else {
            log.warn("email {} 密碼不正確!", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus .BAD_REQUEST) ;
        }
    }
}
