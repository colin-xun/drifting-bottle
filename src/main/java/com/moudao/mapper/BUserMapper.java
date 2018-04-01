package com.moudao.mapper;

import com.moudao.pojo.BUser;
import com.moudao.pojo.BUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BUserMapper {
    int countByExample(BUserExample example);

    int deleteByExample(BUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(BUser record);

    int insertSelective(BUser record);

    List<BUser> selectByExample(BUserExample example);

    BUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") BUser record, @Param("example") BUserExample example);

    int updateByExample(@Param("record") BUser record, @Param("example") BUserExample example);

    int updateByPrimaryKeySelective(BUser record);

    int updateByPrimaryKey(BUser record);
    
    /**
     * 根据条件查询
     * @param buser
     * @return
     * 2018年3月29日
     */
	List<BUser> findList_Page_BUser(BUser buser);

    /**
     * 根据id列表批量查询用户
     * @param ids
     * @return
     */
    List<BUser> selectBatchByIds(List<Integer> ids);
}