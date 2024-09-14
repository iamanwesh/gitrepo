<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.admin.bean.Addproductbean, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
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
String ms1=(String)request.getAttribute("message");
if(ms1==null)
{
	out.println(" ");
}
else
{
	out.println(ms1);
	
}

%>
<%
ArrayList<Addproductbean> al=(ArrayList<Addproductbean>)session.getAttribute("haset");
if(al.size()==0)
{
	out.println("Product not Available");
}
else
{

	Iterator<Addproductbean> it=al.iterator();
	while(it.hasNext())
	{
		Addproductbean pb=it.next();
	%>
	<div align="center"> 
	
	<table border="1px solid black" Style="width:750px;height:150px">
		<tr>
			<th>Code</th>
			<th>Image</th>
			<th>Name</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Categories</th>
			<th>Operation</th>
		</tr>
		<tr align="center">
			<td ><%=pb.getCode() %></td>
			<td ><img src="Images/<%=pb.getImage()%>" width="75" height="90" /></td>
			<td><%=pb.getName() %></td>
			<td><%=pb.getPrice() %></td>
			<td><%=pb.getStock() %></td>
			<td><%=pb.getProduct_catagory() %></td>
			<td>
			<a href="edit?code=<%=pb.getCode() %>">Edit</a>
			<a href="delete?code=<%=pb.getCode() %>">Delete</a>
			</td>
		</tr>
	</table>
	</div>
	<%
	}
}
%>
<p align="center"><a href="Addproduct.jsp">Add More Product...</a></p>
<button type="button" align="center"><a href="logout">Logout</a> </button>
</body>
</html>