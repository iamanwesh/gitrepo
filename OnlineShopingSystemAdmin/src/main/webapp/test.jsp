<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String ms=(String)request.getAttribute("msg");
if(ms==null)
{
	out.println(" ");
}
else
{
	out.println(ms);
	
}
%>
</body>
</html>