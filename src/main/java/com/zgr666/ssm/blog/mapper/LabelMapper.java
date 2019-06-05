package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.Label;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabelMapper {
    List<Label> getAllLabel();

    Integer delById(Integer id);

    Integer addLabel(Label label);

    Integer updateLabel(Integer id,String new_name);

    Integer getIdByName(String LableName);

    String getNameById(Integer id);
}
