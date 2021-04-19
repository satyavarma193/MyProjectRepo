<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String messsage = (String) request.getAttribute("errmsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
	if (messsage != null && !messsage.isEmpty()) {
	%>
	<h1 style="color:red"><%=messsage%></h1>
	<%
	}
	%>

	<fieldset>
		<legend>Login</legend>
		<form action="./empLogin" method="post">
			<table>
				<tr>
					<td>Employee_id</td>
					<td>:</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>

			</table>
		</form>
	</fieldset>
</body>
</html>