<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>你好,
	
	<!--<s:property value ="user.userName"/>  -->
	<s:property value="#session['001'].userName"/>		
	</h1>
		
	
	<s:debug/>
</body>
</html>