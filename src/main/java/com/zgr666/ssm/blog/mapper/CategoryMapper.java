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

    /**
     *
     * @param id
     * @return 返回删除成功的个数
     */
    Integer delById(Integer id);

    /**
     *
     * @param category
     * @return 添加成功的个数
     */
    Integer addCategory(Category category);

    /**
     *
     * @param 更新id的类别名为 new_name
     * @return 更新成功的个数
     */
    Integer updateCategory(Integer id,String new_name);


    /**
     *
     * @param 类名
     * @return 对应的id
     */
    Integer getIdByName(String CategoryName);

    String getNameById(Integer id);
}
