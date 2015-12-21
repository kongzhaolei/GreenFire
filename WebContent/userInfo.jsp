<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>greenfire-个人资料</title>
</head>
<body>
<div class="am-cf admin-main">
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>Personal information</small></div>
    </div>
    
    <hr>
    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
      </div>
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" action="updateUser" method="post">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">编号 / ID</label>
            <div class="am-u-sm-9">
              <input type="text" name="uid" placeholder="编号 / ID" readonly="readonly" value="${userinfo.id}">
            </div>
          </div>
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
            <div class="am-u-sm-9">
              <input type="text" name="uname" placeholder="姓名 / Name" value="${userinfo.username}">
            </div>
          </div>
          
		  <div class="am-form-group">
            <label for="user-QQ" class="am-u-sm-3 am-form-label">密码/ Password</label>
            <div class="am-u-sm-9">
              <input type="password" name="upwd" placeholder="密码/ Password" value="${userinfo.password}">
            </div>
          </div>
          
          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
            <div class="am-u-sm-9">
              <input type="text" name="uemail" placeholder="输入你的电子邮件 / Email" value="${userinfo.email}">
            </div>
          </div>

          <div class="am-form-group">
            <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
            <div class="am-u-sm-9">
              <input type="text" name="uphone" placeholder="输入你的电话号码 / Telephone" value="${userinfo.phone}">
            </div>
          </div>

          <div class="am-form-group">
            <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="submit" class="am-btn am-btn-primary">保存修改</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<footer>
  <hr>
  <p class="am-padding-left"></p>
</footer>
</body>
</html>