package com.moudao.pojo;

import java.util.Date;

public class Chance {
    private Integer chanceId;

    private Integer chanceNum;

    private Byte chanceCategory;

    private Integer userId;

    private String ext1;

    private String ext2;

    private Date createdTime;

    private Date updatedTime;

    public Integer getChanceId() {
        return chanceId;
    }

    public void setChanceId(Integer chanceId) {
        this.chanceId = chanceId;
    }

    public Integer getChanceNum() {
        return chanceNum;
    }

    public void setChanceNum(Integer chanceNum) {
        this.chanceNum = chanceNum;
    }

    public Byte getChanceCategory() {
        return chanceCategory;
    }

    public void setChanceCategory(Byte chanceCategory) {
        this.chanceCategory = chanceCategory;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}