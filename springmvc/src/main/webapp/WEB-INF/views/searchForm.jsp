<%@page import="com.te.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%String message=(String)request.getAttribute("msg");
    EmployeeBean bean=(EmployeeBean)request.getAttribute("data");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<%
	if (message != null && !message.isEmpty()) {
	%>
	<h1 style="color: blue"><%=message%></h1>
	<%
	}
	%>
	<form action="./empsearch" method="get">
		<label>Search</label> <label>:</label> <input type="search" name="id">
		<br> <input type="submit" value="search">
	</form>
	<%if(bean!=null){ %>
	<h4 style="color: blue">
		Name: <%=bean.getName() %></h4>
	<h4 style="color: blue">
		Id: <%=bean.getId()%></h4>
	<h4 style="color: blue">
		DOB: <%=bean.getBirthDate()%></h4>
	<%} %>
</body>
</html>