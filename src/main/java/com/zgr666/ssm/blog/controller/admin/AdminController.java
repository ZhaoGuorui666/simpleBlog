package com.zgr666.ssm.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/welcome1.html")
    public String welcome1(){
        return "admin/welcome1";
    }

    @RequestMapping("/member-list.html")
    public String memberList(){
        return "admin/member-list";
    }
}
