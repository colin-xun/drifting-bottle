$.sevice = document.location.host ;
$.getLoginUrl = function () { //登录页地址
    return "http://"+$.sevice+"/login.html";
};

window.onload=function (ev) {
    var LocString = String(window.document.location.href);
    var urls = LocString.split("=");
    var bottleId = urls[1];


    var url = $.getRootApi() +"bottle/get/"+bottleId;

    $.ajax({
        type : "GET", //提交方式
        url : url,//路径
        async: false,
        contentType: 'application/json;charset=utf-8',
        data : {},//数据，这里使用的是Json格式进行传输
        success : function(data) {//返回数据根据结果进行相应的处理
            if (data.isSuccess) {
                var bottle = data.data.bottle;
                if (bottle!=null) {
                    //填充标题
                    $(".detail-about").html('');
                    var detailAbout = '<div>'+bottle.bottleTitle+'</div>';
                    detailAbout += '<div>' + bottle.nickname + '</div>';
                    detailAbout += '<div><i class="iconfont icon-zan"> </i>'+bottle.praiseNum+'</div>';


                    detailAbout += '<a class="layui-btn layui-btn-xs" onclick="mySubmitFun()">发表评论</a> <a class="layui-btn layui-btn-xs" onclick="support(\'0\')">点赞问题</a>';
                    $(".detail-about").html(detailAbout);

                    //填充内容
                    $("#detail-content").html('');
                    var detailContent = '<p>'+bottle.bottleContent+'</p>'
                    $("#detail-content").html(detailContent);
                }
            } else {
                layer.msg('data.resultMsg', {icon: 2});
            }
        }
    });

    $("#bottleId").val(bottleId);
    toMoreComment();
}

function getCookie(cname)
{
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}

function addOk(commentId) {
    var userId = $("#userId").val();
    var url = $.getRootApi() +"praise/create/"+commentId;

    $.ajax({
        type : "POST", //提交方式
        url : url,//路径
        async: false,
        data : {
            "userId" : userId,
            "catetory" : 1
        },//数据，这里使用的是Json格式进行传输
        success : function(data) {//返回数据根据结果进行相应的处理
            if (data.isSuccess){
                layer.alert('成功点赞！', {
                    icon: 6,
                    yes: function (index) {
                        layer.close(index);
                        window.location.reload();
                    }
                });
            } else {
                layer.msg(data.resultMsg, {icon: 2});
            }
        },
        error : function (data) {
            layer.alert('服务器繁忙。。。', {
                icon: 5,
                yes: function (index) {
                    layer.close(index);
                }
            });
        }
    });
}


function toMoreComment() {

    layui.use('flow', function(){
        var flow = layui.flow;

        flow.load({
            elem: '#jieda' //流加载容器
            ,scrollElem: '#jieda' //滚动条所在元素，一般不用填，此处只是演示需要。
            ,done: function(page, next){ //执行下一页的回调

                var bottleId = $('#bottleId').val();
                var url = $.getRootApi() +"comment/getCommentListByBottleId/"+bottleId;
                $.ajax({
                    type: "GET", //提交方式
                    url: url,//路径
                    contentType: 'application/json;charset=utf-8',
                    async: false,
                    data: {
                        page : page,
                        pageSize : 10
                    },//数据，这里使用的是Json格式进行传输
                    success: function (data) {//返回数据根据结果进行相应的处理
                        if (data.isSuccess) {
                            var lis = [];
                            layui.each(data.data.items, function(i,result){
                                var userName = result['nickname'];
                                var pariseNum = result['pariseNum'];
                                var content = result['content'];
                                var updateTime = result['updatedTime'];
                                var commentId = result['commentId'];
                                var commentStatus = result['commentStatus'];
                                var item;
                                if (1 == commentStatus) {
                                    item = '<li><div class="detail-about detail-about-reply"><div>' + userName + '</div><div>' + updateTime + '</div><i class="iconfont icon-caina" title="最佳答案"> </i></div><div class="detail-body jieda-body"><p>' + content + '</p></div><div class="jieda-reply"><span class="jieda-zan" type="zan"><em>点赞数:'+pariseNum+' </em> </span><div class="jieda-admin"><span class="jieda-accept" type="accept"><a href="#" onclick="addOk('+commentId+')" class="layui-btn layui-btn-xs">点赞</a></span></div></div></li>';
                                }
                                if (0 == commentStatus) {
                                    item = '<li><div class="detail-about detail-about-reply"><div>' + userName + '</div><div>' + updateTime + '</div></div><div class="detail-body jieda-body"><p>' + content + '</p></div><div class="jieda-reply"><span class="jieda-zan" type="zan"><em>点赞数:'+pariseNum+' </em> </span><div class="jieda-admin"><span class="jieda-accept" type="accept"><a href="#" onclick="addOk('+commentId+')" class="layui-btn layui-btn-xs">点赞</a></span></div></div></li>'
                                }
                                lis.push(item);
                            });

                            totalCount = data.data.totalCount;
                            pageSize = data.data.pageSize;
                            pages = totalCount / pageSize;
                            if (totalCount % pageSize > 0) {
                                pages += 1;
                            }
                            //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                            //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                            next(lis.join(''), page < pages);
                        } else {
                            layer.alert(data.resultMsg, {
                                icon: 5,
                                yes: function (index) {
                                    layer.close(index);
                                }
                            });
                        }
                    },
                    error: function() {
                        layer.alert('服务器繁忙。。。', {
                            icon: 5,
                            yes: function (index) {
                                layer.close(index);
                            }
                        });
                    }
                });
            }
        });
    });

}