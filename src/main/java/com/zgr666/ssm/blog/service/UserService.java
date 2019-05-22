package com.zgr666.ssm.blog.service;

import com.zgr666.ssm.blog.entity.User;

public interface UserService {
    /**
     * 添加用户
     *
     * @param User
     * @return User
     */
    User insertUser(User user);
}
