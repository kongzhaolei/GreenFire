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
<script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>greenfire-项目设置</title>
<script type="text/javascript">
function init(){
	$.ajax({
		type:"POST",
		dataType:"json",
		url:'caseProinfo',
		success : function(data){ 
			$.each(data,function(key,val){
				$("#sPro").append('<option value="' + val.id + '">' + val.name + '</option>'); 
				$("#sSPro").append('<option value="' + val.id + '">' + val.name + '</option>'); 
			});
		} 
	});
}
$(document).ready(function(){ 
	$('#sPro').change(function(){ 
		var pid = $(this).children('option:selected').val();
		$.ajax({
			url:'findSettingInfo',
			data:{pid:pid},
			type:'POST',
			dataType: "json",
			success : function(data){
				var tbody='';
				$.each(data,function(key,val){
					tbody+='<tr>';
					tbody+='<td><input type="checkbox" name="chkbox" value="'+val.sid+'" /></td>';
					tbody+='<td>'+val.sid+'</td>';
					tbody+='<td><a href="settingInfo?sid='+val.sid+'&pid='+val.pid+'" >'+val.aliasName+'</a></td>';
					tbody+='<td>'+val.remodeUrl+'</td>';
					tbody+='<td>'+val.localIP+'</td>';
					tbody+='<td>'+val.createTime+'</td>';
					tbody+='</tr>';
				});
				//加载数据到页面的 <tbody>标签中
				$('.admin-content .am-u-sm-12 tbody')[0].innerHTML=tbody;    
			}
		})
	})
})
$(document).ready(function(){
	$("#add").click(function(){
		$.ajax({
			type: 'POST',
			dataType:"json",
			url:'addSetting',
			data:$('#addForm').serialize(),
			async: false,
			success: function(data){
				 if(data.state=='true'){
					 alert("新增配置成功!");
					 self.location='setting.jsp';
				 }else{
					 alert("新增配置失败!");
				 }
			}
		});
	})
})
</script>
</head>
<body onload="init()">
<div class="am-cf admin-main">
  <!-- content start -->
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">项目设置</strong> / <small>Project Setting</small></div>
    </div>
    <hr>
    <!-- 操作栏 -->
    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
              <button class="am-btn am-btn-primary" data-am-modal="{target:'#AddSetting'}"><span class="am-icon-plus"></span> 新增配置</button>
              <button class="am-btn am-btn-warning" id="delete-Setting"><span class="am-icon-trash-o"></span> 删除配置</button>
            </div>
          </div>
        </div>
      </div>
      <div class="am-u-md-3 am-cf">
        <div class="am-fr">
          <div class="am-input-group am-input-group-sm">
          	项目切换：
            <select id="sPro" name="pid"><option > --- 请选择 --- </option></select>
          </div>
        </div>
      </div> 
    </div>
     <!-- 新增用户 -->
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="AddSetting" style="width: 700px;right: 700px">
    	<div class="am-modal-dialog">
    		<div class="am-modal-hd">新增配置
    			<a href="javascript:void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    		</div>
    		<div class="am-modal-bd">	
				<form class="am-form am-form-horizontal" id="addForm">
					<div class="am-form-group">
					 	<label for="user-name" class="am-u-sm-3 am-form-label">项目名称/ PName</label>
					 	<div class="am-u-sm-9">
					 		<select id="sSPro" name="pid"><option > --- 请选择 --- </option></select>
					 	</div> 
					</div>
					<div class="am-form-group">
					 	<label for="user-password" class="am-u-sm-3 am-form-label">名称/ Name</label>
					 	<div class="am-u-sm-9"><input type="text" name="aName" placeholder="名称/ Name"></div>
					</div>
					<div class="am-form-group">
					 	<label for="user-email" class="am-u-sm-3 am-form-label">远程URL/ URL</label>
					 	<div class="am-u-sm-9"><input type="text" name="rURL" placeholder="远程URL / Remote URL"></div>
					</div>
					<div class="am-form-group">
					 	<label for="user-phone" class="am-u-sm-3 am-form-label">IP地址/ IPAddress</label>
					 	<div class="am-u-sm-9"><input type="text" name="ip" placeholder="IP地址 / IPAddress"></div> 
					</div>
					<div class="am-form-group">
           			 <div class="am-u-sm-9 am-u-sm-push-3">
              			<button type="submit" id="add" class="am-btn am-btn-primary">新增</button>
            		 </div>
         			</div>
				</form>
    		</div>
    	</div>
    </div>
     <!-- 列表信息 -->
    <div class="am-u-sm-12" name="remodeInfoform">
    	<form class="am-form" name="remodeInfo-form">
    		<table class="am-table am-table-striped am-table-hover table-main">
            	<thead>
              		<tr>
                		<th class="table-check"><input type="checkbox" id="chkAll" name="chkAll"/></th><th class="table-id">ID</th><th class="table-title">名称</th><th class="table-text">远程URL</th><th class="table-text">IP地址</th><th class="table-date">创建日期</th>
              		</tr>
         		</thead>
         		<tbody>
         		
         		</tbody>
         	</table>
    	</form>
    </div>
  </div>
</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2015 ATMS Inc.</p>
</footer>
</body>
</html>