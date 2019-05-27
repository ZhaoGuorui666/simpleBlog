package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.entity.Category;
import com.zgr666.ssm.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LabelController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/label_add.html")
    public String category_add(){
        return "admin/category/label_add";
    }

    @RequestMapping("/label_list.html")
    public ModelAndView category_list(){
        ModelAndView mav = new ModelAndView();
        List<Category> ls = categoryService.getAllCategory();
        System.out.println(ls);
        mav.addObject("CategoryList",ls);
        mav.setViewName("admin/category/label_list");
        return mav;
    }
}
