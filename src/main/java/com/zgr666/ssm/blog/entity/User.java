package com.zgr666.ssm.blog.entity;

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

    /**
     * get & set方法
     * @return
     */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    public String getUserRegisterTime() {
        return userRegisterTime;
    }

    public void setUserRegisterTime(String userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public String getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(String userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }
}
