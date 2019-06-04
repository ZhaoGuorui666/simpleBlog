package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.entity.Article;
import com.zgr666.ssm.blog.entity.ArticleCategoryRef;
import com.zgr666.ssm.blog.entity.ArticleLableRef;
import com.zgr666.ssm.blog.service.*;
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
    @Autowired
    ArticleCategoryRefService articleCategoryRefService;
    @Autowired
    ArticleLableRefService articleLableRefService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    LabelService labelService;
    ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef();
    ArticleLableRef articleLableRef = new ArticleLableRef();

    @RequestMapping("/article_add.html")
    public String welcome1(){
        return "admin/article/article_add";
    }

    @RequestMapping("/article_add")
    @ResponseBody
    public String article_add(HttpServletRequest request){
        System.out.println("进入了文章添加!!");

        Map<String,Object> map=new HashMap<String, Object>();
        String articleTitle = request.getParameter("articleTitle");
        String articleCategory = request.getParameter("articleCategory");
        String articleLabel = request.getParameter("articleLabel");
        String articleContent = request.getParameter("test-editor-html-code");

        Article article = new Article();
        article.setArticleContent(articleContent);
        article.setArticleTitle(articleTitle);
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleViewCount(0);

        //添加文章
        articleService.insertArticle(article);

        //获取文章id,类别id,标签id,并插入
        Integer ArticleId = articleService.getIdByTitle(articleTitle);
        Integer CategoryId = categoryService.getIdByName(articleCategory);

        articleCategoryRef.setArticleId(ArticleId);
        articleCategoryRef.setCategoryId(CategoryId);
        articleLableRef.setArticleId(ArticleId);
        String[] LabelName = articleLabel.split(",");

        for(String name:LabelName){
            Integer LabelId =labelService.getIdByName(name);
            articleLableRef.setLabelId(LabelId);
            articleLableRefService.insert(articleLableRef);
        }

        articleCategoryRefService.insert(articleCategoryRef);


        map.put("code",1);
        String result = new JSONObject(map).toString();

        System.out.println(articleTitle + "     "+articleCategory + "     "+articleLabel + "     "+articleContent + "     ");

        return result;
    }
}
