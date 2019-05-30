package com.zgr666.ssm.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgr666.ssm.blog.entity.Category;
import com.zgr666.ssm.blog.service.CategoryService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/category_update.html/{id}")
    public String category_update(@PathVariable("id")Integer id,HttpServletRequest request){
        request.setAttribute("id",id);
        return "admin/category/category_update";
    }

    @RequestMapping("/category_list.html")
    public ModelAndView category_list(HttpServletRequest request, @RequestParam(required = false,defaultValue = "1",value="pn")Integer pn){
        PageHelper.startPage(pn,5);
        ModelAndView mav = new ModelAndView();
        List<Category> ls = categoryService.getAllCategory();

        PageInfo<Category> pageInfo = new PageInfo<Category>(ls,5);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("admin/category/category_list");
        return mav;
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

    @RequestMapping(value = "/category_add/{name}")
    @ResponseBody
    public String category_add(@PathVariable("name") String name){
        Map<String,Object> map=new HashMap<String, Object>();
        Category category = new Category();
        category.setCategoryName(name);
        category.setCategoryArticleNum(0);

        if(categoryService.addCategory(category)==1){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        String result = new JSONObject(map).toString();

        return result;
    }

    @RequestMapping(value = "/category_update")
    @ResponseBody
    public String category_update(@RequestParam("id")Integer id,@RequestParam("new_name")String new_name ){
        Map<String,Object> map=new HashMap<String, Object>();

        System.out.println(id+"         "+new_name);
        if(categoryService.updateCategory(id,new_name)>0){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        System.out.println(map);
        String result = new JSONObject(map).toString();

        return result;
    }
}
