package com.zgr666.ssm.blog.entity;

import lombok.Data;

@Data
public class ArticleLableRef {
    private Integer articleId;
    private Integer labelId;

    public ArticleLableRef() {
    }

    public ArticleLableRef(Integer articleId, Integer labelId) {
        this.articleId = articleId;
        this.labelId = labelId;
    }

}
