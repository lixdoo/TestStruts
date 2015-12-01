<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 用于测试：显示请求参数 -->
	<%out.println("<h1>"+request.getParameter("userId")+"</h1>"); %>
	
	<!-- 显示出用户名，不同的用户username不同 -->
	
	<h1>
		<s:property value="user.userName"/>
	</h1>

</body>
</html>