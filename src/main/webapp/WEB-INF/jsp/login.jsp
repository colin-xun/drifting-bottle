<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,innitial-scale=1">  
		<title>校园漂流瓶系统</title>
		<script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
	</head>
	
	
	
	<body>
		<div class="loginbox">
		<div class="loginnav">
			<nav class="navbar navbar-default">
				<div class="container">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/image/1522141072(1).jpg"></a>
					</div>
				</div>
			</nav>
		</div>
		
		<section class="mainlogin">
			<div class="container">
				<div class="col-md-4 col-md-offset-7 logincontent">
					<h4>系统登录入口：</h4>
					<form class="form-horizontal" id="loginform" name="loginform" method="post" action="${pageContext.request.contextPath }/login">
						<div class="form-group" id="idInputLine">
							<label for="inputPassword3" class="col-sm-3 control-label">账号</label>
							<div class="col-sm-8">
								<input id="loginform:idInput" type="text" name="username" class="form-control" placeholder="请输入账号">
								<font color="red">${USERNAME_EMPTY }</font>
							</div>
						</div>
						<div class="form-group" id="pwdInputLine">
							<label id="loginform:pwdInput" class="col-sm-3 control-label">密码</label>
							<div class="col-sm-8">
								<input for="pwdInput" type="password" name="password" class="form-control" id="inputaccount" placeholder="请输入您的密码">
								<font color="red">${PASSWORD_EMPTY }</font>
							</div>
						</div>
						 <div class="form-group">
							<label for="inputvalidate" class="col-sm-3 control-label">验证码</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="checkCode" id="inputaccount" placeholder="请输入验证码">
								<font color="red">${CODE }</font>
							</div>
							<!-- <div class="col-sm-4">
								<img id="loginform:vCode" src="validatecode.jsp"  onclick="javascript:document.getElementById('loginform:vCode'). src='validatecode.jsp?'+Math.random();" /><br>
							</div> -->
							 <div class="col-sm-4">
							    	<script type="text/javascript">
										    	function changeImg(){
										    		var img = document.getElementById("img");
										    		img.src = "${pageContext.request.contextPath}/changeCode?random="+Math.random();
										    	}
							  			  </script>
							      <img id="img" src="${pageContext.request.contextPath }/changeCode" onclick="changeImg()" />
							   </div>
						</div>
						<div class="form-group">
							
							<div class="col-sm-offset-3 col-sm-4">
								
							</div>
							<div class="col-sm-4">
							<!-- 	<a href="#"><span class="size12 forget">å¿è®°å¯ç </span></a> -->
							</div>
						</div>
						<div class="col-md-offset-3 col-md-8">
							<a href="javascript:document.getElementById('loginform').submit();" id="loginform:j_id19" name="loginform:j_id19"
								 class="btn btn-danger">立即登录</a>
							
						</div>
					</form>
				</div>
			</div>
		</section>

		<footer class="clearfix">
			<div class="container">
			<p class="text-center">地址：校园管理处  邮编：10086 电话：100-100-100 传真：010-10010000 </p>
<p  class="text-center">校园漂流瓶管理处</p>
</div>
		</footer>
		</div>
	</body>
</html>