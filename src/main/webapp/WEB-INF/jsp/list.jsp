<%--
  Created by IntelliJ IDEA.
  User: colin
  Date: 2018/4/1
  Time: 下午12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css" type="text/css" />
    <title>问题系统首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/set_1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/set_3.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/ipUrl.js"></script>

</head>
<body>

<div style="margin-left: 500px">
    <a href="#" class="set_1_btn Vbtn-1" onclick="getBottles('0')"> <svg>
        <rect x="0" y="0" fill="none" width="100%" height="100%"></rect>
    </svg> 捞到的瓶子 </a>

    <a href="#" class="set_1_btn Vbtn-3" onclick="getBottles('1')"> <svg>
        <rect x="0" y="0" fill="none" width="100%" height="100%"></rect>
    </svg> 扔出的瓶子 </a>
</div>
<input type="hidden" id="user-id" name="user-id" value=${USER_SESSION.userId}>
<input type="hidden" id="pageCount" name="pageCount" value="">
<input type="hidden" id="contentType" name="contentType" value="">
<div class="main layui-clear">
    <div class="wrap">
        <div class="content" style="margin-right:0">
            <!--头可以空出来一点-->
            <div class="fly-tab"></div>
            <ul class="fly-list" id="content-list">
            </ul>
        </div>
    </div>
    <div id="demo1"></div>
</div>
<script>

</script>
</body>
</html>
<script src="${pageContext.request.contextPath}/js/list.js"></script>
<script src="${pageContext.request.contextPath}/layui2/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/layui2/css/layui.css"></script>
