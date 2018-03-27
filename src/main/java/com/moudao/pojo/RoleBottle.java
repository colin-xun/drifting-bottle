package com.moudao.pojo;

import java.util.Date;

public class RoleBottle {
    private Integer roleBottleId;

    private Integer roleId;

    private Integer bottleId;

    private Date createdTime;

    public Integer getRoleBottleId() {
        return roleBottleId;
    }

    public void setRoleBottleId(Integer roleBottleId) {
        this.roleBottleId = roleBottleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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