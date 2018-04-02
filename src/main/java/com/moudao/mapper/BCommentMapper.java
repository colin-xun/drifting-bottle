package com.moudao.mapper;

import com.moudao.pojo.BComment;
import com.moudao.pojo.BCommentExample;
import java.util.List;
import com.moudao.pojo.PraiseExample;
import org.apache.ibatis.annotations.Param;

public interface BCommentMapper {
    int countByExample(BCommentExample example);

    int deleteByExample(BCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(BComment record);

    int insertSelective(BComment record);

    List<BComment> selectByExample(BCommentExample example);

    BComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") BComment record, @Param("example") BCommentExample example);

    int updateByExample(@Param("record") BComment record, @Param("example") BCommentExample example);

    int updateByPrimaryKeySelective(BComment record);

    int updateByPrimaryKey(BComment record);

    List<BComment> selectGoodByPraise(Integer bottleId);

    List<BComment> selectCommonByCreatedTime(Integer bottleId);
}