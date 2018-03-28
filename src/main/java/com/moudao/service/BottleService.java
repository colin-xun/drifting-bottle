package com.moudao.service;

import com.moudao.pojo.Bottle;
import com.moudao.util.Result;

import java.util.List;

/**
 * author: MrWang
 * date: 2018/3/28 10:56
 */
public interface BottleService {
    Result insert(Bottle bottle) throws Exception;
    void update(Bottle bottle);

    /**
     * 随机捞一个瓶子
     * @param userId
     * @return
     */
    Result selectByRandom(Integer userId);

    /**
     * 用户删除瓶子，实际上是解除和用户和瓶子的关系
     */
    void deleteBottleByUser(Integer bottleId, Integer userId);

    /**
     * 查询用户捞的瓶子列表
     * @param userId
     * @return
     */
    List<Bottle> selectRefloatList(Integer userId);

    /**
     * 根据id查询瓶子
     * @param bottleId
     * @return
     */
    Bottle getByBottleId(Integer bottleId);
}
