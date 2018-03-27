package com.moudao.pojo;

import java.util.Date;

public class Bottle {
    private Integer bottleId;

    private String bottleTitle;

    private String bottleContent;

    private Byte bottleCategory;

    private Byte bottleStatus;

    private Integer createUserId;

    private Integer praiseNum;

    private Byte activeStatus;

    private Date createdTime;

    private Date updatedTime;

    public Integer getBottleId() {
        return bottleId;
    }

    public void setBottleId(Integer bottleId) {
        this.bottleId = bottleId;
    }

    public String getBottleTitle() {
        return bottleTitle;
    }

    public void setBottleTitle(String bottleTitle) {
        this.bottleTitle = bottleTitle == null ? null : bottleTitle.trim();
    }

    public String getBottleContent() {
        return bottleContent;
    }

    public void setBottleContent(String bottleContent) {
        this.bottleContent = bottleContent == null ? null : bottleContent.trim();
    }

    public Byte getBottleCategory() {
        return bottleCategory;
    }

    public void setBottleCategory(Byte bottleCategory) {
        this.bottleCategory = bottleCategory;
    }

    public Byte getBottleStatus() {
        return bottleStatus;
    }

    public void setBottleStatus(Byte bottleStatus) {
        this.bottleStatus = bottleStatus;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Byte getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Byte activeStatus) {
        this.activeStatus = activeStatus;
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