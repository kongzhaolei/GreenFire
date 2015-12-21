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
<title>greenfire-关键字管理</title>
<script type="text/javascript">
$(function(){
	$('#delete-confirm-keyword').on('click',function(){
		$('#delete-keyword').modal({
			relatedElement:this,
			onConfirm:function(){
				var deletes = document.getElementsByName("chkbox");
				var count = 0;
				var users = new Array();
				for(var i = 0;i<deletes.length;i++) {
					if(deletes[i].checked) {
						count++;
						users.push(deletes[i].value);
					}
				}
				if (count == 0) {
					alert("请选择需要删除的选项!");
					return false;
				}
				var oform = document.getElementsByTagName("form")[0];
				oform.action = "deleteUser?usersId="+users;
				oform.submit();
			},
			onCancel:function(){
				alert('你不确定是不是猴子派来的逗比?')
			}
		});
	});
});
</script>
</head>
<body>
<div class="am-cf admin-main">
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">关键字管理</strong> / <small>keyWord</small></div>
    </div>
    <hr>
    <!-- 操作栏 -->
    <div class="am-g">
      <div class="am-u-md-6 am-cf">
        <div class="am-fl am-cf">
          <div class="am-btn-toolbar am-fl">
            <div class="am-btn-group am-btn-group-xs">
              <button class="am-btn am-btn-primary" data-am-modal="{target:'#Addkeyword'}"><span class="am-icon-plus"></span> 新增</button>
              <button class="am-btn am-btn-warning" id="delete-confirm-keyword" disabled="disabled"><span class="am-icon-trash-o"></span> 删除</button>
            </div>
          </div>
        </div>
      </div>
    </div>
     <!-- 新增关键字-->
    <div class="am-modal am-modal-no-btn" tabindex="-1" id="Addkeyword" style="width: 700px;right: 700px">
    	<div class="am-modal-dialog">
    		<div class="am-modal-hd">新增关键字
    			<a href="javascript:void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    		</div>
    		<div class="am-modal-bd">	
				<form class="am-form am-form-horizontal" method="post" action="AddKeyWord">
    				<div class="am-form-group">
           				<label for="user-name" class="am-u-sm-3 am-form-label">关键字名称：</label>
            			<div class="am-u-sm-9">
              				<input type="text" name="kname" placeholder="关键字名称">
            			</div>
            		</div>
            		<div class="am-form-group">
           				<label for="user-name" class="am-u-sm-3 am-form-label">参数：</label>
            			<div class="am-u-sm-9">
              				<input type="text" name="kpar" placeholder="参数">
            			</div>
            		</div>
          			<div class="am-form-group">
            			<label for="user-intro" class="am-u-sm-3 am-form-label">备注：</label>
            			<div class="am-u-sm-9">
              				<textarea class="" rows="5" name="knote" placeholder="备注"></textarea>
            			</div>
          			</div>
          			<div class="am-form-group">
            			<div class="am-u-sm-9 am-u-sm-push-3">
              				<button type="submit" class="am-btn am-btn-primary">新增</button>
            			</div>
          			</div>
    			</form>
    		</div>
    	</div>
    </div>
    <!-- 删除用户 -->
    <div class="am-modal am-modal-confirm" tabindex="-1" id="delete-keyword" style="width: 500px">
    	<div class="am-modal-dialog">
    		<div class="am-modal-hd">删除用户信息</div>
    		<div class="am-modal-bd">亲，你确定要删除该用户吗？</div>
    		<div class="am-modal-footer">
    			<span class="am-modal-btn" data-am-modal-cancel>取消</span>
    			<span class="am-modal-btn" data-am-modal-confirm>确定</span>
    		</div>
    	</div>
    </div>
    <!-- 列表信息 -->
    <div  class="am-u-sm-12" name="userInfoform">
    	<form class="am-form" name="userInfo-form">
    		<table class="am-table am-table-striped am-table-hover table-main">
            	<thead>
              		<tr>
                		<th class="table-check"><input type="checkbox" id="chkAll" name="chkAll" onclick="SelectAll()" /></th><th class="table-id">ID</th><th class="table-title">关键字名称</th><th class="table-text">参数</th><th class="table-text">备注</th><th class="table-date">创建日期</th>
              		</tr>
         		</thead>
         		<tbody>
         		 <c:forEach var="keys" items="${keysList}">
         			<tr>
         				<td><input type="checkbox" name="chkbox" value="${keys.id }" /></td>
              			<td>${keys.id }</td>
              			<td><a href="keywordInfo?kid=${keys.id }" >${keys.keyname }</a></td>
              			<td>${keys.parameter }</td>
              			<td>${keys.note }</td>
              			<td>${keys.createTime }</td>
         			</tr>
         		 </c:forEach>
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