package com.moudao.service;

import com.moudao.pojo.BComment;

import java.util.List;

/**
 * author: MrWang
 * date: 2018/3/29 1:09
 */
public interface CommentService {
    /**
     * commentCommon:查找范围，0：一般评论，1：优选评论,为null时表示 查找所有的
     */
    List<BComment> selectComment(Integer bottleId, Byte commentCommon);
}
