package com.zgr666.ssm.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgr666.ssm.blog.entity.Article;
import com.zgr666.ssm.blog.entity.ArticleCategoryRef;
import com.zgr666.ssm.blog.entity.ArticleLableRef;
import com.zgr666.ssm.blog.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @RequestMapping(value="/article_add",method = RequestMethod.POST)
    @ResponseBody
    public String article_add(HttpServletRequest request)
        throws IOException {
        System.out.println("进入了文章添加!!");

        Map<String,Object> map=new HashMap<String, Object>();
        String articleTitle = request.getParameter("articleTitle");
        String articleCategory = request.getParameter("articleCategory");
        String articleLabel = request.getParameter("articleLabel");
        String articleContent = request.getParameter("test-editor-html-code");
        String articleContentSource = request.getParameter("test-markdown-code");

        System.out.println("articleContentSource为 = "+articleContentSource);

        Article article = new Article();
        article.setArticleContent(articleContent);
        article.setArticleTitle(articleTitle);
        article.setArticleCreateTime(new Date());
        article.setArticleUpdateTime(new Date());
        article.setArticleViewCount(0);
        article.setArticleContentSource(articleContentSource);

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

    @RequestMapping("/article_list.html")
    public ModelAndView article_list(HttpServletRequest request, @RequestParam(required = false,defaultValue = "1",value="pn")Integer pn){
        PageHelper.startPage(pn,10);
        ModelAndView mav = new ModelAndView();
        List<Article> ls = articleService.getAllArticle();

        PageInfo<Article> pageInfo = new PageInfo<Article>(ls,10);
        mav.addObject("pageInfo",pageInfo);

        mav.setViewName("admin/article/article_list");
        return mav;
    }

    @RequestMapping(value="article_del/{id}")
    @ResponseBody
    public String article_del(@PathVariable("id") Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        articleService.delArticleById(id);

        map.put("code",1);
        map.put("msg","删除成功");
        String result = new JSONObject(map).toString();

        return result;
    }
}
