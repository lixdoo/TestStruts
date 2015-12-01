<%@page pageEncoding ="utf-8"%>
<html>
	<head>
		<title>
		</title>
	</head>
	
	<body>
		<form action="login.action" method="post">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input name="user.userName" type="text"/></td>
				</tr>
				
				<tr>
					<td>密码：</td>
					<td><input name="user.password" type="password"/></td>
				</tr>
				
			    <tr colspan="2">
			    	<td>
			    		<input value="提交" type="submit"/>
			    	</td>
			    </tr>
			</table>
		
		</form>
	
	</body>


</html>