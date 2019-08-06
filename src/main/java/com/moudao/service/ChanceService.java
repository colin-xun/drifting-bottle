package com.moudao.service;

import com.moudao.pojo.Chance;
import com.moudao.util.Result;

import java.util.List;

/**
 * author: MrWang
 * date: 2018/3/28 13:01
 */
public interface ChanceService {
    int CHANCE_NUM = 6;
    Integer insert(Chance chance);
    void update(Chance chance);

    /**
     * 获取这个用户的积分
     * @param userId
     * @return
     */
    Integer getIntegral(Integer userId);

    /**
     * 创建一个新的机会
     * @param createUserId 创建者id
     * @param b 机会的类型，0：捞，1：扔
     * @return
     */
    Chance createBottle(Integer createUserId, byte b);

    /**
     * 根据用户的id查找今天的扔瓶子的机会
     * @param userId
     * @return
     */
    Chance getThrowChanceByUserId(Integer userId);

    /**
     * 获取所有的列表
     * @return
     */
    List<Chance> getAllListBeforeToday();


    /**
     * 批量删除
     * @param lists
     */
    void deleteBatch(List<Chance> lists);

    /**
     * 根据用户查找今天的捞瓶子的机会
     * @param userId
     * @return
     */
    Chance getRefloatByUserId(Integer userId);

    /**
     * 兑换积分
     * @param userId
     * @param integral 积分数量
     * @param chance
     */
    Result cashIntegral(Integer userId, Integer integral, Chance chance);
}
