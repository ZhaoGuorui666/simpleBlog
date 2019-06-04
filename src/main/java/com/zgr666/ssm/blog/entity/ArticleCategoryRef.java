package com.zgr666.ssm.blog.entity;

import lombok.Data;

@Data
public class ArticleCategoryRef {
    private Integer articleId;
    private Integer categoryId;

    public ArticleCategoryRef() {
    }

    public ArticleCategoryRef(Integer articleId, Integer categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }
}
