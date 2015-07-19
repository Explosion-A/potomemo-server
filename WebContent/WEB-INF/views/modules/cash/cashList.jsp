<%@ page contentType="text/html;charset=UTF-8" %>
<%-- <%@ include file="/WEB-INF/views/include/taglib --%>.jsp"%>
<html>
<head>
	<title>cash管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cash/cash/">cash列表</a></li>
		<shiro:hasPermission name="cash:cash:edit"><li><a href="${ctx}/cash/cash/form">cash添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="cash" action="${ctx}/cash/cash/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>type</th>
				<th>icon</th>
				<th>cash</th>
				<th>needjpoints</th>
				<th>detail</th>
				<shiro:hasPermission name="cash:cash:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cash">
			<tr>
				<td><a href="${ctx}/cash/cash/form?id=${cash.id}">
					${cash.type}
				</a></td>
				<td>
					${cash.icon}
				</td>
				<td>
					${cash.cash}
				</td>
				<td>
					${cash.needjpoints}
				</td>
				<td>
					${cash.detail}
				</td>
				<shiro:hasPermission name="cash:cash:edit"><td>
    				<a href="${ctx}/cash/cash/form?id=${cash.id}">修改</a>
					<a href="${ctx}/cash/cash/delete?id=${cash.id}" onclick="return confirmx('确认要删除该cash吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>