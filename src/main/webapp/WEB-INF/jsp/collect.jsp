<%--
  Created by IntelliJ IDEA.
  User: colin
  Date: 2018/4/2
  Time: 下午9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>统计分析</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui2/css/layui.css" />
    <script src="${pageContext.request.contextPath}/layui2/layui.all.js"></script>
    <script src="${pageContext.request.contextPath}/css/collect.css"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ipUrl.js"></script>
    <script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
    <!-- 需要保存导出功能模块文件是在 highcharts.js 之后引入 -->
    <script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>
    <script src="${pageContext.request.contextPath}/layui3/layer.js"></script>

    <!-- 客户端导出功能模块为可选选项 -->
    <script src="http://cdn.hcharts.cn/highcharts/modules/offline-exporting.js"></script>
</head>
<body>

<div class="wrapper" >
    <div style="margin: 0 auto">
        <button class="layui-btn layui-btn-normal layui-btn-radius" onclick="showImage(1)" style="margin: 30px 50px 20px 400px;">柱状图</button>
        <button class="layui-btn layui-btn-normal layui-btn-radius" onclick="showImage(2)" style="margin: 30px 100px 20px 100px;">饼状图</button>
    </div>
    <div style="margin: 0 auto; max-width: 600px;">
    <div id="container" style="min-width:400px;height:400px; margin-top: 50px;"></div>
    </div>
</div>
<script type="text/javascript">

</script>
</body>
</html>
<script src="${pageContext.request.contextPath}/js/collect.js"></script>