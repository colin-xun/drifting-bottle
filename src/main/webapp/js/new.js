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

window.onload=function (ev) {
    var LocString = String(window.document.location.href);
    var urls = LocString.split("=");
    var bottleId = urls[1];

    var url = $.getRootApi() +"bottle/get/"+bottleId;

    $.ajax({
        type : "GET", //提交方式
        url : url,//路径
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
                    // detailAbout += '<div>' + bottle.creatUserName + '</div>';
                    detailAbout += '<div class="detail-hits" data-id="{{rows.id}}"><span class="layui-btn layui-btn-mini jie-admin" type="collect" data-type="add"> <a id="collectPost" onclick="support(\'0\')"> 点赞此问题 </a> </span></div>';
                    $(".detail-about").html(detailAbout);

                    //填充内容
                    $("#detail-content").html('');
                    var detailContent = '<p>'+bottle.bottleContent+'</p>'
                    $("#detail-content").html(detailContent);

                    $("#jieda").html('');
                    var allStr = '';
                    var goodComments = data.data.goodComments;
                    if (goodComments!=null && goodComments.length>0) {
                        $.each(goodComments,function(i,result){
                            var userName = result['nickname'];
                            var pariseNum = result['pariseNum'];
                            var content = result['content'];
                            var updateTime = result['updatedTime'];
                            var commentId = result['commentId'];
                            // allStr += '<li><div class="detail-about detail-about-reply"><div>' + userName + '</div><div>' + updateTime + '</div><i class="iconfont icon-caina" title="最佳答案"> </i></div><div class="detail-body jieda-body"><p>' + content + '</p></div><div class="jieda-reply"><span class="jieda-zan" onclick="addOk('+commentId+')" type="zan"> <i class="iconfont icon-zan"> </i> <em> '+pariseNum+' </em> </span></div></li>';
                            allStr += '<li><div class="detail-about detail-about-reply"><div>' + userName + '</div><div>' + updateTime + '</div><i class="iconfont icon-caina" title="最佳答案"> </i></div><div class="detail-body jieda-body"><p>' + content + '</p></div><div class="jieda-reply"><span class="jieda-zan" type="zan"><em>点赞数:'+pariseNum+' </em> </span><div class="jieda-admin"><span class="jieda-accept" type="accept"><a href="#" onclick="addOk('+commentId+')" class="layui-btn  layui-btn-small">点赞</a></span></div></div></li>';
                        });
                    }

                    var commonComments = data.data.commonComments;
                    if (commonComments!=null && commonComments.length>0) {
                        $.each(commonComments,function(i,result){
                            var userName = result['nickname'];
                            var pariseNum = result['pariseNum'];
                            var content = result['content'];
                            var updateTime = result['updatedTime'];
                            var commentId = result['commentId'];
                            allStr += '<li><div class="detail-about detail-about-reply"><div>' + userName + '</div><div>' + updateTime + '</div></div><div class="detail-body jieda-body"><p>' + content + '</p></div><div class="jieda-reply"><span class="jieda-zan" type="zan"><em>点赞数:'+pariseNum+' </em> </span><div class="jieda-admin"><span class="jieda-accept" type="accept"><a href="#" onclick="addOk('+commentId+')" class="layui-btn  layui-btn-small">点赞</a></span></div></div></li>';
                        });
                    }

                    $("#jieda").html(allStr);
                }
            } else {
                layer.alert(data.resultMsg, {icon: 5});
            }
        }
    });

    $("#bottleId").val(bottleId);
}

function getUserById(userId) {

}

function addOk(commentId) {
    var userId = $("#userId").val();
    var url = $.getRootApi() +"praise/create/"+commentId;

    $.ajax({
        type : "POST", //提交方式
        url : url,//路径
        data : {
            "userId" : userId,
            "catetory" : 1
        },//数据，这里使用的是Json格式进行传输
        success : function(data) {//返回数据根据结果进行相应的处理
            // this.addClass("zanok")
            if (data.isSuccess){
                layer.alert('点赞成功！', {icon: 6});
                window.location.reload();
            } else {
                layer.alert(data.resultMsg, {icon: 5});
            }

        }
    });
}

