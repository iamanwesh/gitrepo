<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.product.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
String ms=(String)request.getAttribute("msg");

out.println("Welcome  Mr. :"+ab.getFname()+"<br>");
out.println(ms);
%>
<a href="Addproduct.html">AddProduct</a>
<a href="View">ViewProduct</a>
<a href="logout">Logout</a>
</body>
</html>