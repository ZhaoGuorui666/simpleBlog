package com.zgr666.ssm.blog.controller.home;

import com.zgr666.ssm.blog.entity.Article;
import com.zgr666.ssm.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/article/{id}")
    public ModelAndView getArticleById(@PathVariable("id")Integer id){
        ModelAndView mav = new ModelAndView();
        Article article = articleService.getArticleById(id);

        mav.addObject("article",article);
        mav.setViewName("home/article");
        return mav;
    }
}
