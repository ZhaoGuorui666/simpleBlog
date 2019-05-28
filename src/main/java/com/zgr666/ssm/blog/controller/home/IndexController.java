package com.zgr666.ssm.blog.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/home")
    public String homePage(){
        return "home/index";
    }

    @RequestMapping("/msgboard.html")
    public String msgboard(){
        return "home/msgboard";
    }
}
