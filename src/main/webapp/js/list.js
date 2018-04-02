window.onload=function (ev) {
    getBottles('0')
}

function getBottles(type) {
    var userId = $("#user-id").val();
    $("#contentType").val(type);
    var url = $.getRootApi() +"bottle/list/"+userId+"?bottleCategory=" + type;
    $.ajax({
        type : "GET", //提交方式
        url : url,//路径
        data : {},//数据，这里使用的是Json格式进行传输
        success : function(data) {//返回数据根据结果进行相应的处理
            if (data != null) {
                var allItem = data.data;
                $("#pageCount").val(allItem.totalCount);
                var items = allItem.items;
                if (items!=null || items.length!=0) {
                    $("#content-list").html('');
                    var allStr = '';
                    $.each(items,function(i,result){
                        var title = result['bottleTitle']
                        var typeCode = result['bottleCategory']
                        var typeName;
                        if (typeCode==0) {
                            typeName="作业求解瓶";
                        } else {
                            typeName="知识问答瓶";
                        }
                        var bottleId = result['bottleId'];
                        var updateTime = result['updatedTime'];
                        allStr += '<li class="fly-list-li"><h2 class="fly-tip"><a href="detail.html?bottleId='+bottleId+'">' + title + '</a><span class="fly-tip-stick" style="float: right">' + typeName + '</span></h2><p><span>' + updateTime + '</span></p></li>';
                    });
                    $("#content-list").html(allStr);
                }
            }
        }
    });
}

layui.use(['laypage', 'layer'], function(){

    // var pindex = "${requestScope.page.pindex}";// 当前页
    // var ptotalpages = "${requestScope.page.ptotalpages}";// 总页数
    // var pcount = "${requestScope.page.pcount}";// 总记录数
    // var psize = "${requestScope.page.psize}";// 每一页的记录数


    var totalCount = $("#pageCount").val();
    var laypage = layui.laypage
        ,layer = layui.layer;
    //完整功能
    laypage.render({
        elem: 'demo1'
        ,count: totalCount //数据总数
        ,jump: function(obj){
            console.log(obj)
        }
    });
});

