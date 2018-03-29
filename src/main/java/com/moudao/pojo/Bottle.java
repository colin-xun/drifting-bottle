package com.moudao.pojo;

import com.moudao.util.InsertValid;
import com.moudao.util.UpdateValid;

import javax.validation.constraints.*;

import java.util.Date;

public class Bottle {
    //只在更新时进行验证非空
    @NotNull(groups = {UpdateValid.class}, message = "瓶子的id不能为空")
    private Integer bottleId;

    @NotBlank(groups = {InsertValid.class,UpdateValid.class}, message = "瓶子的标题不能为空")
    @Size(min = 1, max = 60, message = "瓶子的标题长度不得超过60个字符")
    private String bottleTitle;

    @NotBlank(groups = {InsertValid.class,UpdateValid.class}, message = "瓶子的内容不得为空")
    @Size(groups = {InsertValid.class,UpdateValid.class}, min = 1, max = 200, message = "瓶子的内容不得超过200个字符")
    private String bottleContent;

    @NotNull(groups = {InsertValid.class,UpdateValid.class}, message = "瓶子的类型不能为空，0：作业求解瓶，1：知识问答瓶")
    @Min(groups = {InsertValid.class,UpdateValid.class}, value = 0, message = "瓶子的类型只能是，0：作业求解瓶，1：知识问答瓶")
    @Max(groups = {InsertValid.class,UpdateValid.class}, value = 1, message = "瓶子的类型只能是，0：作业求解瓶，1：知识问答瓶")
    private Byte bottleCategory;

    @Min(groups = {InsertValid.class,UpdateValid.class}, value = 0, message = "是否是优选瓶子：0：普通瓶子，1：优选瓶子")
    @Max(groups = {InsertValid.class,UpdateValid.class}, value = 1, message = "是否是优选瓶子：0：普通瓶子，1：优选瓶子")
    private Byte bottleStatus;

    @NotNull(groups = {InsertValid.class,UpdateValid.class}, message = "创建这个瓶子的人的id不能为空")
    @Min(groups = {InsertValid.class,UpdateValid.class}, value = 1, message = "创建人的id的位数在1到11之间")
    @Digits(groups = {InsertValid.class,UpdateValid.class}, integer = 11, fraction = 0, message = "创建人的id的位数在1到11之间")
    private Integer createUserId;

    @NotNull(groups = {UpdateValid.class}, message = "点赞数不能为空")
    @Min(groups = {InsertValid.class,UpdateValid.class}, value = 0, message = "点赞数不能为负数")
    private Integer praiseNum;

    private Byte activeStatus;

    @Past(groups = {InsertValid.class,UpdateValid.class}, message = "创建时间不能大于当前时间")
    private Date createdTime;

    @Past(groups = {InsertValid.class,UpdateValid.class}, message = "修改时间不能大于当前时间")
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