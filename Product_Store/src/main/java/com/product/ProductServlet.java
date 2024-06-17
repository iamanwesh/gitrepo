package com.product;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/Addproduct")
public class ProductServlet extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	HttpSession hs=req.getSession(false);
	if(hs==null)
	{
		req.setAttribute("msg", "Session Expired");
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.forward(req, res);
	}
	else
	{
		Productbean pb=new Productbean();
		pb.setPCode(req.getParameter("pcode"));
		pb.setPname(req.getParameter("pname"));
		pb.setPrice(Integer.parseInt(req.getParameter("price")));
		pb.setQuant(Integer.parseInt(req.getParameter("qnt")));
		int k=new ProductDAO().insert(pb);
		if(k>0)
		{
			req.setAttribute("msg", "Product Detail Added Successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Addproduct.jsp");
			rd.forward(req, res);
		}
	}
}
}
