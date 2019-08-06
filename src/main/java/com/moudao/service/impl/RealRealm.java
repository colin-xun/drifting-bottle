package com.moudao.service.impl;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.moudao.pojo.BUser;
import com.moudao.service.UserService;

/**
 * 配置shiro的真实类
 * author: MrWang
 * date: 2018/3/26 22:41
 */
public class RealRealm extends AuthorizingRealm {
	//注入用户服务对象
	@Autowired
	private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    	//根据用户名查询真实密码
		UsernamePasswordToken upt = (UsernamePasswordToken) authenticationToken;
		//页面中输入的用户名
		String username = upt.getUsername();
		
		
		//数据查询用户
		BUser user = userService.findUserByUsername(username);
	
		if(user==null){
			return null;
		}
		
		//比较是证确
		AuthenticationInfo info = new SimpleAccount(user,user.getPassword(), this.getName());
		return info;
		
   }
}
