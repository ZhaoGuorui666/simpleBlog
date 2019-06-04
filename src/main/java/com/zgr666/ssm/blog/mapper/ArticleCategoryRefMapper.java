package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.ArticleCategoryRef;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleCategoryRefMapper {
    /**
     * 添加映射关系
     * @param articleCategoryRef
     * @return
     */
    Integer insert(ArticleCategoryRef articleCategoryRef);

    /**
     * 通过条件删除
     * @param articleId
     * @return
     */
    Integer deleteByArticleId(Integer articleId);
    Integer deleteByCategoryId(Integer categoryId);

    /**
     * 查找关系
     * @param categoryId
     * @return
     */
    Integer findArticleId(Integer categoryId);
    Integer findCategoryId(Integer articleId);
}
