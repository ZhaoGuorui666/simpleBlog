package com.zgr666.ssm.blog.service;

import com.zgr666.ssm.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    Integer insertArticle(Article article);
    Integer getIdByTitle(String ArticleTitle);
    List<Article> getAllArticle();
}
