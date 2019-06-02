package com.zgr666.ssm.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    @RequestMapping("/article_add.html")
    public String welcome1(){
        return "admin/article/article_add";
    }

    @RequestMapping("/article_add")
    public String article_add(){

        return "添加成功!!";
    }
}
