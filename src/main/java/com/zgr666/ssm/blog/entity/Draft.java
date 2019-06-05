package com.zgr666.ssm.blog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Draft {
    private Integer DraftId;
    private String DraftTitle;
    private String DraftContent;
    private String DraftContentSum;
    private Integer DraftViewCount;
    private Date DraftUpdateTime;
    private Date DraftCreateTime;
    private String DraftContentSource;
}
