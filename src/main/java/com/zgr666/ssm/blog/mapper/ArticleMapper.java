package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    Integer insertArticle(Article article);


}
