package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.entity.User;
import com.zgr666.ssm.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginPage(){
        return "admin/login";
    }

    @RequestMapping(value="/loginCheck")
    @ResponseBody
    public String loginCheck(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();

        String userName =request.getParameter("user_login");
        String passWord = request.getParameter("user_pass");
        String truePass =userService.getPassByName(userName);

        if(passWord == truePass || passWord.equals(truePass)){
            //登陆成功
            map.put("code",1);
            map.put("msg","");
            //添加session
            request.getSession().setAttribute("username",userName);
            //添加cookie
            Cookie nameCookie = new Cookie("username",userName);
            Cookie passCookie = new Cookie("password", passWord);
            //设置cookie有效期为3天
            nameCookie.setMaxAge(60*60*24*3);
            passCookie.setMaxAge(60*60*24*3);
            response.addCookie(nameCookie);
            response.addCookie(passCookie);

            //更新用戶的最后登陆时间和ip
            //更新用户
            System.out.println("进入loginCheck!");
        }
        else{
            map.put("code",0);
            map.put("msg","用户密码不正确!!");
        }

        String result = new JSONObject(map).toString();
        return  result;
    }


    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setUserEmail("397860751@qq.com");
        user.setUserLastLoginIp(request.getRemoteAddr());
 //       userMapper.insert(user);
        System.out.println("添加成功!!");

        return "admin/login";
    }
}
