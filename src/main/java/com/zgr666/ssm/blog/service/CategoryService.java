package com.zgr666.ssm.blog.service;

import com.zgr666.ssm.blog.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Integer delById(Integer id);

    Integer addCategory(Category category);

    Integer updateCategory(Integer id,String new_name);

    Integer getIdByName(String CategoryName);
}
