<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>greenfire-修改配置</title>
</head>
<body>
<div class="am-cf admin-main">
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改配置</strong> / <small>Update Settings</small></div>
    </div>
    <hr>
    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
      </div>
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" action="updateSettingInfo" method="post">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">编号/ ID</label>
            <div class="am-u-sm-9">
              <input type="text" name="sid" placeholder="编号/ ID" readonly="readonly" value="${setting.sid}">
            </div>
          </div>
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">名称/ Name</label>
            <div class="am-u-sm-9">
              <input type="text" name="aname" placeholder="名称/ Name" value="${setting.aliasName}">
            </div>
          </div>
          
		  <div class="am-form-group">
            <label for="user-QQ" class="am-u-sm-3 am-form-label">远程URL/ URL</label>
            <div class="am-u-sm-9">
              <input type="text" name="rurl" placeholder="远程URL/ URL" value="${setting.remodeUrl}">
            </div>
          </div>
          
          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">IP地址/ IPAddress</label>
            <div class="am-u-sm-9">
              <input type="text" name="ip" placeholder="IP地址/ IPAddress" value="${setting.localIP}">
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
  <p class="am-padding-left">© 2015 ATMS Inc.</p>
</footer>
</body>
</html>