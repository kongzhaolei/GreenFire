<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>greenfire-关键字信息</title>
</head>
<body>
<div class="am-cf admin-main">
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">关键字信息</strong> / <small>keyWord information</small></div>
    </div>
    
    <hr>
    <div class="am-g">
      <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
      </div>
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
        <form class="am-form am-form-horizontal" action="updateKeyWrod" method="post">
          <div class="am-form-group" >
            <label for="user-name" class="am-u-sm-3 am-form-label" >关键字ID / KID</label>
            <div class="am-u-sm-9">
              <input type="text" name="kid" placeholder="关键字ID / KID" readonly="readonly" value="${keyInfo.id}">
            </div>
          </div>
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">关键字名称 / Name</label>
            <div class="am-u-sm-9">
              <input type="text" name="kname" placeholder="关键字名称  / KeyName" value="${keyInfo.keyname}">
            </div>
          </div>
          
		  <div class="am-form-group">
            <label for="user-QQ" class="am-u-sm-3 am-form-label">参数/ Password</label>
            <div class="am-u-sm-9">
              <input type="text" name="kpar" placeholder="参数/ Parameter" value="${keyInfo.parameter}">
            </div>
          </div>
          
          <div class="am-form-group">
            <label for="user-email" class="am-u-sm-3 am-form-label">备注 / Email</label>
            <div class="am-u-sm-9">
              <input type="text" name="knote" placeholder="备注 / Note" value="${keyInfo.note}">
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