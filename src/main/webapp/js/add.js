window.onload=function (ev) {
    var LocString = String(window.document.location.href);
    var urls = LocString.split("=");
    var bottleType = urls[1];

    $("#bottle-type").val(bottleType);
    // // var userId = $("#user-id").val();
    // // var bottleId = $("#bottle-id").val();
    // var url = $.getRootApi() +"bottle/get/"+bottleId;
    //
    // $.ajax({
    //     type : "GET", //提交方式
    //     url : url,//路径
    //     contentType: 'application/json;charset=utf-8',
    //     data : {},//数据，这里使用的是Json格式进行传输
    //     success : function(data) {//返回数据根据结果进行相应的处理
    //         alert(data)
    //     }
    // });
    //
    // $("#bottle-id").val(bottleId);
}