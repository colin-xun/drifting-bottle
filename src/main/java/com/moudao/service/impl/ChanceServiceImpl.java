package com.moudao.service.impl;

import com.moudao.mapper.BUserMapper;
import com.moudao.mapper.ChanceMapper;
import com.moudao.pojo.BUser;
import com.moudao.pojo.Chance;
import com.moudao.pojo.ChanceExample;
import com.moudao.service.ChanceService;
import com.moudao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * author: MrWang
 * date: 2018/3/28 14:10
 */
@Service
public class ChanceServiceImpl implements ChanceService {
    @Autowired
    private ChanceMapper chanceMapper;
    @Autowired
    private BUserMapper userMapper;

    @Override
    public Integer insert(Chance chance){
        chanceMapper.insertSelective(chance);
        return chance.getChanceId();
    }

    @Override
    public Chance createBottle(Integer createUserId, byte b) {
        Chance chance = new Chance();
        chance.setChanceCategory(b);
        chance.setChanceNum(ChanceService.CHANCE_NUM);
        chance.setUserId(createUserId);
        chance.setCreatedTime(new Date());
        chance.setUpdatedTime(new Date());
        chanceMapper.insertSelective(chance);
        return chance;
    }

    @Override
    public void update(Chance chance){
        chanceMapper.updateByPrimaryKeySelective(chance);
    }

    @Override
    public Chance getThrowChanceByUserId(Integer userId) {
        return chanceMapper.getThrowChanceByUserId(userId);
    }

    @Override
    public List<Chance> getAllListBeforeToday() {
        ChanceExample example = new ChanceExample();
        ChanceExample.Criteria criteria = example.createCriteria();
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY ,0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        Date time = instance.getTime();
        //小于今天凌晨的全部清除
        criteria.andCreatedTimeLessThan(time);
        return chanceMapper.selectByExample(example);
    }

    @Override
    public void deleteBatch(List<Chance> lists) {
        chanceMapper.deleteBatch(lists);
    }

    @Override
    public Chance getRefloatByUserId(Integer userId) {
        return chanceMapper.getRefloatByUserId(userId);
    }

    @Override
    public Result cashIntegral(Integer userId, Integer integral, Chance chance) {
        //先减积分
        BUser user = userMapper.selectByPrimaryKey(userId);
        if(user == null){
            return Result.fail("没有这个用户");
        }
        Integer pastIntegral = user.getIntegral();
        int nowPastIntegral = pastIntegral.intValue() - integral.intValue();
        if(nowPastIntegral < 0){
            return Result.fail("积分余额不够");
        }
        user.setIntegral(nowPastIntegral);
        userMapper.updateByPrimaryKeySelective(user);
        //开始增加机会
        chanceMapper.updateByPrimaryKeySelective(chance);
        return Result.success(chance.getChanceNum(),"兑换成功,您现在的积分是：" + chance.getChanceNum());
    }


}
