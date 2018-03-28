package com.moudao.service.impl;

import com.moudao.mapper.BUserBottleMapper;
import com.moudao.mapper.BottleMapper;
import com.moudao.pojo.*;
import com.moudao.service.BottleService;
import com.moudao.service.ChanceService;
import com.moudao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * author: wangyafei
 * date: 2018/3/28 11:17
 */
@Service
public class BottleServiceImpl implements BottleService {
    @Autowired
    private BottleMapper bottleMapper;

    @Autowired
    private BUserBottleMapper bUserBottleMapper;

    @Autowired
    private ChanceService chanceService;

    @Override
    public Result insert(Bottle bottle) {
        //然后进行扔瓶子的机会减一
        Chance chance = chanceService.getThrowChanceByUserId(bottle.getCreateUserId());
        //如果因为意外在加载用户信息时候没有生成这个扔瓶子的机会，就创建一个
        if(chance == null){
            chance = chanceService.createBottle(bottle.getCreateUserId(), (byte) 1);
        }
        if(chance.getChanceNum() <= 0){
            return Result.fail("您扔瓶子的机会已经用完，您可以用积分进行兑换");
        }
        chance.setChanceNum(chance.getChanceNum()-1);
        //更新机会
        chanceService.update(chance);
//        int i = 1/0;
        Integer bottleId = bottleMapper.insertSelective(bottle);
        return Result.success(bottleId);
    }

    @Override
    public void update(Bottle bottle) {
        bottleMapper.updateByPrimaryKeySelective(bottle);
    }

    @Override
    public Result selectByRandom(Integer userId) {
        //捞瓶子的机会减1
        Chance chance = chanceService.getRefloatByUserId(userId);
        //如果因为意外在加载用户信息时候没有生成这个捞瓶子的机会，就创建一个
        if(chance == null){
            chance = chanceService.createBottle(userId, (byte) 1);
        }
        if(chance.getChanceNum() <= 0){
            return Result.fail("您捞瓶子的机会已经用完，您可以用积分进行兑换");
        }
        chance.setChanceNum(chance.getChanceNum()-1);
        //更新机会
        chanceService.update(chance);

        Integer maxId = bottleMapper.selectMaxId();
//        Integer minId = bottleMapper.selectMinId();
        Integer minId = 1;
        Random r = new Random();
        int randomId = r.nextInt(maxId) + 1;
        //先要保证这个瓶子存在，并且和用户没关系
        Bottle bottle = bottleMapper.selectByPrimaryKey(randomId);
        if(bottle == null){
            //这说明捞到了一个已经被删除的瓶子
            return Result.fail("太好运了，您捞到了一个螃蟹，回去做一个大闸蟹吧！");
        }
        BUserBottleExample example = new BUserBottleExample();
        BUserBottleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andBottleIdEqualTo(randomId);
        List<BUserBottle> bUserBottles = bUserBottleMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(bUserBottles)){
            //这说明捞到的瓶子是自己已经有的瓶子了
            return Result.fail("太好运了，您捞到了一个龙虾，回去做一个大红烧龙虾吧！");
        }

        //建立用户和瓶子的关系
        BUserBottle userBottle = new BUserBottle();
        userBottle.setBottleId(bottle.getBottleId());
        userBottle.setUserId(userId);
        bUserBottleMapper.insertSelective(userBottle);
        return Result.success(bottle, "恭喜您捞到一个瓶子");
    }

    @Override
    public void deleteBottleByUser(Integer bottleId, Integer userId) {
        BUserBottleExample example = new BUserBottleExample();
        BUserBottleExample.Criteria criteria = example.createCriteria();
        criteria.andBottleIdEqualTo(bottleId);
        criteria.andUserIdEqualTo(userId);
        bUserBottleMapper.deleteByExample(example);
    }

    @Override
    public List<Bottle> selectRefloatList(Integer userId) {
        return bottleMapper.selectRefloatList(userId);
    }

    @Override
    public Bottle getByBottleId(Integer bottleId) {
        return bottleMapper.selectByPrimaryKey(bottleId);
    }


}
