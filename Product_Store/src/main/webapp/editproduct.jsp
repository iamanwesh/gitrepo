<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.product.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
Productbean pb=(Productbean)request.getAttribute("pb");
out.println("Welcome  Mr. :"+ab.getFname()+"<br>");
%>
<form action="Update" method="post">
<input type="hidden" value=<%=pb.getPCode()%> name="pcode" >
Product Price :<input type="text" value=<%=pb.getPrice()%> name="price" >
Product Quantity :<input type="text" value=<%=pb.getQuant()%> name="pqnt" >

<input type="submit" value="Update">
</form>
</body>
</html>