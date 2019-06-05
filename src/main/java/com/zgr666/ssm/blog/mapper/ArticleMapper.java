package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Integer insertArticle(Article article);

    Integer getIdByTitle(String ArticleTitle);

    List<Article> getAllArticle();

    Article getArticleById(Integer id);

    Integer delArticleById(Integer id);
}
