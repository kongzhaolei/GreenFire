<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="GreenFire">
<meta name="keywords" content="GreenFire">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/images/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css">

<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/js/polyfill/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/polyfill/modernizr.js"></script>
<script src="${pageContext.request.contextPath}/js/polyfill/rem.min.js"></script>
<script src="${pageContext.request.contextPath}/js/polyfill/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="${pageContext.request.contextPath}/js/app.js"></script>
</head>

<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
	<header class="am-topbar admin-header">
	<div class="am-topbar-brand">
		<a href="index.jsp"><strong>GreenFire</strong> <small>接口测试平台</small></a>
	</div>
	<ul
		class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
		<li class="am-dropdown" data-am-dropdown><a
			class="am-dropdown-toggle" data-am-dropdown-toggle
			href="javascript:;"><span class="am-icon-user"></span> ${name} <span
				class="am-icon-caret-down"></span></a>
			<ul class="am-dropdown-content">
				<li><a href="userInfo?name=${name}"><span
						class="am-icon-user"></span> 资料</a></li>
			</ul></li>
		<li><a href="javascript:;" id="admin-fullscreen"><span
				class="am-icon-arrows-alt"></span> <span class="admin-fullText">全屏</span></a></li>
	</ul>
	</header>
	<!-- sidebar start -->
	<div class="admin-sidebar">
		<ul class="am-list admin-sidebar-list">
			<li><a href="index.jsp"><span class="am-icon-home"></span>
					首页</a></li>
			<li><a href="projectManager"><span class="am-icon-tags"></span>
					项目管理</a></li>
			<li><a href="case.jsp"><span class="am-icon-table"></span>
					用例管理</a></li>
			<li><a href="KeyManager"><span
					class="am-icon-pencil-square-o"></span> 关键字管理</a></li>
			<li><a href="report.jsp"><span class="am-icon-pie-chart"></span>
					报告管理</a></li>
			<li class="admin-parent"><a class="am-cf"
				data-am-collapse="{target: '#collapse-nav'}"><span
					class="am-icon-cog"></span> 系统设置 <span
					class="am-icon-angle-right am-fr am-margin-right"></span></a>
				<ul class="am-list am-collapse admin-sidebar-sub am-in"
					id="collapse-nav">
					<li><a href="setting.jsp"><span class="am-icon-cog"></span>
							项目设置</a></li>
					<li><a href="userManager" class="am-cf"><span
							class="am-icon-user"></span> 用户管理</a></li>
					<li><a href="log.jsp"><span class="am-icon-file"></span>
							系统日志</a></li>
					<li><a href="help.jsp"><span class="am-icon-rss-square"></span>
							帮助</a></li>
				</ul></li>
			<li><a href="logout.jsp"><span class="am-icon-sign-out"></span>
					注销</a></li>
		</ul>

		<div class="am-panel am-panel-default admin-sidebar-panel">
			<div class="am-panel-bd">
				<p>
					<span class="am-icon-tag"></span> 小贴士
				</p>
				<p></p>
			</div>
		</div>
	</div>
	<!-- sidebar end -->
</body>
</html>