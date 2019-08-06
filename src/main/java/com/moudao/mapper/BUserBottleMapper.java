package com.moudao.mapper;

import com.moudao.pojo.BUserBottle;
import com.moudao.pojo.BUserBottleExample;
import java.util.List;

import com.moudao.pojo.Bottle;
import org.apache.ibatis.annotations.Param;

public interface BUserBottleMapper {
    int countByExample(BUserBottleExample example);

    int deleteByExample(BUserBottleExample example);

    int deleteByPrimaryKey(Integer userBottleId);

    int insert(BUserBottle record);

    int insertSelective(BUserBottle record);

    List<BUserBottle> selectByExample(BUserBottleExample example);

    BUserBottle selectByPrimaryKey(Integer userBottleId);

    int updateByExampleSelective(@Param("record") BUserBottle record, @Param("example") BUserBottleExample example);

    int updateByExample(@Param("record") BUserBottle record, @Param("example") BUserBottleExample example);

    int updateByPrimaryKeySelective(BUserBottle record);

    int updateByPrimaryKey(BUserBottle record);
}