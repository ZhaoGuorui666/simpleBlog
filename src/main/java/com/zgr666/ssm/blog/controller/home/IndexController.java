package com.zgr666.ssm.blog.controller.home;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgr666.ssm.blog.entity.Article;
import com.zgr666.ssm.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/home")
    public ModelAndView homePage(HttpServletRequest request, @RequestParam(required = false,defaultValue = "1",value="pn")Integer pn){
        PageHelper.startPage(pn,5);
        ModelAndView mav = new ModelAndView();
        List<Article> ls = articleService.getAllArticle();

        //设置首页部分显示
        for(Article article:ls){
            String articleContent = article.getArticleContent();
            Integer contentSize = 200;
            if(articleContent.length() > contentSize){
                article.setArticleContentSum(articleContent.substring(0,contentSize));
            }else {
                article.setArticleContentSum(articleContent);
            }
        }

        PageInfo<Article> pageInfo = new PageInfo<Article>(ls,5);
        mav.addObject("pageInfo",pageInfo);

        mav.setViewName("home/index");
        return mav;
    }

    @RequestMapping("/msgboard.html")
    public String msgboard(){
        return "home/msgboard";
    }


}
