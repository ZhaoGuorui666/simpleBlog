package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.Article;
import com.zgr666.ssm.blog.mapper.ArticleMapper;
import com.zgr666.ssm.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Integer insertArticle(Article article) {
        return articleMapper.insertArticle(article);
    }
}
