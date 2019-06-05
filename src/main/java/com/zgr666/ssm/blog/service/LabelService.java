package com.zgr666.ssm.blog.service;

import com.zgr666.ssm.blog.entity.Label;

import java.util.List;

public interface LabelService {
    List<Label> getAllLabel();

    Integer delById(Integer id);

    Integer addLabel(Label label);

    Integer updateLabel(Integer id,String new_name);

    Integer getIdByName(String LableName);

    String getNameById(Integer id);
}
