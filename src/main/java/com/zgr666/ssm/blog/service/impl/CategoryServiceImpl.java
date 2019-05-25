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
}
