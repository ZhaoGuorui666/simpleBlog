package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.User;
import com.zgr666.ssm.blog.mapper.UserMapper;
import com.zgr666.ssm.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User insertUser(User user){
        userMapper.insert(user);
        return user;
    }

    @Override
    public String getPassByName(String userName) {
        return userMapper.getPassByName(userName);
    }
}
