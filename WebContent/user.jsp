<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>greenfire-用户管理</title>
<script type="text/javascript">
	$(function() {
		$('#delete-confirm-user').on('click', function() {
			$('#delete-user').modal({
				relatedElement : this,
				onConfirm : function() {
					var deletes = document.getElementsByName("chkbox");
					var count = 0;
					var users = new Array();
					for (var i = 0; i < deletes.length; i++) {
						if (deletes[i].checked) {
							count++;
							users.push(deletes[i].value);
						}
					}
					if (count == 0) {
						alert("请选择需要删除的选项!");
						return false;
					}
					var oform = document.getElementsByTagName("form")[0];
					oform.action = "deleteUser?usersId=" + users;
					oform.submit();
				},
				onCancel : function() {
					alert('好吧，你的地盘你决定!');
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
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">用户管理</strong> / <small>User</small>
				</div>
			</div>
			<hr>
			<!-- 操作栏 -->
			<div class="am-g">
				<div class="am-u-md-6 am-cf">
					<div class="am-fl am-cf">
						<div class="am-btn-toolbar am-fl">
							<div class="am-btn-group am-btn-group-xs">
								<button class="am-btn am-btn-primary"
									data-am-modal="{target:'#AddUser'}">
									<span class="am-icon-plus"></span> 新增用户
								</button>
								<button class="am-btn am-btn-warning" id="delete-confirm-user">
									<span class="am-icon-trash-o"></span> 删除用户
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 新增用户 -->
			<div class="am-modal am-modal-no-btn" tabindex="-1" id="AddUser"
				style="width: 700px; right: 700px">
				<div class="am-modal-dialog">
					<div class="am-modal-hd">
						新增用户 <a href="javascript:void(0)" class="am-close am-close-spin">&times;</a>
					</div>
					<div class="am-modal-bd">
						<form class="am-form am-form-horizontal" name="newUserFrom"
							method="post" action="addUser">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">姓名
									/ Name</label>
								<div class="am-u-sm-9">
									<input type="text" name="uname" placeholder="姓名 / Name">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-password" class="am-u-sm-3 am-form-label">密码/
									Password</label>
								<div class="am-u-sm-9">
									<input type="password" name="upwd" placeholder="密码/ Password">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-email" class="am-u-sm-3 am-form-label">电子邮件
									/ Email</label>
								<div class="am-u-sm-9">
									<input type="text" name="uemail" placeholder="输入你的电子邮件 / Email">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-phone" class="am-u-sm-3 am-form-label">电话
									/ Telephone</label>
								<div class="am-u-sm-9">
									<input type="text" name="uphone" placeholder="输入你的电话号码 / Telephone">
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
			<div class="am-modal am-modal-confirm" tabindex="-1" id="delete-user"
				style="width: 500px">
				<div class="am-modal-dialog">
					<div class="am-modal-hd">删除用户信息</div>
					<div class="am-modal-bd">亲，你确定要删除该用户吗？</div>
					<div class="am-modal-footer">
						<span class="am-modal-btn">取消</span> <span
							class="am-modal-btn">确定</span>
					</div>
				</div>
			</div>
			<!-- 列表信息 -->
			<div class="am-u-sm-12" name="userInfoform">
				<form class="am-form" name="userInfo-form">
					<table class="am-table am-table-striped am-table-hover table-main">
						<thead>
							<tr>
								<th class="table-check"><input type="checkbox" id="chkAll"
									name="chkAll" onclick="SelectAll()" /></th>
								<th class="table-id">ID</th>
								<th class="table-title">用户名</th>
								<th class="table-text">邮箱</th>
								<th class="table-text">手机号</th>
								<th class="table-date">创建日期</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="mapUser" items="${usersListMap}">
								<tr>
									<td><input type="checkbox" name="chkbox"
										value="${mapUser.id }" /></td>
									<td>${mapUser.id }</td>
									<td><a href="userInfo?uid=${mapUser.id }">${mapUser.username }</a></td>
									<td>${mapUser.email }</td>
									<td>${mapUser.phone }</td>
									<td>${mapUser.createTime }</td>
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
	<p class="am-padding-left"></p>
	</footer>
</body>
</html>