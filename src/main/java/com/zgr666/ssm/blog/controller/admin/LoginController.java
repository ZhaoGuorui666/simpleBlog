package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.entity.User;
import com.zgr666.ssm.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String loginPage(){
        return "admin/login";
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();

        String userName =request.getParameter("user_login");
        String passWord = request.getParameter("user_pass");
        User user = new User();

        String result = "";
        return  result;
    }


    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setUserEmail("397860751@qq.com");
        user.setUserLastLoginIp(request.getRemoteAddr());
 //       userMapper.insert(user);
        userMapper.testInsert(user);
        System.out.println("添加成功!!");

        return "admin/login";
    }
}
