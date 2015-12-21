<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>greenfire-用例管理</title>
<script type="text/javascript">
	$(function() {
		$('#runTestCase').on('click', function() {
			$('#run-TestCase').modal({
				relatedElement : this,
				onConfirm : function() {
					var spid = $('#sPro').children('option:selected').val();
					;
					if (spid == '--- 请选择 ---') {
						alert("请选择需要执行的项目选项!");
						return false;
					}
					var caseids = document.getElementsByName("chkbox");
					var count = 0;
					var tcids = new Array();
					for (var i = 0; i < caseids.length; i++) {
						if (caseids[i].checked) {
							count++;
							tcids.push(caseids[i].value);
						}
					}
					if (count == 0) {
						alert("请选择需要执行的用例选项!");
						return false;
					}
					$.ajax({
						type : "POST",
						dataType : "json",
						url : 'runTestCase',
						data : "pid=" + spid + "&tcid=" + tcids,
						success : function(data) {
							if (data.state == 'true') {
								alert("用例执行完毕!");
							} else {
								alert("亲，请先在'系统设置'里面设置远程URL地址!");
							}
						}
					});
				},
				onCancel : function() {

				}
			});
		});
	});
	function init() {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : 'caseProinfo',
			success : function(data) {
				$.each(data, function(key, val) {
					$("#sPro").append(
							'<option value="' + val.id + '">' + val.name
									+ '</option>');
					$("#pname").append(
							'<option value="' + val.id + '">' + val.name
									+ '</option>');
				});
			}
		});
	}
	$(document).ready(function() {
		$("#newcase").click(function() {
			window.location.href = "addCase.jsp";
		})
	})
	$(document)
			.ready(
					function() {
						$('#sPro')
								.change(
										function() {
											var pid = $(this).children(
													'option:selected').val();
											$
													.ajax({
														url : 'findProCaseInfo',
														data : {
															pid : pid
														},
														type : 'POST',
														dataType : "json",
														success : function(data) {
															var tbody = '';
															$
																	.each(
																			data,
																			function(
																					key,
																					val) {
																				tbody += '<tr>';
																				tbody += '<td><input type="checkbox" name="chkbox" value="'+val.tcid+'" /></td>';
																				tbody += '<td>'
																						+ val.tcid
																						+ '</td>';
																				tbody += '<td><a href="caseInfo?tcid='
																						+ val.tcid
																						+ '&pid='
																						+ pid
																						+ '" >'
																						+ val.title
																						+ '</a></td>';
																				tbody += '<td>'
																						+ val.runmode
																						+ '</td>';
																				tbody += '<td>'
																						+ val.createTime
																						+ '</td>';
																				tbody += '</tr>';
																			});
															//加载数据到页面的 <tbody>标签中
															$('.admin-content .am-u-sm-12 tbody')[0].innerHTML = tbody;
														}
													})
										})
					})
</script>
</head>
<body onload="init()">
	<div class="am-cf admin-main">
		<div class="admin-content">
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">用例管理</strong> / <small>Test
						Case</small>
				</div>
			</div>
			<hr>
			<!-- 操作栏 -->
			<div class="am-g">
				<div class="am-u-md-6 am-cf">
					<div class="am-fl am-cf">
						<div class="am-btn-toolbar am-fl">
							<div class="am-btn-group am-btn-group-xs">
								<button class="am-btn am-btn-primary" id="newcase">
									<span class="am-icon-plus"></span> 新增
								</button>
								<button class="am-btn am-btn-success" id="runTestCase">
									<span class="am-icon-play"></span> 执行用例
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="am-u-md-3 am-cf">
					<div class="am-fr">
						<div class="am-input-group am-input-group-sm">
							项目切换： <select id="sPro"><option>--- 请选择 ---</option></select>
						</div>
					</div>
				</div>
			</div>
			<!-- 删除用例 -->
			<div class="am-modal am-modal-confirm" tabindex="-1"
				id="run-TestCase" style="width: 500px">
				<div class="am-modal-dialog">
					<div class="am-modal-hd">执行用例</div>
					<div class="am-modal-bd">亲，是否要执行勾选的用例?</div>
					<div class="am-modal-footer">
						<span class="am-modal-btn" data-am-modal-cancel>取消</span> <span
							class="am-modal-btn" data-am-modal-confirm>确定</span>
					</div>
				</div>
			</div>
			<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
				<div class="am-modal-dialog">
					<div class="am-modal-hd">执行用例</div>
					<div class="am-modal-bd">
						远程URL地址 <input type="text" class="am-modal-prompt-input">
					</div>
					<div div class="am-modal-footer">
						<span class="am-modal-btn" data-am-modal-cancel>取消</span> <span
							class="am-modal-btn" data-am-modal-confirm>提交</span>
					</div>
				</div>
			</div>
			<!-- 列表信息 -->
			<div class="am-u-sm-12" id="caseInfolist">
				<form class="am-form" id="caseInfoForm">
					<table class="am-table am-table-striped am-table-hover table-main">
						<thead>
							<tr>
								<th class="table-check"><input type="checkbox" /></th>
								<th class="table-id">ID</th>
								<th class="table-title">用例名称</th>
								<th class="table-type">状态</th>
								<th class="table-title">创建日期</th>
							</tr>
						</thead>
						<tbody>

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