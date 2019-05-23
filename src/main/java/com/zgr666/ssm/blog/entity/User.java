package com.zgr666.ssm.blog.entity;

import lombok.Data;

@Data
public class User {
    /**
     * 登陆姓名
     */
    private String userName;

    /**
     * 登陆密码
     */
    private String userPass;

    /**
     * 昵称
     */
    private String userNickname;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户最后一次登陆ip
     */
    private String userLastLoginIp;

    /**
     * 用户注册时间
     */
    private String userRegisterTime;

    /**
     * 用户最后一次登陆时间
     */
    private String userLastLoginTime;


}
