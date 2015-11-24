<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Project List</h1>
	<h2>
		<a href="projectlist.action?page=${page-1}">上一页</a>|第${page}页|
		<a href="projectlist.action?page=${page+1}">下一页</a>
	</h2>
	<table width="90%" border="2">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Start Date</td>
			<td>End Date</td>
			
		</tr>
		
		<c:forEach items="${projectList}" var = "projectEntity">
			<tr>
				<td>${projectEntity.id} </td>
				<td>${projectEntity.name }</td>
				<td>${projectEntity.startDate }</td>
				<td>${projectEntity.endDate }</td>
			</tr>
		</c:forEach>
	
	
	</table>

</body>
</html>