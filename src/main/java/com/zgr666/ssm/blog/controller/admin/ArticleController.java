package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.entity.Article;
import com.zgr666.ssm.blog.service.ArticleService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/article_add.html")
    public String welcome1(){
        return "admin/article/article_add";
    }

    @RequestMapping("/article_add")
    @ResponseBody
    public String article_add(HttpServletRequest request){
        System.out.println("进入了1!!");

        Map<String,Object> map=new HashMap<String, Object>();
        String articleTitle = request.getParameter("articleTitle");
        String articleCategory = request.getParameter("articleCategory");
        String articleLabel = request.getParameter("articleLabel");
        String articleContent = request.getParameter("test-editor-html-code");

        System.out.println("进入了2!!");

        Article article = new Article();
        article.setArticleContent(articleContent);
        article.setArticleTitle(articleTitle);
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleViewCount(0);
        articleService.insertArticle(article);

        System.out.println("进入了3!!");


        map.put("code",1);
        String result = new JSONObject(map).toString();

        System.out.println(articleTitle + "     "+articleCategory + "     "+articleLabel + "     "+articleContent + "     ");

        return result;
    }
}
