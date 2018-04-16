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
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" />--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui2/css/layui.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
    <%--<script src="${pageContext.request.contextPath}/layui/layui.js">--%>
    <script src="${pageContext.request.contextPath}/layui2/layui.all.js"></script>
    <script src="${pageContext.request.contextPath}/layui2/layui.js"></script>
    <script src="${pageContext.request.contextPath}/layui3/layer.js"></script>
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
                        layer.alert('成功点赞！', {icon: 6});
                        window.location.reload();
                    } else {
                        layer.alert(data.resultMsg, {icon: 5});
                    }
                }
            });
        }

        function submitForm(){
            var url = $.getRootApi() +"comment/create";
            $.ajax({
                url:url,
                data:$("#addBottleForm").serialize(),
                async: false,
                type:"post",
                success:function(data){
                    if (data.isSuccess){
                        layer.alert('评论已发布！', {icon: 6});
                        location.href=$.getRootApi()+"home";
                    } else {
                        layer.alert(data.resultMsg, {icon: 5});
                        location.href=$.getRootApi()+"home";
                    }
                }
            });
        }

        function mySubmitFun() {
            layer.prompt({
                formType: 2,
                value: '内容不能为空且不得超过200个字符',
                title: '请输入您的内容',
                offset: 'auto',
                area: ['800px', '350px'] //自定义文本域宽高
            }, function(value, index, elem){
                userId = $('#userId').val();
                bottleId = $('#bottleId').val();

                var url = $.getRootApi() +"comment/create";
                $.ajax({
                    url:url,
                    data:{
                        userId : userId,
                        bottleId : bottleId,
                        content : value
                    },
                    async: false,
                    type:"post",
                    success:function(data){
                        if (data.isSuccess){
                            layer.alert('评论已发布！', {icon: 6});
                            location.href=$.getRootApi()+"home";
                        } else {
                            layer.alert(data.resultMsg, {icon: 5});
                            location.href=$.getRootApi()+"home";
                        }
                    }
                });
                // alert(value); //得到value
                layer.close(index);
            });
        }

        function prePage() {
            location.href=$.getRootApi()+"home";
        }
    </script>
</head>
<body>
<div class="main layui-clear">
    <button class="layui-btn layui-btn-xs" onclick="prePage()">返回上一页</button>
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
                <%--<ul class="jieda photos" id="jieda">--%>
                <%--</ul>--%>

                <ul class="jieda photos" id="jieda">

                </ul>

                <input type="hidden" id="userId" name="userId" value=${USER_SESSION.userId}>
                <%--瓶子ID--%>
                <input type="hidden" id="bottleId" name="bottleId" value="">

            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/new2.js"></script>
<%--<script>--%>
    <%----%>
<%--</script>--%>
</body>
</html>
