package com.moudao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moudao.mapper.BUserMapper;

import com.moudao.pojo.BUser;
import com.moudao.pojo.BUserExample;
import com.moudao.pojo.BUserExample.Criteria;
import com.moudao.service.UserService;
import com.moudao.utils.DataGridPageBean;
@Service
public class UserServiceImpl implements UserService{
	//注入用户数据层对象
	@Autowired
	private BUserMapper bUserMapper;
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return 用户对象
	 * 2018年3月28日
	 */
	public BUser findUserByUsername(String username) {
		BUserExample example = new BUserExample();
		 Criteria createCriteria = example.createCriteria();
		//这只查询参数
		createCriteria.andNicknameEqualTo(username);
		List<BUser> list = bUserMapper.selectByExample(example);
		//定义用户对象
		BUser bUser = null;
		//判断该用户是否存在
		if(list!=null &&list.size()>0){
			bUser=list.get(0);
		}
		return bUser;
	}
	/**
	 * 修改用户信息
	 * @param bUser
	 * 2018年3月29日
	 * @param newPwd 
	 */
	public void updateUserLogin(BUser bUser, String newPwd) {
		bUser.setPassword(newPwd);
		bUser.setExt1("1");
		bUser.setUpdatedTime(new Date());
		bUserMapper.updateByPrimaryKey(bUser);
	}
	/**
	 * 根据条件进行分页查询
	 * @param buser
	 * @return
	 * 2018年3月29日
	 */
	public DataGridPageBean findList_Page_BUser(BUser buser, Integer page, Integer rows) {
		
		//创建插件对象
		PageHelper pageHelper = new PageHelper();
		//设置参数
		pageHelper.startPage(page, rows);
		
		//调用查询
		List<BUser> BUser = bUserMapper.findList_Page_BUser(buser);
		
		//分页
		PageInfo<BUser> pageinfo = new PageInfo<>(BUser);
		
		//创建dategirdPageBean
		DataGridPageBean d = new DataGridPageBean();
		
		//设置总条数
		d.setTotal(pageinfo.getTotal());
		//设置rows
		d.setRows(BUser);
		return d;
		
	}
	/**
	 * 新增用户
	 * @param bUser
	 * 2018年3月30日
	 */
	public void saveUser(BUser bUser) {
		bUser.setBirthday(new Date());
		bUser.setCreatedTime(new Date());
		bUser.setExt1("0");
		bUser.setExt2("0");
		bUser.setRealTime(bUser.getNickname());
		bUser.setUpdatedTime(new Date());
		bUser.setIntegral(0);
		bUserMapper.insert(bUser);
	}
	/**
	 * 根据id删除用户
	 * @param ids
	 * @return
	 * 2018年3月30日
	 */
	public void deleterUserById(String id) {
			bUserMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}
	/**
	 * 修改用户信息
	 * @param buser
	 * @return
	 * 2018年3月30日
	 */
	public void updateBUser(BUser buser) {
		buser.setUpdatedTime(new Date());
		buser.setRealTime(buser.getNickname());
		buser.setBirthday(new Date());
		buser.setExt1("0");
		bUserMapper.updateByPrimaryKeySelective(buser);
	}

}
