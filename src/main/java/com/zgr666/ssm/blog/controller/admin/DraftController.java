package com.zgr666.ssm.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zgr666.ssm.blog.entity.Draft;
import com.zgr666.ssm.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DraftController {
    @Autowired
    DraftService draftService;
    @Autowired
    ArticleCategoryRefService articleCategoryRefService;
    @Autowired
    ArticleLableRefService articleLableRefService;
    @Autowired
    LabelService labelService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value="draft_edit.html")
    public ModelAndView draft_edit(@RequestParam(required = true)Integer id){
        ModelAndView mav = new ModelAndView();
        Draft draft = draftService.getDraftById(id);

        Integer CategoryId = articleCategoryRefService.findCategoryId(id);
        List<Integer> LabelId = articleLableRefService.findLabelId(id);

        String LabelIdString ="";
        String CategoryIdString = categoryService.getNameById(CategoryId);

        if(LabelId.size()!=0){
            for(int i = 0;i<LabelId.size();i++){
                Integer idTemp = LabelId.get(i);
                if(LabelId.size()-i!=1){
                    LabelIdString+=labelService.getNameById(idTemp);
                    LabelIdString+=",";
                }else {
                    LabelIdString+=labelService.getNameById(idTemp);
                }
            }
        }

        System.out.println(CategoryIdString);
        System.out.println(draft);

        mav.addObject("LabelIdName",LabelIdString);
        mav.addObject("CategoryName",CategoryIdString);
        mav.addObject("draft",draft);
        mav.setViewName("admin/draft/draft_edit");

        return mav;
    }

    @RequestMapping("/draft_list.html")
    public ModelAndView draft_list(HttpServletRequest request, @RequestParam(required = false,defaultValue = "1",value="pn")Integer pn){
        PageHelper.startPage(pn,10);
        ModelAndView mav = new ModelAndView();
        List<Draft> ls = draftService.getAllDraft();

        PageInfo<Draft> pageInfo = new PageInfo<Draft>(ls,10);
        mav.addObject("pageInfo",pageInfo);

        mav.setViewName("admin/draft/draft_list");
        return mav;
    }

}
