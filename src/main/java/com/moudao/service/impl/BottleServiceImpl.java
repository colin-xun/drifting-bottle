package com.moudao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moudao.mapper.BUserBottleMapper;
import com.moudao.mapper.BUserMapper;
import com.moudao.mapper.BottleMapper;
import com.moudao.pojo.*;
import com.moudao.service.BottleService;
import com.moudao.service.ChanceService;
import com.moudao.util.ChanceBean;
import com.moudao.util.Constant;
import com.moudao.util.PageInfoResult;
import com.moudao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

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

    @Autowired
    private BUserMapper userMapper;

    @Override
    public Result insert(Bottle bottle) {
        //然后进行扔瓶子的机会减一
        Chance chance = chanceService.getThrowChanceByUserId(bottle.getCreateUserId());
        //如果因为意外在加载用户信息时候没有生成这个扔瓶子的机会，就创建一个
        if (chance == null) {
            chance = chanceService.createBottle(bottle.getCreateUserId(), (byte) 1);
        }
        if (chance.getChanceNum() <= 0) {
            return Result.fail("您扔瓶子的机会已经用完，您可以用积分进行兑换");
        }
        chance.setChanceNum(chance.getChanceNum() - 1);
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
        if (chance == null) {
            chance = chanceService.createBottle(userId, (byte) 1);
        }
        if (chance.getChanceNum() <= 0) {
            return Result.fail("您捞瓶子的机会已经用完，您可以用积分进行兑换");
        }
        chance.setChanceNum(chance.getChanceNum() - 1);
        //更新机会
        chanceService.update(chance);

        Integer maxId = bottleMapper.selectMaxId();
//        Integer minId = bottleMapper.selectMinId();
        Integer minId = 1;
        Random r = new Random();
        int randomId = r.nextInt(maxId) + 1;
        //先要保证这个瓶子存在，并且和用户没关系
        Bottle bottle = bottleMapper.selectByPrimaryKey(randomId);
        if (bottle == null) {
            //这说明捞到了一个已经被删除的瓶子
            return Result.fail("太好运了，您捞到了一个螃蟹，回去做一个大闸蟹吧！");
        }
        if (bottle.getCreateUserId().equals(userId)) {
            //这说明捞到的是用户创建的瓶子
            return Result.fail("恭喜您，您捞到一双破鞋!");
        }
        BUserBottleExample example = new BUserBottleExample();
        BUserBottleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andBottleIdEqualTo(randomId);
        List<BUserBottle> bUserBottles = bUserBottleMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(bUserBottles)) {
            //这说明捞到的瓶子是自己已经有的瓶子了
            return Result.fail("太好运了，您捞到了一个龙虾，回去做一个大红烧龙虾吧！");
        }

        //建立用户和瓶子的关系
        BUserBottle userBottle = new BUserBottle();
        userBottle.setBottleId(bottle.getBottleId());
        userBottle.setUserId(userId);
        bUserBottleMapper.insertSelective(userBottle);
        BUser bUser = userMapper.selectByPrimaryKey(userId);
        if (bUser != null) {
            bottle.setNickname(bUser.getNickname());
        }
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
        Bottle bottle = bottleMapper.selectByPrimaryKey(bottleId);
        if (bottle != null) {
            BUser bUser = userMapper.selectByPrimaryKey(bottle.getCreateUserId());
            bottle.setNickname(bottle.getNickname());
        }
        return bottle;
    }

    @Override
    public Result getListByUserId(Integer userId, Byte bottleCategory, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Bottle> lists = null;
        if (Constant.CHANCE_CATEGORY_REFLOAT == bottleCategory.byteValue()) {
            //用户捞到的瓶子列表
            lists = bottleMapper.selectRefloatList(userId);
        } else {
            //用户扔出的瓶子列表
            BottleExample example = new BottleExample();
            BottleExample.Criteria criteria = example.createCriteria();
            criteria.andCreateUserIdEqualTo(userId);
            lists = bottleMapper.selectByExample(example);
        }
        PageInfo<Bottle> pageInfo = new PageInfo<>(lists);
        PageInfoResult<Bottle> result = new PageInfoResult<>();
        result.setItems(pageInfo.getList());
        result.setPageIndex(page);
        result.setPageSize(pageSize);
        result.setTotalCount((int) pageInfo.getTotal());
        return Result.success(result, "查询成功");
    }

    @Override
    public Result getUserListCountByTime(Integer userId, Date startTime, Date endTime) {
        //捞瓶子的数量
        List<Bottle> bottles = bottleMapper.selectRefloatList(userId);
        //扔瓶子的数量
        int refloatNum = bottles.size();
        BottleExample example = new BottleExample();
        BottleExample.Criteria criteria = example.createCriteria();
        criteria.andCreateUserIdEqualTo(userId);
        criteria.andCreatedTimeBetween(startTime, endTime);
        int throwNum = bottleMapper.countByExample(example);
        return Result.success(new ChanceBean(0, 0, refloatNum, throwNum));
    }

    @Override
    public Result getListByConditon(Byte bottleCategory, Byte bottleStatus, Date startTime, Date endTime, Integer page, Integer pageSize) {
        //默认按照时间排序，时间相同的时候按优质瓶子在前进行排序，都是优质瓶子的时候按照点赞数进行评论
        String orderBy = "created_time desc,bottle_status desc,praise_num desc";
        BottleExample example = new BottleExample();
        BottleExample.Criteria criteria = example.createCriteria();
        if (startTime != null) {
            criteria.andCreatedTimeGreaterThanOrEqualTo(endTime);
        }
        if (endTime != null) {
            criteria.andCreatedTimeLessThanOrEqualTo(endTime);
        }
        if (bottleCategory != null) {
            criteria.andBottleCategoryEqualTo(bottleCategory);
        }
        if (bottleStatus != null) {
            criteria.andBottleStatusEqualTo(bottleStatus);
            //按照瓶子优质与否排序的时候，以创建时间作为第一排序，点赞数作为第二排序
            orderBy = "created_time desc, praise_num desc";
            if (bottleStatus.byteValue() == Constant.BOTTLE_GOOD) {
                //优质瓶子的时候按照点赞数作为第一排序，创建时间作为第二排序
                orderBy = "praise_num desc,created_time desc";
            }
        }
        PageHelper.startPage(page, pageSize, orderBy);
        List<Bottle> bottles = bottleMapper.selectByExample(example);
        PageInfo<Bottle> pageInfo = new PageInfo<>(bottles);
        PageInfoResult<Bottle> result = new PageInfoResult<>();
        result.setPageIndex(page);
        result.setPageSize(pageSize);
        result.setTotalCount((int) pageInfo.getTotal());
        result.setItems(pageInfo.getList());
        return Result.success(result, "查询成功");
    }

    @Override
    public Result listAllCountByTime(Date startTime, Date endTime) {
        Map<String,  Integer> resultMap = new LinkedHashMap<>();
        BottleExample example = new BottleExample();
        BottleExample.Criteria criteria = example.createCriteria();
        //先查作业-优质-一般
        criteria.andBottleCategoryEqualTo(Constant.BOTTLE_CATRGORY_SOLVE);
        criteria.andBottleStatusEqualTo(Constant.BOTTLE_GOOD);
        int solveGoodNum = bottleMapper.countByExample(example);
        example.clear();
        criteria = example.createCriteria();
        criteria.andBottleCategoryEqualTo(Constant.BOTTLE_CATRGORY_SOLVE);
        criteria.andBottleStatusEqualTo(Constant.BOTTLE_COMMON);
        int solveCommonNum = bottleMapper.countByExample(example);

        //再查解答-优质-一般
        example.clear();
        criteria = example.createCriteria();
        criteria.andBottleCategoryEqualTo(Constant.BOTTLE_CATRGORY_QUESTIOLN);
        criteria.andBottleStatusEqualTo(Constant.BOTTLE_GOOD);
        int questionGoodNum = bottleMapper.countByExample(example);
        example.clear();
        criteria = example.createCriteria();
        criteria.andBottleCategoryEqualTo(Constant.BOTTLE_CATRGORY_QUESTIOLN);
        criteria.andBottleStatusEqualTo(Constant.BOTTLE_COMMON);
        int questionCommonNum = bottleMapper.countByExample(example);

        resultMap.put("solveGoodNum",solveGoodNum);
        resultMap.put("solveCommonNum",solveCommonNum);
        resultMap.put("questionGoodNum",questionGoodNum);
        resultMap.put("questionCommonNum",questionCommonNum);

        return Result.success(resultMap, "查询成功");
    }

}
