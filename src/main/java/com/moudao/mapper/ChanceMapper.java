package com.moudao.mapper;

import com.moudao.pojo.Chance;
import com.moudao.pojo.ChanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChanceMapper {
    int countByExample(ChanceExample example);

    int deleteByExample(ChanceExample example);

    int deleteByPrimaryKey(Integer chanceId);

    int insert(Chance record);

    int insertSelective(Chance record);

    List<Chance> selectByExample(ChanceExample example);

    Chance selectByPrimaryKey(Integer chanceId);

    int updateByExampleSelective(@Param("record") Chance record, @Param("example") ChanceExample example);

    int updateByExample(@Param("record") Chance record, @Param("example") ChanceExample example);

    int updateByPrimaryKeySelective(Chance record);

    int updateByPrimaryKey(Chance record);

    /**
     * 根据用户id查找扔瓶子的机会
     * @param userId
     * @return
     */
    Chance getThrowChanceByUserId(Integer userId);

    void deleteBatch(List<Chance> lists);

    Chance getRefloatByUserId(Integer userId);

    void clearAll();
}