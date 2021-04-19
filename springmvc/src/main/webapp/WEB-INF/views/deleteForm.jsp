<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp"%>
    <%String message=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
<form action="./deleteEmp" method="get">
	<label>Id</label>
	<label>:</label>
	<input type="text" name="id">
	<br>
	<input type="submit" value="Delete">
</form>
<%
	if (message != null && !message.isEmpty()) {
	%>
	<h1 style="color:red"><%=message%></h1>
	<%
	}
	%>
</body>
</html>