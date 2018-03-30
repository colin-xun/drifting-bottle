package com.moudao.service;

import java.util.List;

import com.moudao.pojo.Menu;
/**
 * 查询菜单的服务接口
 *<p>Title</p>
 *@param
 * @author fyx
 * @date2018年3月28日
 * @return
 */
public interface MenuService {
	/**
	 * 根据用户Id查询
	 * @param id
	 * @return
	 * 2018年3月28日
	 */
	List<Menu> findListMenuByUserId(Integer userId);

}
