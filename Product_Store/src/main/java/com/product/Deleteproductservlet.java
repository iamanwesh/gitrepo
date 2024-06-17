package com.product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class Deleteproductservlet extends HttpServlet {
	
@SuppressWarnings("unchecked")
@Override
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
		
		ArrayList<Productbean> al=(ArrayList<Productbean>)hs.getAttribute("al");
		String PCode=req.getParameter("PCode");
		Iterator<Productbean> it=al.iterator();
		while(it.hasNext())
		{
			Productbean pb=(Productbean)it.next();
			if(PCode.equals(pb.getPCode()))
			{
				it.remove();
				break;
			}
		}
		int k=new DeleteproductDAO().delete(PCode);
		if(k>0)
		{
			req.setAttribute("msg", "product deleted successfully");
			
		}
		RequestDispatcher rd=req.getRequestDispatcher("Delete.jsp");
		rd.forward(req, res);
	}
}
}