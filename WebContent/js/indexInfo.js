//项目用例情况柱状图
$(function(){
	$(document).ready(function () { 
		var jsonXData = [];  
        var jsonyCase = [];  
        var jsonyPass = [];
        var jsonyFail = [];
       //获取数据
        $.ajax({
    		type:"POST",
    		dataType:"json",
    		cache: false, 
    		async: false,
    		url:'indexProInfo',
    		success:function(data){
    			for(i=0;i<data.length;i++){
    				jsonXData[i] = data[i].Name;
    				jsonyCase[i] = data[i].CaseNum;
    				jsonyPass[i] = data[i].PassNum;
    				jsonyFail[i] = data[i].FailNum;
    			}
    			var chart;  
    			chart = new Highcharts.Chart({
    				chart:{
    					renderTo:'project', //Div 容器ID
    					plotBackgroundColor: null, //绘图区的背景颜色
    		            plotBorderWidth: 1,//null, //绘图区边框高度
    					type: 'column'
    				},
    				title:{
    					text: 'Project Case Situation'
    				},
    				subtitle: {
    		            text: ''
    		        },
    		        //Y轴显示内容
    		        yAxis: {
    		            min: 0,
    		            title: {
    		                text: '数量 (个数)'
    		            }
    		        },
    		        xAxis: {//X轴数据  
                        categories: jsonXData
                    },  
                    tooltip: {
                        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
                        footerFormat: '</table>',
                        shared: true,
                        useHTML: true
                    },
                    plotOptions: {
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                    //数据
                    series:[{
                    	name: 'CaseNum', 
                    	data: jsonyCase
                    },{
                    	name: 'PassNum',
                    	color: '#00B400',
                    	data: jsonyPass
                    },{
                    	name: 'FailNum',
                    	color: '#C80000',
                    	data: jsonyFail
                    }]
    			});
    		},
    		error:function(e){
    			
    		}
    	});
	});
});
//用例执行饼图
$(function(){
	var chart;
	$(document).ready(function(){
		chart = new Highcharts.Chart({
			//常规图表选项设置
			chart:{
				renderTo:'Case', //Div 容器ID
				plotBackgroundColor: null, //绘图区的背景颜色
	            plotBorderWidth: 1,//null, //绘图区边框高度
	            plotShadow: false //绘图区域是否显示阴影
			},
			colors:[
			    '#00B400',
			    '#C80000'
			],
			//图表的主标题
			title:{
				text: 'Case execution'
			},
			//当鼠标经过时的提示设置
			tooltip: {
	        	formatter: function() {
	        		return '<b>'+ this.point.name +'</b>: '+ this.percentage.toFixed(2) +' %';
	        	}
	        },
	        //每种图表类型属性设置
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    formatter: function() {
	                    	return '<b>'+ this.point.name +'</b>: '+ this.percentage.toFixed(2) +' %';
	                    }
	                }
	            }
	        },
	        //图表展示的数据
	        series: [{
	            type: 'pie',
	            name: '用例执行情况'
	        }]
		});
	});
	$.ajax({
		type:"POST",
		dataType:"json",
		url:'indexCaseRunInfo',
		success:function(data){
			//定义一个数组
			runInfo = [],
			//迭代，把异步获取的数据放到数组中
			$.each(data,function(i,d){
				runInfo.push([d.name,d.share]);
			});
			//设置数据
			chart.series[0].setData(runInfo);
		},
		error:function(e){
			
		}
	});
});