<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css" type="text/css" />
<title>修改口令</title>
<script type="text/javascript">
	$(function(){
		$("#userPwd").blur(function(){
			var userPwd = $("#userPwd").val();
			$.post("${pageContext.request.contextPath}/login/checkparam",{"userPwd":userPwd},function(data){
				if(data.status!=200){
					$("#userPwdMsg").html(data.msg);
					$("#changPwd").attr("disabled","disabled");
				}else{
					$("#userPwdMsg").html(null);
					$("#changPwd").removeAttr("disabled");
				}
				
			})
		});
		$("#newPwd").blur(function(){
			var userPwd = $("#newPwd").val();
			if(userPwd==null){
				$("#newPwdMsg").html("密码不能为空！");
				$("#changPwd").attr("disabled","disabled");
			}else{
				$("#newPwdMsg").html(null);
				$("#changPwd").removeAttr("disabled");
			}
			
			
		});
		$("#newPwdConfirm").blur(function(){
			var newPwd = $("#newPwd").val();
			var newPwdConfirm = $("#newPwdConfirm").val();
			
				if(newPwd!=newPwdConfirm){
					$("#newPwdConfirmMsg").html("两次密码不一致");
					$("#changPwd").attr("disabled","disabled");
				}else{
					$("#newPwdConfirmMsg").html(null);
					$("#changPwd").removeAttr("disabled");
				}
				
			
		});
		
		
		$("#changPwd").click(function(){
			$("#changePwdForm").submit();
		})
	})
	
</script>
</head>
<body leftmargin="0" topmargin="0" class="content_body">
	<form  id="changePwdForm" method="post"	action="${pageContext.request.contextPath}/login/changePwd" >
		<table width="96%" border="0" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td width="88%">
					<table width="100%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td height="35" colspan="4">
								<img alt="" src="${pageContext.request.contextPath }/images/I186.gif" width="16" height="16" align="middle"/>
								<strong class="FontTitle">修改口令</strong>
							</td>
						</tr>
						<tr>
							<td height="2" bgcolor="#FF9933" colspan="4"></td>
						</tr>
						<tr>
							<td height="10" colspan="4"></td>
						</tr>
						<tr>
							<td height="10" colspan="4"></td>
						</tr>
						<tr>
							<td height="10" colspan="4"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td class="textfont">
								用&nbsp;&nbsp;&nbsp;户:&nbsp;
							</td>
							<td class="textfont" colspan="2">
							
								${user.loginName }
							</td>
						</tr>
						<tr>
							<td colspan="4" height="7"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td class="textfont">
								输入原密码:&nbsp;
							</td>
							<td colspan="2">
								<input type="password" id="userPwd" name="userPwd" style="width: 150px;height: 20px" maxlength="32" >
								<font color="red"><span id="userPwdMsg"></span></font>
							</td>
						</tr>
						<tr>
							<td colspan="4" height="7"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td class="textfont">
								输入新密码:&nbsp;
							</td>
							<td colspan="2">
								<input type="password" id="newPwd" name="newPwd" style="width: 150px;height: 20px" maxlength="32" >
								<font color="red"><span id="newPwdMsg"></span></font>
							</td>
						</tr>
						<tr>
							<td colspan="4" height="7"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td class="textfont">
								新密码确认:&nbsp;
							</td>
							<td colspan="2">
								<input type="password" id="newPwdConfirm" name="newPwdConfirm" style="width: 150px;height: 20px" maxlength="32" >
								<font color="red"><span id="newPwdConfirmMsg"></span></font>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td height="20" colspan="2" align="center"></td>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td width="10%">
								&nbsp;
							</td>
							<td width="10%">
								&nbsp;
							</td>
							<td width="10%">
								<input type="button" value="确认" class="btnmini" id="changPwd">
								
							</td>
						</tr>
					</table>
				</td>
			</tr>
		
		
		</table>
	</form>
	
</body>
</html>