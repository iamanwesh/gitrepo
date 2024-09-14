<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="com.admin.bean.Addproductbean, java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
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
 <div class="col-lg-4 col-md-6 col-sm-12 pb-1">
                        <div class="card product-item border-0 mb-4">
                            <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                                <img class="img-fluid w-100" src=<%=pb.getImage()%> alt="">
                            </div>
                            <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                                <h6 class="text-truncate mb-3"><%=pb.getName() %></h6>
                                <div class="d-flex justify-content-center">
                                    <h6><%=pb.getPrice() %></h6><h6 class="text-muted ml-2"><del><%=pb.getPrice() %></del></h6>
                                </div>
                            </div>
                            <div class="card-footer d-flex justify-content-between bg-light border">
                                <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                                <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                            </div>
                        </div>
                    </div>
                    	<%
	}
}
%>
                   
</body>
</html>