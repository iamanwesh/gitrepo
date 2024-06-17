package com.product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class Editproduct extends HttpServlet {
		
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
			String PCode=req.getParameter("PCode");
			ArrayList<Productbean> al=(ArrayList<Productbean>)hs.getAttribute("al");
			Iterator<Productbean> it=al.iterator();
			while(it.hasNext())
			{
				Productbean pb=(Productbean)it.next();
				if(PCode.equals(pb.getPCode()))
				{
					req.setAttribute("pb", pb);
					break;
				}
			}
			req.getRequestDispatcher("editproduct.jsp").forward(req, res);
		}
	}
}
