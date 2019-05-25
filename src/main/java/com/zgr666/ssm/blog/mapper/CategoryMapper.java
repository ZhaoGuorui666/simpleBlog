package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * @return 所有分类
     */
    List<Category> getAllCategory();


}
