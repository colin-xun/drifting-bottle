package com.moudao.service.impl;

import com.moudao.mapper.BCommentMapper;
import com.moudao.mapper.BUserMapper;
import com.moudao.mapper.BottleMapper;
import com.moudao.mapper.PraiseMapper;
import com.moudao.pojo.*;
import com.moudao.service.PraiseService;
import com.moudao.util.Constant;
import com.moudao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * author: MrWang
 * date: 2018/3/29 14:32
 */
@Service
public class PraiseServiceImpl implements PraiseService {
    @Autowired
    private PraiseMapper praiseMapper;
    @Autowired
    private BUserMapper userMapper;
    @Autowired
    private BottleMapper bottleMapper;
    @Autowired
    private BCommentMapper commentMapper;

    @Override
    public Result create(Integer targetId, Integer userId, Byte catetory) {
        Praise praise = new Praise();
        praise.setUserId(userId);
        PraiseExample example = new PraiseExample();
        PraiseExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (Constant.PRAISE_CATRGORY_BOTTLLE == catetory.byteValue()) {
            //首先判断这个赞是不是已经存在了，防止重复点赞
            criteria.andBottleIdEqualTo(targetId);
            List<Praise> praises = praiseMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(praises)) {
                return Result.fail("您已经为这个瓶子点过赞了，请不要重复点赞");
            }
            praise.setBottleId(targetId);
            praiseMapper.insertSelective(praise);
            //更新瓶子的点赞数
            Bottle bottle = bottleMapper.selectByPrimaryKey(targetId);
            bottle.setPraiseNum(bottle.getPraiseNum() + 1);
            //判断有没有达到优质
            if (bottle.getBottleStatus().byteValue() != Constant.BOTTLE_GOOD && bottle.getPraiseNum().byteValue() > Constant.GOOD_THRESHOLD ) {
                bottle.setBottleStatus(Constant.BOTTLE_GOOD);
            }
            bottleMapper.updateByPrimaryKeySelective(bottle);
        } else {
            //首先判断这个赞是不是已经存在了，防止重复点赞
            criteria.andCommentIdEqualTo(targetId);
            List<Praise> praises = praiseMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(praises)) {
                return Result.fail("您已经为这个评论点过赞了，请不要重复点赞");
            }
            praise.setCommentId(targetId);
            praiseMapper.insertSelective(praise);
            //更新评论的点赞数
            BComment comment = commentMapper.selectByPrimaryKey(targetId);
            comment.setPariseNum(comment.getPariseNum() + 1);
            if(comment.getCommentStatus().byteValue() != Constant.COMMENT_GOOD && comment.getPariseNum().byteValue() > Constant.GOOD_THRESHOLD){
                comment.setCommentStatus(Constant.COMMENT_GOOD);
            }
            commentMapper.updateByPrimaryKeySelective(comment);
        }
        //给用户增加一个积分
        BUser bUser = userMapper.selectByPrimaryKey(userId);
        bUser.setIntegral(bUser.getIntegral() + 1);
        userMapper.updateByPrimaryKeySelective(bUser);
        return Result.success("点赞成功！");
    }
}
