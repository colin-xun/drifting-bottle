package com.moudao.mapper;

import com.moudao.pojo.RoleMenu;
import com.moudao.pojo.RoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {
    int countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int deleteByPrimaryKey(Integer roleMenuId);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExample(RoleMenuExample example);

    RoleMenu selectByPrimaryKey(Integer roleMenuId);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}