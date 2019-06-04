package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.Label;
import com.zgr666.ssm.blog.mapper.LabelMapper;
import com.zgr666.ssm.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired(required = false)
    LabelMapper labelMapper;

    @Override
    public List<Label> getAllLabel() {
        return labelMapper.getAllLabel();
    }

    @Override
    public Integer delById(Integer id) {
        return labelMapper.delById(id);
    }

    @Override
    public Integer addLabel(Label label) {
        return labelMapper.addLabel(label);
    }

    @Override
    public Integer updateLabel(Integer id, String new_name) {
        return labelMapper.updateLabel(id,new_name);
    }

    @Override
    public Integer getIdByName(String LableName) {
        return labelMapper.getIdByName(LableName);
    }
}
