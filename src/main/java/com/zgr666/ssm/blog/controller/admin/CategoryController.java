package com.zgr666.ssm.blog.controller.admin;

import com.zgr666.ssm.blog.entity.Category;
import com.zgr666.ssm.blog.service.CategoryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/category_add.html")
    public String category_add(){
        return "admin/category/category_add";
    }

    @RequestMapping("/category_update.html")
    public String category_update(){
        return "admin/category/category_update";
    }

    @RequestMapping(value = "/category_del/{id}")
    @ResponseBody
    public String category_del(@PathVariable("id") Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        categoryService.delById(id);

        map.put("code",1);
        map.put("msg","删除成功");
        String result = new JSONObject(map).toString();

        return result;
    }

    @RequestMapping("/category_list.html")
    public ModelAndView category_list(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        List<Category> ls = categoryService.getAllCategory();

        mav.addObject("CategoryList",ls);
        mav.setViewName("admin/category/category_list");
        return mav;
    }
}
