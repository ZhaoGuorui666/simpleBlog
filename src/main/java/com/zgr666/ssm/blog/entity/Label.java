package com.zgr666.ssm.blog.entity;

import lombok.Data;

@Data
public class Label {
    /**
     * 标签id
     */
    private Integer LabelId;

    /**
     * 标签名
     */
    private String LabelName;

    /**
     * 该标签下文章的数量
     */
    private Integer LabelArticleNum;

    public Integer getLabelId() {
        return LabelId;
    }

    public void setLabelId(Integer labelId) {
        LabelId = labelId;
    }

    public String getLabelName() {
        return LabelName;
    }

    public void setLabelName(String labelName) {
        LabelName = labelName;
    }

    public Integer getLabelArticleNum() {
        return LabelArticleNum;
    }

    public void setLabelArticleNum(Integer labelArticleNum) {
        LabelArticleNum = labelArticleNum;
    }
}
