package com.product;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class AdminLoginservlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try {
			AdminBean ab=new AdminLoginDAO().login(req);
			if(ab==null)
			{
				req.setAttribute("msg", "Invalid Credential");
				RequestDispatcher rd=req.getRequestDispatcher("Home.html");
				rd.forward(req, res);
			}
			else
			{
				HttpSession hs = req.getSession();//Creation Session Object
				hs.setAttribute("abean",ab);
				RequestDispatcher rd =req.getRequestDispatcher("LogSuccess.jsp");
				rd.forward(req, res);
			}
		} catch (ServletException e) {
			System.err.println("invalid credential");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
