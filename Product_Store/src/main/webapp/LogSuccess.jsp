<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.product.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("Welcome Mr."+ab.getFname());
%>
<a href="Addproduct.html">AddProduct</a>
<a href="View">ViewProduct</a>
<a href="logout">Logout</a>
</body>
</html>