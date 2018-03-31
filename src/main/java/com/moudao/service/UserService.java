package com.moudao.service;

import java.util.List;

import com.moudao.pojo.BUser;
import com.moudao.utils.DataGridPageBean;

/**
 * 
 *<p>用户服务接口</p>
 *@param
 * @author fyx
 * @date2018年3月28日
 * @return
 */
public interface UserService {
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return 用户对象
	 * 2018年3月28日
	 */
	BUser findUserByUsername(String username);
	/**
	 * 修改用户信息
	 * @param bUser
	 * 2018年3月29日
	 * @param newPwd 
	 */
	void updateUserLogin(BUser bUser, String newPwd);
	/**
	 * 根据条件进行分页查询
	 * @param buser
	 * @return
	 * 2018年3月29日
	 */
	DataGridPageBean findList_Page_BUser(BUser buser, Integer page, Integer rows);
	/**
	 * 新增用户
	 * @param bUser
	 * 2018年3月30日
	 */
	void saveUser(BUser bUser);
	/**
	 * 根据id删除用户
	 * @param ids
	 * @return
	 * 2018年3月30日
	 */
	void deleterUserById(String id);
	/**
	 * 修改用户信息
	 * @param buser
	 * @return
	 * 2018年3月30日
	 */
	void updateBUser(BUser buser);

}
