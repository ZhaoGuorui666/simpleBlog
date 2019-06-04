package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.Category;
import com.zgr666.ssm.blog.mapper.CategoryMapper;
import com.zgr666.ssm.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public Integer delById(Integer id) {
        return categoryMapper.delById(id);
    }

    @Override
    public Integer addCategory(Category category) {
        return categoryMapper.addCategory(category);
    }

    @Override
    public Integer updateCategory(Integer id,String new_name) {
        return categoryMapper.updateCategory(id,new_name);
    }

    @Override
    public Integer getIdByName(String CategoryName) {
        return categoryMapper.getIdByName(CategoryName);
    }
}
