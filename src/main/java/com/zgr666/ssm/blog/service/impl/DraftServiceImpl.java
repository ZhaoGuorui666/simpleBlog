package com.zgr666.ssm.blog.service.impl;

import com.zgr666.ssm.blog.entity.Draft;
import com.zgr666.ssm.blog.mapper.DraftMapper;
import com.zgr666.ssm.blog.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DraftServiceImpl implements DraftService {
    @Autowired
    DraftMapper draftMapper;

    @Override
    public Integer insertDraft(Draft draft) {
        return draftMapper.insertDraft(draft);
    }

    @Override
    public Integer getIdByTitle(String DraftTitle) {
        return draftMapper.getIdByTitle(DraftTitle);
    }

    @Override
    public List<Draft> getAllDraft() {
        return draftMapper.getAllDraft();
    }

    @Override
    public Draft getDraftById(Integer id) {
        return draftMapper.getDraftById(id);
    }

    @Override
    public Integer delDraftById(Integer id) {
        return draftMapper.delDraftById(id);
    }
}
