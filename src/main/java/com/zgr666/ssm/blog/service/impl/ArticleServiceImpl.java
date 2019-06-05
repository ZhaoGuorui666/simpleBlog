package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.Article;
import com.zgr666.ssm.blog.mapper.ArticleMapper;
import com.zgr666.ssm.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Integer insertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }

    @Override
    public Integer getIdByTitle(String ArticleTitle) {
        return articleMapper.getIdByTitle(ArticleTitle);
    }

    @Override
    public List<Article> getAllArticle() {
        return articleMapper.getAllArticle();
    }

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public Integer delArticleById(Integer id) {
        return articleMapper.delArticleById(id);
    }


}
