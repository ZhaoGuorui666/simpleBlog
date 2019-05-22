package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String loginPage(){
        return "admin/login";
    }

    @RequestMapping("/register")
    public String errorPage(){
        return "admin/register";
    }
}
