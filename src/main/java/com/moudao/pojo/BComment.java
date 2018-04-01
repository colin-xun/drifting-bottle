package com.moudao.pojo;

import com.moudao.util.InsertValid;
import com.moudao.util.UpdateValid;

import javax.validation.constraints.*;
import java.util.Date;

public class BComment {
    @NotNull(groups = {UpdateValid.class}, message = "评论的id不能为空")
    private Integer commentId;

    @NotBlank(groups = {InsertValid.class,UpdateValid.class}, message = "评论内容不能为空")
    @Size(groups = {InsertValid.class,UpdateValid.class}, min = 1, max = 200, message = "瓶子的内容不得超过200个字符")
    private String content;

    @NotNull(groups = {UpdateValid.class}, message = "点赞数不能为空")
    @Min(groups = {InsertValid.class,UpdateValid.class}, value = 0, message = "点赞数不能为负数")
    private Integer pariseNum;

    @NotNull(groups = {UpdateValid.class}, message = "是否是优选评论，0：否，1：是，不能为空")
    private Byte commentStatus;

    @NotNull(groups = {InsertValid.class,UpdateValid.class}, message = "创建者id不能为空")
    private Integer userId;

    @NotNull(groups = {InsertValid.class,UpdateValid.class}, message = "瓶子id不能为空")
    private Integer bottleId;

    private String ext1;

    private String ext2;

    @Past(groups = {InsertValid.class,UpdateValid.class}, message = "创建时间应该是一个过去的时间")
    private Date createdTime;

    @Past(groups = {InsertValid.class,UpdateValid.class}, message = "修改时间应该是一个过去的时间")
    private Date updatedTime;

    //这个是用户的名字
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPariseNum() {
        return pariseNum;
    }

    public void setPariseNum(Integer pariseNum) {
        this.pariseNum = pariseNum;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
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