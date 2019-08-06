<%--
  Created by IntelliJ IDEA.
  User: colin
  Date: 2018/4/1
  Time: 下午12:16
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
    <title>漂流瓶</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui2/css/layui.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bottle.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css" />
    <script src="${pageContext.request.contextPath}/layui2/layui.all.js"></script>
    <script src="${pageContext.request.contextPath}/layui2/layui.js"></script>
    <script src="${pageContext.request.contextPath}/layui3/layer.js"></script>

    <script src="${pageContext.request.contextPath}/js/ipUrl.js"></script>
</head>
<body>
<div id="mainFrameContainer">
    <input type="hidden" id="user-id" name="user-id" value=${USER_SESSION.userId}>
    <input type="hidden" id="integral" name="integral" value=${USER_SESSION.integral}>
    <div class="container" id="bottle_container" name="mainFrame">
        <a>
            <div class="weather_sunshine" id="weather_sunshine"></div>
            <div class="weather_cloud defaulttheme defaultthemeshow"></div>
            <div class="skin3_island defaulttheme defaultthemeshow"></div>
            <div class="skin3_hill skin_hill  mytheme"></div>
            <div class="skin3_island skin_island  mytheme"></div>
            <div class="beach_sand"></div>
            <div class="wave"></div>
            <div class="skin3_beach mytheme"></div>
            <div class="skin7_beach mytheme"></div>
        </a>
        <!--背景图-->
        <!--头图标-->
        <div class="bottle_head">
            <span class="icon bottle_logo"> </span>
        </div>
        <!--展示瓶子的种类-->
        <div id="bottleType" class="bottle_select" style="display:none" tabindex="0" hidefocus="true" mor="over" mot="out" kd="animate" ku="stopanimate">
            <div class="pannel_content bg_paper">
                <a ck="cls" href="#" class="ico_close_circle_blue"> </a>
                <div class="type_content">
                    <a class="select_box" tabindex="0" href="add.html?type=0" hidefocus="" ck="clk" magicid="8"> <span class="ico_bottle bottle_type8"> </span> <p class="txt_center"> 作业求解瓶 </p> </a>
                    <a class="select_box" tabindex="0" href="add.html?type=1" hidefocus="" ck="clk" magicid="9"> <span class="ico_bottle bottle_type9"> </span> <p class="txt_center"> 知识问答瓶 </p> </a>
                </div>
                <a onclick="showTypeBottle()" href="#" class="ico_close_circle_blue"> </a>
                <div class="icon triangle">
                </div>
            </div>
        </div>
        <!--下方瓶子的页面-->
        <div id="toolbar" class="bottle_toolbar">
            <div class="toolbar_wrap">
                <a class="icon btnThrow" onclick="showBottleType()" href="#">
                    <div class="numBg">
                        <p id="pThrow"></p>
                    </div> </a>
                <a class="icon btnGet" href="#" onclick="getOneBottle()">
                    <div class="numBg">
                        <p id="pGet"></p>
                    </div> </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script src="${pageContext.request.contextPath}/js/bottle.js"></script>