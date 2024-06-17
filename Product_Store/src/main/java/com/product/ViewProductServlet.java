package com.product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/View")
public class ViewProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException
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
			ArrayList<Productbean> al=new ViewProductDAO().retrieve();
			hs.setAttribute("al", al);
			RequestDispatcher rd=req.getRequestDispatcher("Viewallproduct.jsp");
			rd.forward(req, res);
		}
	}
}
