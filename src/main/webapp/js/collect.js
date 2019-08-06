var optionsRes = {};

function getForm() {
    var url = $.getRootApi() + "/bottle/listAllCountByTime";
    $.ajax({
        type : "GET", //提交方式
        url : url,//路径
        async : false,
        data : {},//数据，这里使用的是Json格式进行传输
        success : function(data) {//返回数据根据结果进行相应的处理
            if (data!=null) {
                if (data.isSuccess) {
                    if ("柱状图" == optionsRes.title.text) {
                        optionsRes.series[0].data[0] = data.data.questionGoodNum;
                        optionsRes.series[0].data[1] = data.data.solveGoodNum;
                        optionsRes.series[1].data[0] = data.data.questionCommonNum;
                        optionsRes.series[1].data[1] = data.data.solveCommonNum;
                    } else {
                        optionsRes.series[0].data[0][1] = data.data.questionCommonNum;
                        optionsRes.series[0].data[1][1] = data.data.solveCommonNum;
                        optionsRes.series[0].data[2].y = data.data.questionGoodNum;
                        optionsRes.series[0].data[3][1] = data.data.solveGoodNum;
                    }
                } else {
                    layer.alert(data.resultMsg, {
                        icon: 5,
                        yes: function (index) {
                            layer.close(index);
                        }
                    });
                }
            }
        }
    });
}

$(document).ready(function(){
    optionsRes  = column();
    getForm();
    Highcharts.chart('container', optionsRes);
});

function showImage(type) {
    if (type==1) {
        optionsRes  = column();
    }
    if (type==2) {
        optionsRes  = plot();
    }
    getForm();
    Highcharts.chart('container', optionsRes);
}

function plot() {
    var options = {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '饼状图'
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: '浏览器访问量占比',
            data: [
                ['普通作业求解瓶',   10],
                ['普通知识问答瓶',       10],
                {
                    name: '优质作业求解瓶',
                    y: 10,
                    sliced: true,
                    selected: true
                },
                ['优质知识问答瓶',    10],
            ]
        }],
        credits: {
            enabled: false
        }
    }
    return options;
}

function column() {
    var options = {
        chart: {
            type: 'column'
        },
        title: {
            text: '柱状图'
        },
        xAxis: {
            categories: ['作业求解瓶', '知识问答瓶']
        },
        yAxis: {
            min: 0,
            title: {
                text: '点赞数'
            },
            stackLabels: {
                enabled: true,
                style: {
                    fontWeight: 'bold',
                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                }
            }
        },
        legend: {
            align: 'right',
            x: -30,
            verticalAlign: 'top',
            y: 25,
            floating: true,
            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
            borderColor: '#CCC',
            borderWidth: 1,
            shadow: false
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.x + '</b><br/>' +
                    this.series.name + ': ' + this.y + '<br/>' +
                    '总量: ' + this.point.stackTotal;
            }
        },
        plotOptions: {
            column: {
                stacking: 'normal',
                dataLabels: {
                    enabled: true,
                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                    style: {
                        textShadow: '0 0 3px black'
                    }
                }
            }
        },
        series: [{
            name: '优质',
            data: [5, 3]
        }, {
            name: '普通',
            data: [2, 2]
        }],
        credits: {
            enabled: false
        }
    };
    return options;
}


