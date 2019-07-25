<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
			<tr>
				<th>转账帐号</th>
				<th>收款帐号</th>
				<th>转账金额</th>
			</tr>
			<c:forEach items="${pageinfo.list}" var="log">
				<tr>
					<td>${log.accOut}</td>
					<td>${log.accIn}</td>
					<td>${log.money}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="show?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber-1}" <c:if test="${pageinfo.pageNumber<=1}"> onclick="javascript:return false;"</c:if>>上一页</a>
		<a href="show?pageSize=${pageinfo.pageSize}&pageNumber=${pageinfo.pageNumber+1}" <c:if test="${pageinfo.pageNumber>=pageinfo.total}"> onclick="javascript:return false;"</c:if>>下一页</a>
	</body>
</html>