package com.zgr666.ssm.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private Integer ArticleId;
    private String ArticleTitle;
    private String ArticleContent;
    private String ArticleContentSource;
    private String ArticleContentSum;
    private Integer ArticleViewCount;
    private Date ArticleUpdateTime;
    private Date ArticleCreateTime;
}
