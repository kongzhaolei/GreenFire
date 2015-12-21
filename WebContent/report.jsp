<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="head.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>greenfire-报告管理</title>
<script src="${pageContext.request.contextPath}/layer/layer.min.js"></script>
<script type="text/javascript">
//选择项目时，对应项目的报告
$(document).ready(function(){ 
	$('#pPname').change(function(){
		$("#accpanel").empty();
		$.ajax({
			url:'findReportCaseInfo',
			data:{pid:$(this).children('option:selected').val()},
			type:'POST',
			async:false,
			dataType: "json",
			success : function(data){
				if(data!=null){
					for(i=0;i<data.length;i++){
						if (data[i].State == "PASS" ) {
							$("#accpanel").append("<div class='am-panel-hd' id='tc"+data[i].tcid+"' style='background-color: green;'><h4 class='am-panel-title' data-am-collapse={parent:'#accordion',target:'#do-not-say-"+data[i].tcid+"'}>用例编号："+data[i].tcid+"　　　　　　　　　　　　　　　　　　　用例标题："+data[i].title+"</h4></div><div id='do-not-say-"+data[i].tcid+"' class='am-panel-collapse am-collapse am-in'><div class='am-panel-hd-"+data[i].tcid+"' id='panel-hd-"+data[i].tcid+"'></div><form class='am-form' id='caseStepInfoForm"+data[i].tcid+"'><table class='am-table am-table-striped am-table-hover table-main' id='table"+data[i].tcid+"'><thead><tr><th class='table-id'>ID</th><th class='table-title'>步骤描述</th><th class='table-title'>关键字</th><th class='table-title'>元素</th><th class='table-title'>参数</th><th class='table-type'>执行状态</th><th class='table-text'>失败图片</th></tr></thead><tbody></tbody></form></div>");
						}else if(data[i].State == "FAIL"){
							$("#accpanel").append("<div class='am-panel-hd' id='tc"+data[i].tcid+"' style='background-color: red;'><h4 class='am-panel-title' data-am-collapse={parent:'#accordion',target:'#do-not-say-"+data[i].tcid+"'}>用例编号："+data[i].tcid+"　　　　　　　　　　　　　　　　　　　　用例标题："+data[i].title+"</h4></div><div id='do-not-say-"+data[i].tcid+"' class='am-panel-collapse am-collapse am-in'><div class='am-panel-hd-"+data[i].tcid+"' id='panel-hd-"+data[i].tcid+"'></div><form class='am-form' id='caseStepInfoForm"+data[i].tcid+"'><table class='am-table am-table-striped am-table-hover table-main' id='table"+data[i].tcid+"'><thead><tr><th class='table-id'>ID</th><th class='table-title'>步骤描述</th><th class='table-title'>关键字</th><th class='table-title'>元素</th><th class='table-title'>参数</th><th class='table-type'>执行状态</th><th class='table-text'>失败图片</th></tr></thead><tbody></tbody></form></div>");
						}else{
							
						}
					}
				}
			}
		});
		$.ajax({
			url:'findReportCaseStepInfo',
			data:{pid:$(this).children('option:selected').val()},
			type:'POST',
			async:false,
			dataType: "json",
			
			success : function(data){
				if(data!=null){
					for(i=0;i<data.length;i++){
						if(data[i].result=="PASS"){
							$("#table"+data[i].tcid+" tbody").append("<tr><td>"+data[i].tsid+"</td><td>"+data[i].note+"</td><td>"+data[i].kname+"</td><td>"+data[i].locator+"="+data[i].locatorValue+"</td><td>"+data[i].strValue+"</td><td><font color='green'>"+data[i].result+"</font></td><td></td></tr>");
						}else{
							$("#table"+data[i].tcid+" tbody").append("<tr><td>"+data[i].tsid+"</td><td>"+data[i].note+"</td><td>"+data[i].kname+"</td><td>"+data[i].locator+"="+data[i].locatorValue+"</td><td>"+data[i].strValue+"</td><td><font color='red'>"+data[i].result+"</font></td><td><a href='${pageContext.request.contextPath}"+data[i].errorimage+"' target='_Blank'>查看错误图片</a></td></tr>");
						}
					}
				}
			}
		});
	})
})
function init(){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:'caseProinfo',
		success : function(data){ 
			$.each(data,function(key,val){
			  $("#pPname").append('<option value="' + val.id + '">' + val.name + '</option>'); 
			});
		} 
	});
}
</script>
</head>
<body onload="init()">
<div class="am-cf admin-main">
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">报告管理</strong> / <small>Report</small></div>
    </div>
   <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs"></div>
            <div class="am-form-group am-margin-left am-fl"></div>
          </div>
        </div>
      </div>
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
          	项目切换：<select id="pPname"><option > --- 请选择 --- </option></select>
          </div>
        </div>
      </div>
    </div>
    <br>
    <!-- 折叠面板展示报告 -->
    <div class="am-panel-group" id="accordion">
    	<div class="am-panel am-panel-default" id="accpanel" >
    		
    	</div>
    </div>
  </div>
</div>
<footer>
  <hr>
  <p class="am-padding-left">© 2015 ATMS Inc.</p>
</footer>
</body>
</html>