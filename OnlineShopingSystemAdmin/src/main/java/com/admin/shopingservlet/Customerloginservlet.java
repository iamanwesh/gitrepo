package com.admin.shopingservlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.admin.shopingDAO.CustomerLoginDAO;
import com.admin.shopingbean.Addcustomerbean;
@SuppressWarnings("serial")
@WebServlet("/login")
public class Customerloginservlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try {
			Addcustomerbean customerbean = new CustomerLoginDAO().login(req);
			if(customerbean==null)
			{
				req.setAttribute("msg", "Invalid Credential");
				RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
				rd.forward(req, res);
			}
			else
			{
				HttpSession hs = req.getSession();//Creation Session Object
				hs.setAttribute("userbean",customerbean);
				RequestDispatcher rd =req.getRequestDispatcher("index.jsp");
				rd.forward(req, res);
			}
		}catch (ServletException e) {
			System.err.println("invalid credential");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

}
