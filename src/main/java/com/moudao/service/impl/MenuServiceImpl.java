package com.moudao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moudao.mapper.MenuMapper;
import com.moudao.pojo.Menu;
import com.moudao.service.MenuService;
/**
 * 
 *<p>查询菜单的服务实现类</p>
 *@param
 * @author fyx
 * @date2018年3月28日
 * @return
 */
@Service
public class MenuServiceImpl implements MenuService {
	//注入mapper
	@Autowired
	private MenuMapper menuMapper;
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return 用户对象
	 * 2018年3月28日
	 */
	public List<Menu> findListMenuByUserId(Integer userId) {
		//根据用户id进行查询
		List<Menu> list = menuMapper.findListMenuByUserId(userId);
		/*if(list!=null&&list.size()>0){
			for (Menu menu : list) {
				menu.setId(menu.getMenuId()+"");
				menu.setpId(menu.getParentId()+"");
				menu.setName(menu.getMenuName());
			}
		}*/
		return list;
	}

}
