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
 <base href="<%=basePath%>">
<title>greenfire-项目管理</title>
<script type="text/javascript">
$(function(){
	$('#delete-confirm-project').on('click',function(){
		$('#delete-project').modal({
			relatedElement:this,
			onConfirm:function(){
				var deletes = document.getElementsByName("chkbox");
				var count = 0;
				var pros = new Array();
				for(var i = 0;i<deletes.length;i++) {
					if(deletes[i].checked) {
						count++;
						pros.push(deletes[i].value);
					}
				}
				if (count == 0) {
					alert("请选择需要删除的选项!");
					return false;
				}
				var oform = document.getElementsByTagName("form")[0];
				oform.action = "deleteProject?proIds="+pros;
				oform.submit();
			},
			onCancel:function(){
				alert('lalala');
			}
		});
	});
});
</script>
</head>
<body>
<div class="am-cf admin-main">
  <!--content start  -->
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">项目管理</strong> / <small>Project</small></div>
    </div>
    <hr>
    <!-- 操作栏 -->
    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
              <button class="am-btn am-btn-primary" data-am-modal="{target:'#Newproject'}"><span class="am-icon-plus"></span> 新增</button>
              <button class="am-btn am-btn-warning" id="delete-confirm-project"><span class="am-icon-trash-o"></span> 删除</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 新增项目 -->
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="Newproject" style="width: 500px">
    	<div class="am-modal-dialog">
    		<div class="am-modal-hd">新增项目
    			<a href="javascript:void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    		</div>
    		<div class="am-modal-bd">
    			<form class="am-form am-form-horizontal" method="post" action="AddProject" >
    				<div class="am-form-group">
           				<label for="user-name" class="am-u-sm-3 am-form-label">项目名称：</label>
            			<div class="am-u-sm-9">
              				<input type="text" name="newProname" placeholder="项目名称">
            			</div>
            			<div class="am-form-group">
            				<label for="user-intro" class="am-u-sm-3 am-form-label">项目描述：</label>
            				<div class="am-u-sm-9">
              					<textarea class="" rows="5" name="newProdesc" placeholder="项目描述"></textarea>
            				</div>
          				</div>
          				<div class="am-form-group">
            				<div class="am-u-sm-9 am-u-sm-push-3">
              					<button type="submit" class="am-btn am-btn-primary">新增</button>
            				</div>
          				</div>
          			</div>
    			</form>
    		</div>
    	</div>
    </div>
    <!-- 删除项目 -->
    <div class="am-modal am-modal-confirm" tabindex="-1" id="delete-project" style="width: 500px">
    	<div class="am-modal-dialog">
    		<div class="am-modal-hd">删除项目</div>
    		<div class="am-modal-bd">亲，你确定要删除该项目吗？</div>
    		<div class="am-modal-footer">
    			<span class="am-modal-btn" data-am-modal-cancel>取消</span>
    			<span class="am-modal-btn" data-am-modal-confirm>确定</span>
    		</div>
    	</div>
    </div>
    <!-- 列表信息 -->
    <div  class="am-u-sm-12" name="proInfo">
    	<form class="am-form" name="proInfo-form">
    		<table class="am-table am-table-striped am-table-hover table-main">
            	<thead>
              		<tr>
                		<th class="table-check"><input type="checkbox" id="chkAll" name="chkAll" onclick="SelectAll()" /></th><th class="table-id">ID</th><th class="table-title">项目名称</th><th class="table-type">描述</th><th class="table-date">创建日期</th>
              		</tr>
         		</thead>
         		<tbody>
         		 <c:forEach var="pro" items="${prosList}">
         			<tr>
         				<td><input type="checkbox" name="chkbox" value="${pro.pid }" /></td>
              			<td>${pro.pid }</td>
              			<td><a href="proInfo?pid=${pro.pid }" >${pro.proname }</a></td>
              			<td>${pro.describe }</td>
              			<td>${pro.createTime }</td>
         			</tr>
         		 </c:forEach>
         		</tbody>
         	</table>
    	</form>
    </div>
  </div>
</div>
  <!--content end  -->
  
<footer>
  <hr>
  <p class="am-padding-left">© 2015 ATMS Inc.</p>
</footer>
</body>
</html>