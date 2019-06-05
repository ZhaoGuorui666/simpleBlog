package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.ArticleLableRef;
import com.zgr666.ssm.blog.mapper.ArticleLableRefMapper;
import com.zgr666.ssm.blog.service.ArticleLableRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleLabelRefServiceImpl implements ArticleLableRefService {
    @Autowired
    ArticleLableRefMapper articleLableRefMapper;


    @Override
    public Integer insert(ArticleLableRef articleLableRef) {
        return articleLableRefMapper.insert(articleLableRef);
    }

    @Override
    public Integer deleteByArticleId(Integer articleId) {
        return articleLableRefMapper.deleteByArticleId(articleId);
    }

    @Override
    public Integer deleteByLabelId(Integer labelId) {
        return articleLableRefMapper.deleteByLabelId(labelId);
    }

    @Override
    public Integer findArticleId(Integer labelId) {
        return articleLableRefMapper.findArticleId(labelId);
    }

    @Override
    public List<Integer> findLabelId(Integer articleId) {
        return articleLableRefMapper.findLabelId(articleId);
    }
}
