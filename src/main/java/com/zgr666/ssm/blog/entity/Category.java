package com.zgr666.ssm.blog.entity;

import lombok.Data;

@Data
public class Category {
    /**
     * 类别id
     */
    private Integer CategoryId;

    /**
     * 类别名
     */
    private String CategoryName;

    /**
     * 该类别下文章的数量
     */
    private Integer CategoryArticleNum;

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Integer getCategoryArticleNum() {
        return CategoryArticleNum;
    }

    public void setCategoryArticleNum(Integer categoryArticleNum) {
        CategoryArticleNum = categoryArticleNum;
    }
}
