<%--
  Created by IntelliJ IDEA.
  User: colin
  Date: 2018/4/1
  Time: 下午12:18
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
    <title>问题详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
    <script src="${pageContext.request.contextPath}/layui/layui.js">
    </script>
    <style type="text/css" rel="stylesheet">
        form { margin: 0; } .editor { margin-top: 5px; margin-bottom: 5px; }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ipUrl.js"></script>

    <script type="text/javascript">
        function support(type) {
            var userId = $("#user-id").val();
            var bottleId = $("#bottle-id").val();
            var url = $.getRootApi() +"praise/create/"+bottleId;

            $.ajax({
              type : "POST", //提交方式
              url : url,//路径
              data : {
                  "userId" : userId,
                  "catetory" : type
              },//数据，这里使用的是Json格式进行传输
              success : function(data) {//返回数据根据结果进行相应的处理
                  if (data.isSuccess){
                      // console.log(data)
                      alert("成功点赞！")
                  } else {
                      alert(data.resultMsg);
                  }
              }
          });
        }
    </script>
</head>
<body>
<div class="main layui-clear">
    <div class="wrap">

        <input type="hidden" id="bottle-id" name="bottle-id" value="value">
        <input type="hidden" id="user-id" name="user-id" value=${USER_SESSION.userId}>
        <input type="hidden" id="url-prefix" name="url-prefix" value=${pageContext.request.contextPath}>

        <div class="content detail">
            <div class="fly-panel detail-box">
                <h1> 问题内容 </h1>
                <div class="detail-about">
                    <div>亚索</div>
                    <div>2017-09-23</div>
                    <div class="detail-hits" data-id="{{rows.id}}">
                        <span class="layui-btn layui-btn-mini jie-admin" type="collect" data-type="add"> <a id="collectPost" onclick="support('0')"> 点赞此问题 </a> </span>
                    </div>
                </div>
                <div class="detail-body photos" id="detail-content" style="margin-bottom: 20px;">
                    <p> 帖子内容 </p>
                </div>
            </div>
            <div class="fly-panel detail-box" style="padding-top: 0;">
                <a name="comment"> </a>
                <ul class="jieda photos" id="jieda">
                    <li data-id="12" class="jieda-daan"> <a name="item-121212121212"> </a>
                        <div class="detail-about detail-about-reply">
                            <div>纸飞机</div>
                            <div>3分钟前</div>
                            <i class="iconfont ic on-caina" title="最佳答案"> </i>
                        </div>
                        <div class="detail-body jieda-body">
                            <p> 么么哒 </p>
                        </div>
                        <div class="jieda-reply">
                            <span class="jieda-zan zanok" type="zan"> <i class="iconfont icon-zan"> </i> <em> 12 </em> </span>
                        </div> </li>
                    <li data-id="13"> <a name="item-121212121212"> </a>
                        <div class="detail-about detail-about-reply">
                            <div>香菇</div>
                            <div>asdfsa</div>
                        </div>
                        <div class="detail-body jieda-body">
                            <p> 蓝瘦 </p>
                        </div>
                        <div class="jieda-reply">
                            <span class="jieda-zan" type="zan"> <i class="iconfont icon-zan"> </i> <em> 0 </em> </span>
                        </div>
                    </li>
                    <!-- <li class="fly-none">没有任何回答</li> -->
                </ul>

                <!--<div class="layui-form layui-form-pane">-->
                <!--<form action="">-->
                <!--<div class="layui-form-item layui-form-text">-->
                <!--<div class="layui-input-block">-->
                <!--<textarea id="L_content" name="content" required="" lay-verify="required" placeholder="我要回答" class="layui-textarea fly-editor" style="height: 150px;"> </textarea>-->
                <!--</div>-->
                <!--</div>-->
                <!--<div class="layui-form-item">-->
                <!--<button class="layui-btn" lay-filter="*" lay-submit=""> 提交回答 </button>-->
                <!--</div>-->
                <!--</form>-->
                <!--</div>-->
            </div>
        </div>
    </div>
</div>
<%--<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor.js">--%>
<%--</script>--%>
<%--<script type="text/javascript">--%>
    <%--KE.show({--%>
        <%--id: 'L_content',--%>
        <%--resizeMode: 1,--%>
        <%--items: ['fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline', 'removeformat', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist', 'insertunorderedlist', 'emoticons', 'image', 'link']--%>
    <%--});--%>
<%--</script>--%>
<script src="${pageContext.request.contextPath}/js/detail.js"></script>
</body>
</html>
