package com.zgr666.ssm.blog.service;

import com.zgr666.ssm.blog.entity.Draft;

import java.util.List;

public interface DraftService {
    Integer insertDraft(Draft draft);

    Integer getIdByTitle(String DraftTitle);

    List<Draft> getAllDraft();

    Draft getDraftById(Integer id);

    Integer delDraftById(Integer id);
}
