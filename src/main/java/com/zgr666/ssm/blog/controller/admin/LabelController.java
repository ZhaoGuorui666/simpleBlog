package com.zgr666.ssm.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgr666.ssm.blog.entity.Label;
import com.zgr666.ssm.blog.service.LabelService;
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
public class LabelController {

    @Autowired
    LabelService labelService;

    @RequestMapping("/label_add.html")
    public String category_add(){
        return "admin/label/label_add";
    }

    @RequestMapping(value = "/label_update.html/{id}")
    public String category_update(@PathVariable("id")Integer id,HttpServletRequest request){
        request.setAttribute("id",id);
        return "admin/label/label_update";
    }

    @RequestMapping("/label_list.html")
    public ModelAndView category_list(HttpServletRequest request, @RequestParam(required = false,defaultValue = "1",value="pn")Integer pn){
        PageHelper.startPage(pn,5);
        ModelAndView mav = new ModelAndView();
        List<Label> ls = labelService.getAllLabel();

        PageInfo<Label> pageInfo = new PageInfo<Label>(ls,5);
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("admin/label/label_list");
        return mav;
    }

    @RequestMapping(value = "/label_del/{id}")
    @ResponseBody
    public String category_del(@PathVariable("id") Integer id){
        Map<String,Object> map=new HashMap<String, Object>();
        labelService.delById(id);

        map.put("code",1);
        map.put("msg","删除成功");
        String result = new JSONObject(map).toString();

        return result;
    }

    @RequestMapping(value = "/label_add/{name}")
    @ResponseBody
    public String category_add(@PathVariable("name") String name){
        Map<String,Object> map=new HashMap<String, Object>();
        Label label = new Label();
        label.setLabelName(name);
        label.setLabelArticleNum(0);

        if(labelService.addLabel(label)==1){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        String result = new JSONObject(map).toString();

        return result;
    }

    @RequestMapping(value = "/label_update")
    @ResponseBody
    public String label_update(@RequestParam("id")Integer id,@RequestParam("new_name")String new_name ){
        Map<String,Object> map=new HashMap<String, Object>();

        if(labelService.updateLabel(id,new_name)>0){
            map.put("code",1);
        }else{
            map.put("code",0);
        }
        String result = new JSONObject(map).toString();

        return result;
    }
}
