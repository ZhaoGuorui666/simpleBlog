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

    /**
     * 通过用户名得到密码
     *
     * @param userName
     * @return password
     */
    String getPassByName(String userName);
}
