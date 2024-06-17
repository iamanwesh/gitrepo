<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.product.AdminBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
out.println("Welcome  Mr. :"+ab.getFname()+"<br>");
String ms=(String)request.getAttribute("msg");
out.println(ms);
%>
<a href="View">View Product</a>
<a href="logout">Logout</a>
</body>
</html>