<!-- page指令定义JSP页面的属性 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>GreenFire-登录</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png"
	href="${pageContext.request.contextPath}/images/favicon.png">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/amazeui.min.css" />
<base href="<%=basePath%>">
<style>
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
</head>
<body>
	<div class="header">
		<div class="am-g">
			<h1>GreenFire</h1>
			<p>
				Iterface Test Platform<br />接口测试平台
			</p>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<h3>登录</h3>
			<hr>
			<br>
			<form method="post" class="am-form" name="login" action="login">
				<label for="userName">用户名:</label> <input type="text" name="name">
				<br> <label for="password">密码:</label> <input type="password"
					name="password"> <br> <label for="remember-me">
					<input id="remember-me" type="checkbox"> 记住密码
				</label> <br />
				<div class="am-cf">
					<input type="submit" name="Login" value="登 录"
						class="am-btn am-btn-primary am-btn-sm am-fl"> <input
						type="submit" name="" value="忘记密码 ? "
						class="am-btn am-btn-default am-btn-sm am-fr">
				</div>
			</form>
			<hr>
		</div>
	</div>
</body>
</html>