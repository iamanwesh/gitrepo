<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.admin.bean.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Loginbean Logbean=(Loginbean)session.getAttribute("Lbean");
Addproductbean pb=(Addproductbean)request.getAttribute("pb");
out.println("Welcome  Mr. :"+Logbean.getId()+"<br>");
%>
<form action="update" method="post">
<input type="hidden" value=<%=pb.getCode()%> name="code" >
Product Price :<input type="text" value=<%=pb.getPrice()%> name="price" >
Product Stock :<input type="text" value=<%=pb.getStock()%> name="stock" >
<input type="submit" value="Update">
<a href="Viewallproduct.jsp">Viewallproduct</a>
</form>
</body>
</html>