package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.ArticleLableRef;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleLableRefMapper {
    /**
     * 添加映射关系
     * @param articleLableRef
     * @return
     */
    Integer insert(ArticleLableRef articleLableRef);

    /**
     * 通过条件删除
     * @param articleId
     * @return
     */
    Integer deleteByArticleId(Integer articleId);
    Integer deleteByLabelId(Integer labelId);

    /**
     * 查找关系
     * @param labelId
     * @return
     */
    Integer findArticleId(Integer labelId);
    Integer findLabelId(Integer articleId);
}
