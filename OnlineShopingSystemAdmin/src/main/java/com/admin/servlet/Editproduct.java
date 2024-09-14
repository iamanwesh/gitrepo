package com.admin.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.admin.bean.*;
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
		String Code=req.getParameter("code");
		ArrayList<Addproductbean> al=(ArrayList<Addproductbean>)hs.getAttribute("haset");
		Iterator<Addproductbean> it=al.iterator();
		while(it.hasNext())
		{
			Addproductbean pb=(Addproductbean)it.next();
			if(Code.equals(pb.getCode()))
			{
				req.setAttribute("pb", pb);
				break;
			}
		}
		req.getRequestDispatcher("editproduct.jsp").forward(req, res);
	}
}
}
