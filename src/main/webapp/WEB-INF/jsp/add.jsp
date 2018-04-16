<%--
  Created by IntelliJ IDEA.
  User: colin
  Date: 2018/4/1
  Time: 下午12:12
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
    <title>发表问题</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="fly,layui,前端社区">
    <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/ipUrl.js"></script>
    <script src="${pageContext.request.contextPath}/layui2/layui.all.js"></script>

    <script src="${pageContext.request.contextPath}/layui3/layer.js"></script>

    <script type="text/javascript">
        // function submitForm() {
        //     var url = $.getRootApi() +"/bottle/create";
        //     $.ajax({
        //         type: "POST",//方法类型
        //         dataType: "json",//预期服务器返回的数据类型
        //         url: url ,//url
        //         data: $('#addBottleForm').serialize(),
        //         success: function (result) {
        //             console.log(result);//打印服务端返回的数据(调试用)
        //             if (result.isSuccess) {
        //                 alert(result.resultMsg);
        //                 window.location.href = "./bottle.jsp"
        //             }
        //             ;
        //         },
        //         error : function() {
        //             alert("异常！");
        //         }
        //     });
        // }
        function submitForm(){
            var url = $.getRootApi() +"bottle/create";
            $.ajax({
                url:url,
                data:$("#addBottleForm").serialize(),
                type:"post",
                success:function(data){
                    alert("瓶子已扔入大海！");
                    location.href=$.getRootApi()+"bottle";
                }
            });
        }
    </script>
</head>
<body>



<div class="main layui-clear">
    <div class="fly-panel" pad20>
        <h2 class="page-title">发表问题</h2>


        <div class="layui-form layui-form-pane">
            <form id="addBottleForm" name="addBottleForm" method="post" action="${pageContext.request.contextPath }/bottle/create">
                <%--瓶子种类--%>
                <input type="hidden" id="bottle-type" name="bottleCategory" value="">
                <%--创建人ID--%>
                <input type="hidden" id="creator-id" name="createUserId" value=${USER_SESSION.userId}>

                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">标题</label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="bottleTitle" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <div class="layui-input-block">
                        <div class="editor">
                            <textarea id="content" name="bottleContent" style="width:1040px;height:450px;visibility:hidden;"></textarea>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button onclick="submitForm()" class="layui-btn" lay-filter="*" lay-submit>立即发布</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content',
        resizeMode : 1,
        cssPath : './index.css',
        items : [
            'fontname', 'fontsize', 'textcolor', 'bgcolor', 'bold', 'italic', 'underline',
            'removeformat', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
            'insertunorderedlist', 'emoticons', 'image', 'link']
    });
</script>

<%--<script>--%>

    <%--layui.cache.page = '';--%>
    <%--layui.cache.user = {--%>
        <%--username: '游客'--%>
        <%--,uid: -1--%>
        <%--,avatar: '../res/images/avatar/00.jpg'--%>
        <%--,experience: 83--%>
        <%--,sex: '男'--%>
    <%--};--%>
    <%--layui.config({--%>
        <%--version: "2.0.0"--%>
        <%--,base: '../res/mods/'--%>
    <%--}).extend({--%>
        <%--fly: 'index'--%>
    <%--}).use('fly');--%>
<%--</script>--%>
</body>
</html>
<script src="${pageContext.request.contextPath}/js/add.js"></script>