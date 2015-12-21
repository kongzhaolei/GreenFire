<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>greenfire-新建用例</title>
<script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
<script type="text/javascript">
	var newRowID = 0;
	function init() {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : 'caseProinfo',
			async : false,
			success : function(data) {
				$.each(data, function(key, val) {
					$("#pid").append(
							'<option value="' + val.id + '">' + val.name
									+ '</option>');
				});
			}
		});
		$.ajax({
			type : "POST",
			dataType : "json",
			url : 'locatorNameInfo',
			async : false,
			success : function(data) {
				var olocators = document.getElementsByName("locator");
				var temp = "";
				temp += '<option>---请选择---</option>';
				$.each(data, function(key, val) {
					temp += '<option value="' + val.name + '">' + val.name
							+ '</option>';
				});
				for (i = 0; i < olocators.length; i++) {
					olocators[i].innerHTML = temp;
				}
			}
		});
		$.ajax({
			type : "POST",
			dataType : "json",
			url : 'KeyNameInfo',
			async : false,
			success : function(data) {
				var oKnames = document.getElementsByName("kname");
				var temp = "";
				temp += '<option>---请选择---</option>';
				$.each(data, function(key, val) {
					temp += '<option value="' + val.name + '">' + val.name
							+ '</option>';
				});
				for (i = 0; i < oKnames.length; i++) {
					oKnames[i].innerHTML = temp;
				}
			}
		});
	}
	$(document).ready(function() {
		$("#save").click(function() {
			$.ajax({
				type : "POST",
				dataType : "json",
				url : 'addCaseAndCaseStep',
				data : $('#caseForm').serialize(),
				async : false,
				success : function(data) {
					alert("添加成功！");
					self.location = 'case.jsp';
				},
				error : function(request) {
					alert("添加失败！");
				}
			});
		})
	})

	//绑定返回按钮 onclick事件
	$(document).ready(function() {
		$("#goBack").click(function() {
			window.location.href = "javascript:history.go(-1);";
		})
	})
	function deleteRow(rowID) {
		if ($('.stepID').size() == 1)
			return;
		$('#row' + rowID).remove();
		updateStepID();
		init();
	}
	function preInsert(rowID) {
		$('#row' + rowID).before(createRow());
		updateStepID();
		init();
	}
	function postInsert(rowID) {
		$('#row' + rowID).after(createRow());
		updateStepID();
		init();
	}

	function createRow() {
		if (newRowID == 0)
			newRowID = $('.stepID').size();
		newRowID++;
		var newRow = "<tr id='row" + newRowID + "'>";
		newRow += "<td class='stepID'></td>";
		newRow += "<td><input type='text' name='desc' id='desc'></td>";
		newRow += "<td><select id='kname' name='kname'></select></td>";
		newRow += "<td><select id='locator' name='locator'></select></td>";
		newRow += "<td><input type='text' name='locatValue' id='locatValue'></td>";
		newRow += "<td><input type='text' name='tsdata' id='tsdata'></td>";
		newRow += "<td><div class='am-btn-toolbar'>";
		newRow += "<input type='button'  tabindex='-1' class='am-btn am-btn-default am-btn-xs am-text-secondary' value='之前添加' onclick='preInsert("
				+ newRowID + ")'/>";
		newRow += "<input type='button'  tabindex='-1' class='am-btn am-btn-default am-btn-xs' value='之后添加' onclick='postInsert("
				+ newRowID + ")'/>";
		newRow += "<input type='button'  tabindex='-1' class='am-btn am-btn-default am-btn-xs am-text-danger' value='删除' onclick='deleteRow("
				+ newRowID + ")'/>";
		newRow += "</div></td>";
		newRow += "</tr>";
		return newRow;
	}
	function updateStepID() {
		var i = 1;
		$('.stepID').each(function() {
			$(this).html(i++)
		});
	}
</script>
</head>
<body onload="init()">
	<div class="am-cf admin-main">
		<div class="admin-content">
			<div class="am-cf am-padding">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">新建用例</strong> / <small>New
						Case</small>
				</div>
			</div>
			<form id="caseForm" class="am-form">
				<table class="am-table">
					<tbody>
						<tr>
							<th>项目名称</th>
							<td colspan="3"><select name="pid" id="pid">
									<option>--- 请选择 ---</option>
							</select></td>
						</tr>
						<tr>
							<th>是否启用</th>
							<td colspan="3"><select name="runmode" id="runmode"
								class="form-control">
									<option value="Yes">是</option>
									<option value="No">否</option>
							</select></td>
						</tr>
						<tr>
							<th>用例标题</th>
							<td colspan="3"><input type="text" name="title" id="title"></td>
						</tr>
						<tr>
							<th>用例步骤</th>
							<td colspan="3">
								<table class="am-table table-main">
									<thead>
										<tr>
											<th>编号</th>
											<th>描述</th>
											<th>关键字</th>
											<th>元素属性</th>
											<th>属性值</th>
											<th>参数/预期值</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<tr id="row1">
											<td class="stepID">1</td>
											<td><input type="text" name="desc" id="desc"></td>
											<td><select id="kname" name="kname"></select></td>
											<td><select id="locator" name="locator"></select></td>
											<td><input type="text" name="locatValue" id="locatValue"></td>
											<td><input type="text" name="tsdata" id="tsdata"></td>
											<td>
												<div class="am-btn-toolbar">
													<input type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs am-text-secondary"
														onclick="preInsert(1)" value="之前添加" /> <input
														type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs"
														onclick="postInsert(1)" value="之后添加" /> <input
														type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs am-text-danger"
														onclick="deleteRow(1)" value="删除" />
												</div>
											</td>
										</tr>
										<tr id="row2">
											<td class="stepID">2</td>
											<td><input type="text" name="desc" id="desc"></td>
											<td><select id="kname" name="kname"></select></td>
											<td><select id="locator" name="locator"></select></td>
											<td><input type="text" name="locatValue" id="locatValue"></td>
											<td><input type="text" name="tsdata" id="tsdata"></td>
											<td>
												<div class="am-btn-toolbar">
													<input type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs am-text-secondary"
														onclick="preInsert(2)" value="之前添加" /> <input
														type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs"
														onclick="postInsert(2)" value="之后添加" /> <input
														type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs am-text-danger"
														onclick="deleteRow(2)" value="删除" />
												</div>
											</td>
										</tr>
										<tr id="row3">
											<td class="stepID">3</td>
											<td><input type="text" name="desc" id="desc"></td>
											<td><select id="kname" name="kname"></select></td>
											<td><select id="locator" name="locator"></select></td>
											<td><input type="text" name="locatValue" id="locatValue"></td>
											<td><input type="text" name="tsdata" id="tsdata"></td>
											<td>
												<div class="am-btn-toolbar">
													<input type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs am-text-secondary"
														onclick="preInsert(3)" value="之前添加" /> <input
														type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs"
														onclick="postInsert(3)" value="之后添加" /> <input
														type="button" tabindex="-1"
														class="am-btn am-btn-default am-btn-xs am-text-danger"
														onclick="deleteRow(3)" value="删除" />
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td colspan="7">
								<div class="am-margin">
									<button type="button" id="save"
										class="am-btn am-btn-primary am-btn-xs">保存</button>
									<button type="button" id="goBack"
										class="am-btn am-btn-primary am-btn-xs">返回</button>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<footer>
	<hr>
	<p class="am-padding-left">© 2015 ATMS Inc.</p>
	</footer>
</body>
</html>