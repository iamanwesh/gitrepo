<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.product.*,java.util.*"
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
ArrayList<Productbean> al=(ArrayList<Productbean>)session.getAttribute("al");
out.println("Welcome  Mr. :"+ab.getFname()+"<br>");
if(al.size()==0)
{
	out.println("Product not Available");
}
else
{
	Iterator<Productbean> it=al.iterator();
	while(it.hasNext())
	{
		Productbean pb=(Productbean)it.next();
		out.println(pb.getPCode()+"&nbsp"+pb.getPname()+"&nbsp"+pb.getPrice()+"&nbsp"+pb.getQuant()+
				"<a href='edit?PCode="+pb.getPCode()+"'>Edit</a>"+
		"&nbsp"+"<a href='delete?PCode="+pb.getPCode()+"'>Delete</a>"+"<br>");
	}
}
%>
</body>
</html>