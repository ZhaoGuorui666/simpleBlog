package com.zgr666.ssm.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/article_add.html")
    public String welcome1(){
        return "admin/article/article_add";
    }

    @RequestMapping("/test")
    public String test(){ return "admin/article/article_add";}
}
