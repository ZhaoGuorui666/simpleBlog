package com.zgr666.ssm.blog.mapper;

import com.zgr666.ssm.blog.entity.Draft;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DraftMapper {
    Integer insertDraft(Draft draft);

    Integer getIdByTitle(String DraftTitle);

    List<Draft> getAllDraft();

    Draft getDraftById(Integer id);

    Integer delDraftById(Integer id);

}
