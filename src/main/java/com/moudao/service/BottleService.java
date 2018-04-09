package com.moudao.service;

import com.moudao.pojo.Bottle;
import com.moudao.util.Result;

import java.util.Date;
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

    /**
     * 根据用户的id和用户扔出的瓶子/用户捞的瓶子类型进行分页查询
     * @param userId
     * @param bottleCategory 代表是用户扔出的瓶子（1）还是了捞到的瓶子（0）
     * @param page
     * @param pageSize
     * @return
     */
    Result getListByUserId(Integer userId, Byte bottleCategory, Integer page, Integer pageSize);

    /**
     * 根据用户的开始时间和结束时间统计扔的瓶子的数量和捞的瓶子的数量
     * @param userId
     * @param startTime
     * @param endTime
     * @return
     */
    Result getUserListCountByTime(Integer userId, Date startTime, Date endTime);

    /**
     * 漂流瓶条件统计
     * @param bottleCategory 瓶子的类别，0：作业求解瓶，1：知识问答瓶
     * @param bottleStatus   是否是优选瓶子：0：普通瓶子，1：优选瓶子
     * @param bottleTitle    瓶子标题
     * @param startTime      开始时间 不能大于当前时间
     * @param endTime        结束时间 不能大于当前时间
     * @param page           当前页
     * @param pageSize       页面尺寸
     * @return
     */
    Result getListByConditon(Byte bottleCategory, Byte bottleStatus, String bottleTitle, Date startTime, Date endTime, Integer page, Integer pageSize);

    /**
     *用于管理员统计瓶子的分类及数量，形成统计图
     * @param startTime
     * @param endTime
     * @return
     */
    Result listAllCountByTime(Date startTime, Date endTime);
}
