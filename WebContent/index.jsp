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
<title>GreenFire-首页</title>
<script src="${pageContext.request.contextPath}/js/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/js/indexInfo.js"></script>
</head>
<body>
<div class="am-cf admin-main">
  <!-- content start -->
  <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>Index</small></div>
    </div>
    <hr>
    
    <!-- 项目用例通过情况 -->
    <div class="am-panel am-panel-primary">
  		<div class="am-panel-hd">
  			<h3 class="am-panel-title">&nbsp&nbsp&nbsp项目用例通过情况</h3>
  		</div>
  		<div class="am-panel-bd">
  			<div id="project" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
  		</div>
  	</div>
  	
  	<!-- 用例通过率情况 -->
  	<div class="am-panel am-panel-primary">
  		<div class="am-panel-hd">
  			<h3 class="am-panel-title">&nbsp&nbsp&nbsp用例通过率情况</h3>
  		</div>
  		<div class="am-panel-bd">
  			<div id="Case" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
  		</div>
  	</div>
  </div>
  
  <!-- content end -->
</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2015 ATMS Inc.</p>
</footer>
</body>
</html>