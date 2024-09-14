package com.admin.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class Logout extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session expired");
			
		}
		else
		{
			hs.removeAttribute("Lbean");
			hs.removeAttribute("hset");
			hs.invalidate();
			req.setAttribute("msg", "Loggedout Successfully");
		}
		RequestDispatcher rd=req.getRequestDispatcher("Adminlogin.html");
		rd.forward(req, res);
	}
}