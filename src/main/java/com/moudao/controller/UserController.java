package com.moudao.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.moudao.pojo.BUser;
import com.moudao.service.UserService;
import com.moudao.utils.DataGridPageBean;
import com.moudao.utils.ResultMall;

/**
 * 
 *<p用户登录入口</p>
 *@param
 * @author fyx
 * @date2018年3月27日
 * @return
 */
@Controller
public class UserController {
	//存在session中的用户信息 fyx 
	private final String USER_SERSSION="USER_SESSION";
	//用户名为空的标识
	private final String USERNAME_EMPTY="USERNAME_EMPTY";
	//密码为空标识
	private final String PASSWORD_EMPTY="PASSWORD_EMPTY";
	
	//验证码标识
	private final String CODE = "CODE";
	
	
	//注入userService
	@Autowired
	private UserService userService;
	
	/**
	 *<p>跳转到登录页面</p>
	 * @param index
	 * @author fyx
	 * @date2018年3月27日
	 * @return login.jsp
	 */
	@RequestMapping("/index")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/changeCode")
	public void changeCode(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		int width = 80;
		int height = 32;
		//create the image
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// set the background color
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		// draw the border
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// create a random instance to generate the codes
		Random rdm = new Random();
		String hash1 = Integer.toHexString(rdm.nextInt());
		// make some confusion
		for (int i = 0; i < 50; i++) {
			int x = rdm.nextInt(width);
			int y = rdm.nextInt(height);
			g.drawOval(x, y, 0, 0);
		}
		// generate a random code
		String capstr = hash1.substring(0, 4);
		session.setAttribute("key", capstr);
		g.setColor(new Color(0, 100, 0));
		g.setFont(new Font("Candara", Font.BOLD, 24));
		g.drawString(capstr, 8, 24);
		g.dispose();
		response.setContentType("image/jpeg");
		/*out.clear();
		out = pageContext.pushBody();*/
		OutputStream strm = response.getOutputStream();
		ImageIO.write(image, "jpeg", strm);
		strm.close();
	}
	
	/**
	 * 登录及校验
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 * @throws MobileException
	 * 2017年11月17日
	 */
	@RequestMapping(value="/login")
	public String login(String username,
						String password,
						String checkCode,
						HttpServletRequest request) {
		
		//判断用户名和密码是否为空
		if(username==null || username.equals("")){
			request.setAttribute(USERNAME_EMPTY, "用户名不能为空");
			return "login";
		}
		if(password==null || password.equals("")){
			request.setAttribute(PASSWORD_EMPTY, "密码不能为空！");
			return "login";
		}
		
		//获取验证码
		String realCode = (String) request.getSession().getAttribute("key");
		if(StringUtils.isNotBlank(checkCode)){
			if(checkCode.toLowerCase().equals(realCode)){
				//获取subject对象
				Subject subject = SecurityUtils.getSubject();
				
				AuthenticationToken token = new UsernamePasswordToken(username, password);
				//登录
				try {
					subject.login(token);
					//认证用户
					BUser user = (BUser) subject.getPrincipal();
					
					//通过验证将user存到session
					request.getSession().setAttribute(USER_SERSSION, user);
					if(StringUtils.isBlank(user.getExt1())||"0".equals(user.getExt1())){
						return "changePwd";
					}
					//通过验证将user存到session
					request.getSession().setAttribute(USER_SERSSION, user);
				} catch (Exception e) {
					if(e instanceof UnknownAccountException){
						request.setAttribute(USERNAME_EMPTY, "用户名不存在！");
						return "login";
					}
					
					if(e instanceof IncorrectCredentialsException){
						request.setAttribute(PASSWORD_EMPTY, "密码错误！");
						return "login";
					}
					e.printStackTrace();
				}
				
			}else{
				request.setAttribute(CODE, "验证码错误！");
				return "login";
			}
		}else{
			request.setAttribute(CODE, "验证码不能为空！");
			return "login";
		}
			
		return "index";
	}
	
	@RequestMapping(value="/system/user")
	public String getUser(){
		return "/user/userlist";
	}
	
	/**
	 * 校验面是否证确
	 * @param userPwd
	 * @param request
	 * @return
	 * 2018年3月29日
	 */
	@RequestMapping("/login/checkparam")
	@ResponseBody
	public ResultMall checkparam(String userPwd,
			HttpServletRequest request){	
		if(StringUtils.isEmpty(userPwd)){
			return new ResultMall(400, "请输入原密码！");
		}
		
		//判断原密码输入是否正确
		//通过验证将user存到session
		BUser buser = (BUser) request.getSession().getAttribute(USER_SERSSION);
		String pwd = buser.getPassword();
		if(!userPwd.equals(pwd)){
			return new ResultMall(400, "密码不正确！");
		}
		
		return new ResultMall("正确！");
	}
	/**
	 * 退出系统登录
	 * @param request
	 * @return
	 * 2018年3月29日
	 */
	@RequestMapping("/loginout")
	public String loginOut(HttpServletRequest request){
		//清空session
		HttpSession session = request.getSession();
		session.removeAttribute(USER_SERSSION);
		//获取subject对象
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	/**
	 * 修改密码
	 * @param request
	 * @param newPwd
	 * @return
	 * 2018年3月29日
	 */
	@RequestMapping("/login/changePwd")
	public String loginChangePwd(HttpServletRequest request,String newPwd) {
		//判断原密码输入是否正确
		BUser bUser = (BUser) request.getSession().getAttribute(USER_SERSSION);
		//调用修改密码
		userService.updateUserLogin(bUser,newPwd);
		return "login";
	}
	
	/**
	 * 条件加分页查询
	 * @param buser
	 * @return
	 * 2018年3月29日
	 */
	@RequestMapping("/user/list_page")
	@ResponseBody
	public DataGridPageBean findList_Page_BUser(BUser buser,
				@RequestParam(defaultValue="1")Integer page,
				@RequestParam(defaultValue="20")Integer rows){
		DataGridPageBean pageBean  = userService.findList_Page_BUser( buser,page,rows);
		return pageBean;
	}

	/**
	 * 用戶
	 * @param bUser
	 * @return
	 */
	@RequestMapping("/user/saveUser")
	public String saveUser(BUser bUser){
		userService.saveUser(bUser);
		return "redirect:/system/user";
	}

	@RequestMapping("/user/updateUser")
	public String updateUser(BUser bUser){
		userService.updateBUser(bUser);
		return "redirect:/system/user";
	}

	@RequestMapping("/user/deleterUserById")
	public String deleterUserById(String id){
		userService.deleterUserById(id);
		return "redirect:/system/user";
	}


}
