
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<!-- 导入jquery核心类库 -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
		<!-- 导入easyui类库 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/default.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
		<script src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(function(){
			// 先将body隐藏，再显示，不会出现页面刷新效果
			$("body").css({visibility:"visible"});
			
			// 取派员信息表格
			$('#grid').datagrid( {
				iconCls : 'icon-forward',
				fit : true,
				border : false,
				rownumbers : true,
				striped : true,
				pageList: [10,20,30],
				pagination : true,
				toolbar : toolbar,
				url : "${pageContext.request.contextPath }/user/list_page",
				idField : 'userId',
				columns : columns
			});
			
			// 添加取派员窗口
			$('#addWindow').window({
		        title: '增加用户',
		        width: 600,
		        modal: true,
		        shadow: true,
		        closed: true,
		        height: 300,
		        resizable:false
		    });
			// 添加取派员窗口
			$('#UpdateWindow').window({
		        title: '增加用户',
		        width: 600,
		        modal: true,
		        shadow: true,
		        closed: true,
		        height: 300,
		        resizable:false
		    });
			
		
			
		});
		
		//添加
			function doAdd(){
				$('#addWindow').window("open");
			}
			
			function doEdit(){
				var rows = $("#grid").datagrid("getSelections");
				if(rows.length!=1){
					$.messager.alert("提示","请您选择一条数据！","warning");
				}else{
					 $("#updateForm").form("load",rows[0]);
					
					 //获取下拉框中value值
					/* $("#standardId").combobox("select",rows[0].standard.id); */
					$('#UpdateWindow').window("open"); 
				}
				
			}
			
			function doDelete(){
	
				//判断是否选中记录
				var rows = $("#grid").datagrid('getSelections');
				if(rows.length!=1){
					$.messager.alert('提示信息','只能选择一条记录','warning');
				}else{
					$.messager.confirm('提示信息','确定删除吗？',function(r){
						if(r){
								var id = rows[0].userId;
							/*	alert(id);*/
							window.location.href="${pageContext.request.contextPath }/user/deleterUserById?id="+id;
						}
					})
				}
				
			}
			
			/* function doRestore(){
				
				//返回选中数据的数组
				var rows = $("#grid").datagrid("getSelections");
				
				//判断如果没有选择数据提示选择
				if(rows.length==0){
					$.messager.alert("提示信息","请您最少选择一条数据","warning")
				}else{
					
					//如果选择中数据将选中的所有数据的遍历拿到id
					$.messager.confirm("提示信息","你确定要还原该数据吗？",function(r){
						if(r){
							var array = new Array();
							
							for(var i=0;i<rows.length;i++){
								//从数组中拿到每条选中数据的id值
								var id = rows[i].id;
								
								//将id添加到array数组中默认","分隔
								array.push(id);
							}
							var ids = array.join(',');
							
							//发送get方式请求
							window.location.href="../../courierAction_restoreCourier.action?ids="+ids;
							
						}
					})
				}
			} */
			//工具栏
			var toolbar = [ {
				id : 'button-add',	
				text : '增加',
				iconCls : 'icon-add',
				handler : doAdd
			}, {
				id : 'button-edit',
				text : '修改',
				iconCls : 'icon-edit',
				handler : doEdit
			},{
				id : 'button-delete',
				text : '作废',
				iconCls : 'icon-cancel',
				handler : doDelete
			},{
				id : 'button-search',
				text : '条件查询',
				iconCls : 'icon-search',
				handler : function(){
					$("#searchWindow").window("open");
				}
			}
			];
			
			
			// 定义列
			var columns = [ [ {
				field : 'userId',
				checkbox : true,
			},{
				field : 'nickname',
				title : '姓名',
				width : 120,
				align : 'center'
			},{
				field : 'sex',
				title : '性别',
				width : 120,
				align : 'center',
				formatter: function(value,row,index){
					if (row.sex==1){
						return "女";
					} else {
						return "男";
					}
				}

			}, {
				field : 'integral',
				title : '积分',
				width : 120,
				align : 'center'
			}, {
				field : 'roleName',
				title : '角色',
				width : 120,
				align : 'center'
			}, {
				field : 'telephone',
				title : '电话',
				width : 120,
				align : 'center'
			}, {
				field : 'identity',
				title : '身份',
				width : 120,
				align : 'center',
				formatter: function(value,row,index){
					if (row.identity==1){
						return "学生";
					} else {
						return "教师";
					}
				}
			}, {
				field : 'department',
				title : '院系',
				width : 120,
				align : 'center'
			}, {
				field : 'updatedTime',
				title : '修改时间',
				width : 200,
				align : 'center'
			} ] ];
			
		
		
			
		</script>
	</head>

	<body class="easyui-layout" style="visibility:hidden;">
		<div region="center" border="false">
			<table id="grid"></table>
		</div>
		<div class="easyui-window" title="新增用户" id="addWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<div class="datagrid-toolbar">
					<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				</div>
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="SaveForm" action="${pageContext.request.contextPath }/user/saveUser" method="post">
					<table class="table-edit" width="80%" align="center">
						<tr class="title">
							<td colspan="4">用户信息</td>
						</tr>
						<tr>
							<td>用户名</td>
							<td>
								<input type="text" name="nickname" class="easyui-validatebox" required="true" />
							</td>
							<td>密码	</td>
							<td>
								<input type="text" name="password" class="easyui-validatebox" required="true" />
							</td>
							
						</tr>
						<tr>
							<td>注册电话</td>
							<td>
								<input type="text" name="telephone" data-options="validType:'mobile'" class="easyui-validatebox" required="true" />
								<!-- 校验是否是合法手机号 -->
								<script type="text/javascript">
								$(function(){
									
								$.extend($.fn.validatebox.defaults.rules, {    
									//移动手机号码验证
								    mobile: {//value值为文本框中的值
								        validator: function (value) {
								            var reg = /^1[34578]{1}\d{9}$/;
								            return reg.test(value);
								        },
								        message: '输入手机号码格式不准确.'
								    }
								});  
								
								$("#save").click(function(){
									var r = $("#SaveForm").form("validate");
									if(r){
											$("#SaveForm").submit();
										}
									});
								})

								</script>
							</td>
							<td>性别</td>
							<td>
								<select id="sex" name="sex" class="class="easyui-combobox" required="true" style="width:200px;">
						
									<option value="1">女</option>
									<option value="0">男</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>院校</td>
							<td>
								<input type="text" name="department" class="easyui-validatebox" required="true" />
							</td>
							<td>角色</td>
							<td>
								<select id="sex" name="roleId" class="easyui-combobox" required="true" style="width:200px;">
									<option value="1">系统管理员</option>
									<option value="2">用户</option>
								</select>
							</td>
							
						</tr>
						<tr>
						<td>身份</td>
							<td>
								<select id="identity" name="identity" class="easyui-combobox" required="true" style="width:200px;">
									<option value="0">教师</option>
									<option value="1">学生</option>
								</select>
							</td>
						</tr>
						
					</table>
				</form>
			</div>
		</div>
		<div class="easyui-window" title="修改用户" id="UpdateWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
			<div region="north" style="height:31px;overflow:hidden;" split="false" border="false">
				<div class="datagrid-toolbar">
					<a id="update" icon="icon-save" href="#" class="easyui-linkbutton" plain="true">保存</a>
				</div>
			</div>

			<div region="center" style="overflow:auto;padding:5px;" border="false">
				<form id="updateForm" action="${pageContext.request.contextPath }/user/updateUser" method="post">
					<table class="table-edit" width="80%" align="center">
						<tr class="title">
							<td colspan="4">用户信息</td>
						</tr>
						<tr>
							<td>用户名</td>
							<td>
								<input type="hidden" name="userId" />
								<input type="hidden" name="realTime" />
								<input type="hidden" name="integral" />
								<!-- <input type="hidden" name="birthday" /> -->
								<input type="text" name="nickname" class="easyui-validatebox" required="true" />
							</td>
							<td>密码	</td>
							<td>
								<input type="text" name="password" class="easyui-validatebox" required="true" />
							</td>
							
						</tr>
						<tr>
							<td>注册电话</td>
							<td>
								<input type="text" name="telephone" data-options="validType:'mobile'" class="easyui-validatebox" required="true" />
								<!-- 校验是否是合法手机号 -->
								<script type="text/javascript">
								$(function(){
									
								$.extend($.fn.validatebox.defaults.rules, {    
									//移动手机号码验证
								    mobile: {//value值为文本框中的值
								        validator: function (value) {
								            var reg = /^1[34578]{1}\d{9}$/;
								            return reg.test(value);
								        },
								        message: '输入手机号码格式不准确.'
								    }
								});  
								
								$("#update").click(function(){
									var r = $("#updateForm").form("validate");
									if(r){
											$("#updateForm").submit();
										}
									});
								})

								</script>
							</td>
							<td>性别</td>
							<td>
								<select id="sex" name="sex" class="class="easyui-combobox" required="true" style="width:200px;">
						
									<option value="1">女</option>
									<option value="0">男</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>院校</td>
							<td>
								<input type="text" name="department" class="easyui-validatebox" required="true" />
							</td>
							<td>角色</td>
							<td>
								<select id="sex" name="roleId" class="easyui-combobox" required="true" style="width:200px;">
									<option value="1">系统管理员</option>
									<option value="2">用户</option>
								</select>
							</td>
							
						</tr>
						<tr>
						<td>身份</td>
							<td>
								<select id="identity" name="identity" class="easyui-combobox" required="true" style="width:200px;">
									<option value="0">教师</option>
									<option value="1">学生</option>
								</select>
							</td>
						</tr>
						
					</table>
				</form>
			</div>
		</div>
		
		<!-- 查询快递员-->
		<div class="easyui-window" title="用户查询窗口" closed="true" id="searchWindow" collapsible="false" minimizable="false" maximizable="false" style="width: 400px; top:40px;left:200px">
			<div style="overflow:auto;padding:5px;" border="false">
				<form id="searchForm">
					<table class="table-edit" width="80%" align="center">
						<tr class="title">
							<td colspan="2">查询条件</td>
						</tr>
						<tr>
							<td>姓名</td>
							<td>
								<input type="text" name="nickname" />
							</td>
						</tr>
						<tr>
							<td>性别</td>
							<td>
								<select id="sex" name="sex" class="easyui-combobox" style="width:200px;">
									<option value=""></option>
									<option value="1">女</option>
									<option value="0">男</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>身份</td>
							<td>
								<select id="identity" name="identity" class="easyui-combobox" style="width:200px;">
									<option value=""></option>
									<option value="0">教师</option>
									<option value="1">学生</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>学院</td>
							<td>
								<input type="text" id="department" name="department" />
							</td>
						</tr>
							<td colspan="2"><a id="searchBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a> </td>
						<script type="text/javascript">
							$(function(){
								$("#searchBtn").click(function(){
									//1，将查询的条件获取到
									var p = $("#searchForm").serializeJson();
									/* console.info(p); */
									
									
									//2、将查询的条件提交到服务器,再次让datagrid发出pageQuery请求（page，rows）包含查询条件
									$("#grid").datagrid('load', p);
									//将查窗口关闭
									
									$("#searchWindow").window('close');
								})
							})
							
								$.fn.serializeJson=function(){  
						            var serializeObj={};  
						            var array=this.serializeArray();  
						            var str=this.serialize();  
						            $(array).each(function(){  
						                if(serializeObj[this.name]){  
						                    if($.isArray(serializeObj[this.name])){  
						                        serializeObj[this.name].push(this.value);  
						                    }else{  
						                        serializeObj[this.name]=[serializeObj[this.name],this.value];  
						                    }  
						                }else{  
						                    serializeObj[this.name]=this.value;   
						                }  
						            });  
						            return serializeObj;  
						        }; 
							</script>
						</tr>
						
					</table>
				</form>
			</div>
		</div>
	</body>

</html>