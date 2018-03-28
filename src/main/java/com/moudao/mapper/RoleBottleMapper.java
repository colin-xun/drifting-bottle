package com.moudao.mapper;

import com.moudao.pojo.RoleBottle;
import com.moudao.pojo.RoleBottleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleBottleMapper {
    int countByExample(RoleBottleExample example);

    int deleteByExample(RoleBottleExample example);

    int deleteByPrimaryKey(Integer roleBottleId);

    int insert(RoleBottle record);

    int insertSelective(RoleBottle record);

    List<RoleBottle> selectByExample(RoleBottleExample example);

    RoleBottle selectByPrimaryKey(Integer roleBottleId);

    int updateByExampleSelective(@Param("record") RoleBottle record, @Param("example") RoleBottleExample example);

    int updateByExample(@Param("record") RoleBottle record, @Param("example") RoleBottleExample example);

    int updateByPrimaryKeySelective(RoleBottle record);

    int updateByPrimaryKey(RoleBottle record);
}