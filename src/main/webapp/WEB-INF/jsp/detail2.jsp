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
    <title>瓶子详情</title>
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
            var userId = $("#userId").val();
            var bottleId = $("#bottleId").val();
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
                        alert("成功点赞！")
                        window.location.reload();
                    } else {
                        alert(data.resultMsg);
                    }
                }
            });
        }

        function submitForm(){
            var url = $.getRootApi() +"comment/create";
            $.ajax({
                url:url,
                data:$("#addBottleForm").serialize(),
                type:"post",
                success:function(data){
                    if (data.isSuccess){
                        alert("评论已发布！");
                        location.href=$.getRootApi()+"home";
                    } else {
                        alert(data.resultMsg);
                        location.href=$.getRootApi()+"home";
                    }
                }
            });
        }
    </script>
</head>
<body>
<div class="main layui-clear">
    <div class="wrap">

        <div class="content detail">
            <div class="fly-panel detail-box">
                <h1> 问题内容 </h1>
                <div class="detail-about">
                </div>
                <div id="detail-content" class="detail-body photos" style="margin-bottom: 20px;">
                </div>
            </div>
            <div class="fly-panel detail-box" style="padding-top: 0;">
                <a name="comment"> </a>
                <ul class="jieda photos" id="jieda">
                    <%--<li data-id="12" class="jieda-daan"> <a name="item-121212121212"> </a>--%>
                    <%--<div class="detail-about detail-about-reply">--%>
                    <%--<div>纸飞机</div>--%>
                    <%--<div>3分钟前</div>--%>
                    <%--<i class="iconfont icon-caina" title="最佳答案"> </i>--%>
                    <%--</div>--%>
                    <%--<div class="detail-body jieda-body">--%>
                    <%--<p> 么么哒 </p>--%>
                    <%--</div>--%>
                    <%--<div class="jieda-reply">--%>
                    <%--<span class="jieda-zan zanok" type="zan"> <i class="iconfont icon-zan"> </i> <em> 12 </em> </span>--%>
                    <%--</div>--%>
                    <%--</li>--%>
                    <%--<li data-id="13"> <a name="item-121212121212"> </a>--%>
                    <%--<div class="detail-about detail-about-reply">--%>
                    <%--<div>香菇</div>--%>
                    <%--<div>asdfsa</div>--%>
                    <%--</div>--%>
                    <%--<div class="detail-body jieda-body">--%>
                    <%--<p> 蓝瘦 </p>--%>
                    <%--</div>--%>
                    <%--<div class="jieda-reply">--%>
                    <%--<span class="jieda-zan" type="zan"> <i class="iconfont icon-zan"> </i> <em> 0 </em> </span>--%>
                    <%--</div>--%>
                    <%--</li>--%>
                    <!-- <li class="fly-none">没有任何回答</li> -->
                </ul>

                <div class="layui-form layui-form-pane">
                    <form id="addBottleForm">
                        <%--创建人ID--%>
                        <input type="hidden" id="userId" name="userId" value=${USER_SESSION.userId}>
                        <%--瓶子ID--%>
                        <input type="hidden" id="bottleId" name="bottleId" value="">

                        <%--<textarea id="L_content" name="content" required="" lay-verify="required" placeholder="我要回答" class="layui-textarea fly-editor" style="height: 150px;"> </textarea>--%>
                        <textarea rows="6" cols="90" name="content" placeholder="内容不能为空且不得超过200个字符"></textarea>
                        <%--<div class="layui-form-item layui-form-text">--%>
                            <%--<div class="layui-input-block">--%>
                                <%----%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div class="layui-form-item">
                            <button onclick="submitForm()" class="layui-btn" lay-filter="*" > 提交回答 </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor.js">
</script>
<script type="text/javascript">
    KE.show({
        id: 'L_content',
        resizeMode: 1,
        items: ['fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline', 'removeformat', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist', 'insertunorderedlist', 'emoticons', 'image', 'link']
    });
</script>
<script src="${pageContext.request.contextPath}/js/new.js"></script>
</body>
</html>
