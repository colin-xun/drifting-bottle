// window.onload=function (ev) {
//     getBottles('0')
// }

var userId = $("#user-id").val();
// var startIndex = 0;
var pageSize = 15;
var pageIndex = 1;
var totalCount = 0;


function getBottles() {
    var bottleTitle = $("#sendText").val();
    var url = $.getRootApi() +"bottle/listAll?page=" + pageIndex +"&pageSize="+pageSize+"&bottleTitle="+bottleTitle;
    $.ajax({
        type : "GET", //提交方式
        url : url,//路径
        async:false,
        data : {},//数据，这里使用的是Json格式进行传输
        success : function(data) {//返回数据根据结果进行相应的处理
            if (data != null) {
                var allItem = data.data;
                $("#pageCount").val(allItem.totalCount);
                //设置分页数据
                pageIndex = data.data.pageIndex;
                pageSize = data.data.pageSize;
                totalCount = data.data.totalCount;

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
                        allStr += '<li class="fly-list-li"><h2 class="fly-tip"><a href="detail2.html?bottleId='+bottleId+'">' + title + '</a><span class="fly-tip-stick" style="float: right">' + typeName + '</span></h2><p><span>' + updateTime + '</span><a href="#" onclick="deleteBottle('+bottleId+')"></a></p></li>';
                    });
                    $("#content-list").html(allStr);
                }
            }
        }
    });
}

function deleteBottle(bottleId) {
    var userId = $("#user-id").val();
    var url = $.getRootApi() +"bottle/delete/"+bottleId;

    $.ajax({
        type: "POST", //提交方式
        url: url,//路径
        data: {
            "userId": userId
        },//数据，这里使用的是Json格式进行传输
        success: function (data) {
            if (data.isSuccess) {
                alert('成功删除！');
                window.location.reload();
            } else {
                alert(data.resultMsg);
                window.location.reload();
            }
        }
    });
}

function toPage() {
    layui.use(['laypage', 'layer'], function(){

        var laypage = layui.laypage
            ,layer = layui.layer;

        //完整功能
        laypage.render({
            elem: 'demo1'
            ,count: totalCount //数据总数
            ,limit: pageSize
            ,jump: function(obj){
                pageIndex = obj.curr;
                pageSize = obj.limit;
                getBottles();
            }
        });
    });
}


$(document).ready(function(){
    //ajax请求后台数据
    getBottles();
    toPage();
});

function getBottlesByType(type) {
    pageIndex = 1;
    getBottles(type);
    toPage();
}

function getAllBottle() {
    getBottles();
    toPage();
}
