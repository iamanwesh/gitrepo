package com.admin.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.admin.DAO.LoginDAO;
import com.admin.bean.Loginbean;

import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/adminlogin")
public class Login extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try {
			Loginbean Logbean=new LoginDAO().login(req);
			if(Logbean==null)
			{
				req.setAttribute("msg", "Invalid Credential");
				RequestDispatcher rd=req.getRequestDispatcher("Adminlogin.html");
				rd.forward(req, res);
			}
			else
			{
				HttpSession hs = req.getSession();//Creation Session Object
				hs.setAttribute("Lbean",Logbean);
				RequestDispatcher rd =req.getRequestDispatcher("Addproduct.jsp");
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
