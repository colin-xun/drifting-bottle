package com.moudao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moudao.pojo.BUser;
import com.moudao.pojo.Menu;
import com.moudao.service.MenuService;

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	/**
	 * 根据用户名查询用户拥有的菜单信息
	 * @param request
	 * @return
	 * 2018年3月28日
	 */
	@RequestMapping(value="/menu")
	@ResponseBody
	public List<Menu> findListMenu(HttpServletRequest request){
		//获取session
		BUser buser = (BUser) request.getSession().getAttribute("USER_SESSION");
		Integer userId = buser.getUserId();
		
		List<Menu> list = menuService.findListMenuByUserId(userId);
		return list;
		
	}
}
