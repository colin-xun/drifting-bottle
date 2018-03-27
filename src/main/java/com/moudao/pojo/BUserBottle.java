package com.moudao.pojo;

import java.util.Date;

public class BUserBottle {
    private Integer userBottleId;

    private Integer userId;

    private Integer bottleId;

    private Date createdTime;

    public Integer getUserBottleId() {
        return userBottleId;
    }

    public void setUserBottleId(Integer userBottleId) {
        this.userBottleId = userBottleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBottleId() {
        return bottleId;
    }

    public void setBottleId(Integer bottleId) {
        this.bottleId = bottleId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}