package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.ArticleCategoryRef;
import com.zgr666.ssm.blog.mapper.ArticleCategoryRefMapper;
import com.zgr666.ssm.blog.service.ArticleCategoryRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleCategoryRefServiceImpl implements ArticleCategoryRefService {

    @Autowired
    ArticleCategoryRefMapper articleCategoryRefMapper;

    @Override
    public Integer insert(ArticleCategoryRef articleCategoryRef) {
        return articleCategoryRefMapper.insert(articleCategoryRef);
    }

    @Override
    public Integer deleteByArticleId(Integer articleId) {
        return articleCategoryRefMapper.deleteByArticleId(articleId);
    }

    @Override
    public Integer deleteByCategoryId(Integer categoryId) {
        return articleCategoryRefMapper.deleteByCategoryId(categoryId);
    }

    @Override
    public Integer findArticleId(Integer categoryId) {
        return articleCategoryRefMapper.findArticleId(categoryId);
    }

    @Override
    public Integer findCategoryId(Integer articleId) {
        return articleCategoryRefMapper.findCategoryId(articleId);
    }
}
