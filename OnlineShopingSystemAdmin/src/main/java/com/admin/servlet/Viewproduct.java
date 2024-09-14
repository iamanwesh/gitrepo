package com.admin.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.admin.DAO.ViewproductDAO;
import com.admin.bean.Addproductbean;

import javax.servlet.annotation.*;

@WebServlet("/View")

public class Viewproduct extends HttpServlet{
	   private static final long serialVersionUID = 1L;
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
			ArrayList<Addproductbean> haset=new ViewproductDAO().retrieve();
			hs.setAttribute("haset", haset);
			RequestDispatcher rd=req.getRequestDispatcher("Viewallproduct.jsp");
			rd.forward(req, res);
		}
	
}
}


