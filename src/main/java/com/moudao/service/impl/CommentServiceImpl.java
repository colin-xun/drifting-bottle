package com.moudao.service.impl;

import com.moudao.mapper.BCommentMapper;
import com.moudao.pojo.BComment;
import com.moudao.pojo.BCommentExample;
import com.moudao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: MrWang
 * date: 2018/3/29 1:09
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private BCommentMapper commentMapper;

    @Override
    public List<BComment> selectComment(Integer bottleId, Byte commentCommon) {
        BCommentExample example = new BCommentExample();
        BCommentExample.Criteria criteria = example.createCriteria();
        criteria.andBottleIdEqualTo(bottleId);
        if (commentCommon != null) {
            criteria.andCommentStatusEqualTo(commentCommon);
        }
        List<BComment> bComments = commentMapper.selectByExample(example);
        return bComments;
    }
}
