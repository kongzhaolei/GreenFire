<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>greenfire-项目资料</title>
</head>
<body>
<div class="am-cf admin-main">
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">项目信息</strong> / <small>Project information</small></div>
    </div>
    <hr>
    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
      </div>
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" action="updateProject" method="post">
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">项目ID / PID :</label>
            <div class="am-u-sm-9"><input type="text" name="pid" readonly="readonly" placeholder="项目ID/ PID" value="${proInfo.pid}"></div>
          </div>
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">项目名称 / Name :</label>
            <div class="am-u-sm-9"><input type="text" name="pname" placeholder="项目名称 / Name" value="${proInfo.proname}"></div>
          </div>
          <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-3 am-form-label">项目描述 :</label>
            	<div class="am-u-sm-9"><textarea class="" rows="5" name="pdesc" placeholder="项目描述">${proInfo.describe}</textarea></div>
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