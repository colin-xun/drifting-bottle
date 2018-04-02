function showTypeBottle() {
    $("#bottleType").hide();
}

function exchangeChance(type){
    var num = $("#integral").val();
    var msg ="您当前积分为:" + num + ",请输入您要兑换的次数（1积分=1次）"
    var exchangeNum=prompt(msg,"1");
    var userId = $("#user-id").val();
    var url = $.getRootApi() +"chance/"+userId;

    if (exchangeNum!=null && exchangeNum!=""){

        $.ajax({
            type : "POST", //提交方式
            url : url,//路径
            data : {
                "integral" : exchangeNum,
                "chanceCategory" : type
            },//数据，这里使用的是Json格式进行传输
            success : function(data) {//返回数据根据结果进行相应的处理
                if (data!=null) {
                    if (data.isSuccess) {
                        alert("兑换成功！");
                    } else {
                        alert("兑换失败！");
                    }
                }
                window.location.reload();
            }
        });
        // document.getElementById("demo").innerHTML=x;
    }
}

function showBottleType() {
    var remainNum = document.getElementById("pThrow").innerHTML
    if (remainNum > 0) {
        $("#bottleType").show();
    } else {
        exchangeChance(1)
    }
}

function getOneBottle() {
    var remainNum = document.getElementById("pGet").innerHTML
    if (remainNum > 0) {
        var userId = $("#user-id").val();
        var url = $.getRootApi() + "bottle/refloat/" + userId;
        $.ajax({
            type : "GET", //提交方式
            url : url,//路径
            data : {},//数据，这里使用的是Json格式进行传输
            success : function(data) {//返回数据根据结果进行相应的处理
                if (data.isSuccess) {
                    window.location.href = "new.html?bottleId="+data.data.bottleId;
                } else {
                    alert(data.resultMsg);
                    window.location.reload();
                }
            }
        });
    } else {
        exchangeChance(0);
    }
}




window.onload=function (ev) {
    var userId = $("#user-id").val();
    var url = $.getRootApi() +"chance/"+userId;
    $.ajax({
        type : "GET", //提交方式
        url : url,//路径
        data : {},//数据，这里使用的是Json格式进行传输
        success : function(data) {//返回数据根据结果进行相应的处理
            var nums = data.data;
            var refloatNum = nums.refloatNum;
            var throwNum = nums.throwNum;
            $("#pThrow").text(throwNum);
            $("#pGet").text(refloatNum);
        }
    });
}