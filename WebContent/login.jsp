<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<th clospan="2">用户登陆</th>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="userName" name="userName" value="${userName }"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="password" name="password" value="${password }"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="登陆" /></td>
				<td><font color="red"><%=request.getAttribute("error") %></font></td>
				
			</tr>
			<tr>
			<%-- el表达式${ }可以获取page, request, session, application四大作用域中的属性 --%>
			 <td><font color="red">${error}</font></td>
			 <td></td>
			</tr>
		</table>
	</form>
</body>
</html>