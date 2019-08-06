package com.moudao.mapper;

import com.moudao.pojo.Bottle;
import com.moudao.pojo.BottleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BottleMapper {
    int countByExample(BottleExample example);

    int deleteByExample(BottleExample example);

    int deleteByPrimaryKey(Integer bottleId);

    int insert(Bottle record);

    Integer insertSelective(Bottle record);

    List<Bottle> selectByExample(BottleExample example);

    Bottle selectByPrimaryKey(Integer bottleId);

    int updateByExampleSelective(@Param("record") Bottle record, @Param("example") BottleExample example);

    int updateByExample(@Param("record") Bottle record, @Param("example") BottleExample example);

    int updateByPrimaryKeySelective(Bottle record);

    int updateByPrimaryKey(Bottle record);

    Integer selectMaxId();

    Integer selectMinId();

    List<Bottle> selectRefloatList(Integer userId);
}