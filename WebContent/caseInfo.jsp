<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>greenfire-用例详情</title>
<script src="${pageContext.request.contextPath}/js/jquery-form.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#save").click(function(){
		$.ajax({
			type: "POST",
			dataType:"json",
			url:'updateCaseAndCaseStep',
			data:$('#caseInfoForm').serialize(),
			async: false,
			success: function(data){
				alert("修改成功！");
				self.location='case.jsp';
			},
			error: function(request) {}
		});
	})
})

//绑定返回按钮 onclick事件
$(document).ready(function(){
	$("#goBack").click(function(){
		 window.location.href="javascript:history.go(-1);";
	})
})
</script>
</head>
<body>
<div class="am-cf admin-main">
   <div class="admin-content">
  	<div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用例详情</strong> / <small>Case Info</small></div>
    </div>
     <form id="caseInfoForm" class="am-form">
    	<table class="am-table">
    		<tbody>
   				<tr>
    				<th>项目编号</th>
    				<td colspan="3">
    					<input type="text" name="pid" placeholder="项目编号/ PID" readonly="readonly" value="${cInfo.pid }">
    				</td>
    			</tr>
    			<tr>
    				<th>项目名称</th>
    				<td colspan="3">
    					<input type="text" name="pname" placeholder="项目名称/ PName" readonly="readonly" value="${cInfo.pName }">
    				</td>
    			</tr>
    			<tr>
    				<th>用例编号</th>
    				<td colspan="3"><input type="text" name="tcid" id="tcid"  readonly="readonly" value="${cInfo.tcid }"></td>
    			</tr>
    			<tr>
    				<th>用例标题</th>
    				<td colspan="3"><input type="text" name="title" id="title" value="${cInfo.title }"></td>
    			</tr>
    			<tr>
    				<th>是否启用</th>
    				<td colspan="3">
    					<select name="runmode" id="runmode" class="form-control">
    						<option value="Yes"<c:if test="${cInfo.runmode=='Yes'}">selected="true"</c:if>>是</option>
							<option value="No"<c:if test="${cInfo.runmode=='No'}">selected="true"</c:if>>否</option>
						</select>
    				</td>
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
    								<!-- <th>操作</th> -->
    							</tr>
    						</thead>
    						<tbody>
    							<c:forEach var="cstep" items="${cStepInfo}">
    							  <tr id="row${cstep.tsid}">
    							 	 <td class="stepID"><input type="text" name="tsid" id="tsid" readonly="readonly" value="${cstep.tsid}" style="width: 40px"></td>	
    							 	 <td><input type="text" name="desc" id="desc" value="${cstep.note}"></td>
    							 	 <td>
    							 	 	<select id="kname" name="kname">
    							 	 		<option>---请选择---</option>
    							 	 		<option value="OpenBrowser"<c:if test="${cstep.kname=='OpenBrowser'}">selected="true"</c:if>>OpenBrowser</option>
    							 	 		<option value="MaxBrowser"<c:if test="${cstep.kname=='MaxBrowser'}">selected="true"</c:if>>MaxBrowser</option>
    							 	 		<option value="Navigate"<c:if test="${cstep.kname=='Navigate'}">selected="true"</c:if>>Navigate</option>
    							 	 		<option value="Refresh"<c:if test="${cstep.kname=='Refresh'}">selected="true"</c:if>>Refresh</option>
    							 	 		<option value="Forward"<c:if test="${cstep.kname=='Forward'}">selected="true"</c:if>>Forward</option>
    							 	 		<option value="Back"<c:if test="${cstep.kname=='Back'}">selected="true"</c:if>>Back</option>
    							 	 		<option value="CloseBrowser"<c:if test="${cstep.kname=='CloseBrowser'}">selected="true"</c:if>>CloseBrowser</option>
    							 	 		<option value="OpenBrowser"<c:if test="${cstep.kname=='Click'}">selected="true"</c:if>>Click</option>
    							 	 		<option value="Input"<c:if test="${cstep.kname=='Input'}">selected="true"</c:if>>Input</option>
    							 	 		<option value="assertURL"<c:if test="${cstep.kname=='assertURL'}">selected="true"</c:if>>assertURL</option>
    							 	 		<option value="assertTitle"<c:if test="${cstep.kname=='assertTitle'}">selected="true"</c:if>>assertTitle</option>
    							 	 		<option value="assertText"<c:if test="${cstep.kname=='assertText'}">selected="true"</c:if>>assertText</option>
    							 	 		<option value="Sleep"<c:if test="${cstep.kname=='Sleep'}">selected="true"</c:if>>Sleep</option>
    							 	 		<option value="assertExistElement"<c:if test="${cstep.kname=='assertExistElement'}">selected="true"</c:if>>assertExistElement</option>
    							 	 		<option value="Menu"<c:if test="${cstep.kname=='Menu'}">selected="true"</c:if>>Menu</option>
    							 	 		<option value="RunJavaScript"<c:if test="${cstep.kname=='RunJavaScript'}">selected="true"</c:if>>RunJavaScript</option>
    							 	 		<option value="switchToFrame"<c:if test="${cstep.kname=='switchToFrame'}">selected="true"</c:if>>switchToFrame</option>
    							 	 		<option value="switchToWindow"<c:if test="${cstep.kname=='switchToWindow'}">selected="true"</c:if>>switchToWindow</option>
    							 	 	</select>
    							 	 </td>
    							 	 <td>
    							 	 	<select id="locator" name="locator">
    							 	 		<option>---请选择---</option>
    							 	 		<option value="ID"<c:if test="${cstep.locator=='ID'}">selected="true"</c:if>>ID</option>
    							 	 		<option value="Name"<c:if test="${cstep.locator=='Name'}">selected="true"</c:if>>Name</option>
    							 	 		<option value="Css"<c:if test="${cstep.locator=='Css'}">selected="true"</c:if>>Css</option>
    							 	 		<option value="Xpath"<c:if test="${cstep.locator=='Xpath'}">selected="true"</c:if>>Xpath</option>
    							 	 		<option value="TagName"<c:if test="${cstep.locator=='TagName'}">selected="true"</c:if>>TagName</option>
    							 	 		<option value="LinkText"<c:if test="${cstep.locator=='LinkText'}">selected="true"</c:if>>LinkText</option>
    							 	 		<option value="ClassName"<c:if test="${cstep.locator=='ClassName'}">selected="true"</c:if>>ClassName</option>
    							 	 		<option value="PartialLinkText"<c:if test="${cstep.locator=='PartialLinkText'}">selected="true"</c:if>>PartialLinkText</option>
    							 	 	</select>
    							 	 </td>
    								 <td><input type="text" name="locatValue" id="locatValue" value="${cstep.locatorValue}"></td>
    								 <td><input type="text" name="tsdata" id="tsdata" value="${cstep.strValue}"></td>
    								<!--  <td>
    									<input type="button" tabindex="-1" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="" value="调试" />
    								 </td> -->
    							  </tr>
    							</c:forEach>
    						</tbody>
    					</table>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="7">
    					<div class="am-margin">
    						<button type="button" id="save" class="am-btn am-btn-primary am-btn-xs">保存</button>
    						<button type="button" id="goBack" class="am-btn am-btn-primary am-btn-xs">返回</button>
  						</div> 
    				</td>
    			</tr>
    		</tbody>
    	</table>
    </form>
</div>
</body>
</html>