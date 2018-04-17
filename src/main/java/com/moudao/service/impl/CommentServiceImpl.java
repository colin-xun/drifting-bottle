package com.moudao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moudao.mapper.BCommentMapper;
import com.moudao.mapper.BUserMapper;
import com.moudao.pojo.BComment;
import com.moudao.pojo.BCommentExample;
import com.moudao.pojo.BUser;
import com.moudao.service.CommentService;
import com.moudao.util.Constant;
import com.moudao.util.PageInfoResult;
import com.moudao.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.xml.bind.annotation.XmlAccessorOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: MrWang
 * date: 2018/3/29 1:09
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private BCommentMapper commentMapper;

    @Autowired
    private BUserMapper userMapper;

    @Override
    public List<BComment> selectComment(Integer bottleId, Byte commentCommon) {
        BCommentExample example = new BCommentExample();
        BCommentExample.Criteria criteria = example.createCriteria();
        criteria.andBottleIdEqualTo(bottleId);
        if (commentCommon != null) {
            criteria.andCommentStatusEqualTo(commentCommon);
            if (Constant.COMMENT_GOOD == commentCommon.byteValue()) {
                //优质评论按赞数进行逆序排序,返回前3条
                List<BComment> bComments = commentMapper.selectGoodByPraise(bottleId);
                return bComments;
            } else {
                //一般评论按时间进行逆序排序,返回前3条
                List<BComment> bComments = commentMapper.selectCommonByCreatedTime(bottleId);
                return bComments;
            }
        }
        List<BComment> bComments = commentMapper.selectByExample(example);
        return bComments;
    }

    @Override
    public Result insert(BComment comment) {
        commentMapper.insertSelective(comment);
        //每发表一次评论，用户的积分加1
        BUser user = userMapper.selectByPrimaryKey(comment.getUserId());
        user.setIntegral(user.getIntegral() + 1);
        userMapper.updateByPrimaryKeySelective(user);
        return Result.success("发表评论成功");
    }

    @Override
    public Result getCommentListByBottleId(Integer bottleId, Byte commentStatus, Integer page, Integer pageSize) {
        BCommentExample example = new BCommentExample();
        BCommentExample.Criteria criteria = example.createCriteria();
        criteria.andBottleIdEqualTo(bottleId);
        List<BComment> commets = null;
        if (commentStatus != null) {
            if (Constant.COMMENT_COMMON == commentStatus.byteValue()) {
                String orderBy = "created_time desc";
                PageHelper.startPage(page, pageSize, orderBy);
            } else {
                String orderBy = "parise_num desc";
                PageHelper.startPage(page, pageSize, orderBy);
            }
            criteria.andCommentStatusEqualTo(commentStatus);
            commets = commentMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(commets)) {
                commets = handleUsername(commets);
            }
            return getListResult(commets);
        }
        String orderBy = "created_time desc";
        PageHelper.startPage(page, pageSize, orderBy);
        commets = commentMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(commets)) {
            commets = handleUsername(commets);
        }
        return getListResult(commets);
    }

    private List<BComment> handleUsername(List<BComment> commets) {
        List<Integer> ids = new ArrayList<>();
        for (BComment comment : commets) {
            ids.add(comment.getUserId());
        }
        List<BUser> users = userMapper.selectBatchByIds(ids);
        Map<Integer, String> cache = new HashMap<>();
        if (!CollectionUtils.isEmpty(users)){
            for (BUser user : users) {
                cache.put(user.getUserId(), user.getNickname());
            }
        }
        for (BComment comment : commets) {
            comment.setNickname(cache.get(comment.getUserId()));
        }
        return commets;
    }

    private Result getListResult(List<BComment> commets) {
        PageInfo<BComment> pageInfo = new PageInfo<>(commets);
        PageInfoResult result = new PageInfoResult();
        result.setItems(pageInfo.getList());
        result.setTotalCount((int)pageInfo.getTotal());
        result.setPageIndex(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        return Result.success(result, "查询成功");
    }
}
