package com.admin.shopingservlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import com.admin.shopingbean.*;
import com.admin.shopingDAO.*;
@SuppressWarnings("serial")
@WebServlet("/register")
public class Addcustomerservlet extends HttpServlet{
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
			Addcustomerbean Customerbean=new Addcustomerbean();
			Customerbean.setEmail(req.getParameter("email"));
			Customerbean.setPassword(req.getParameter("password"));
			Customerbean.setName(req.getParameter("name"));
			Customerbean.setGender(req.getParameter("gender"));
			Customerbean.setPhone(req.getParameter("phone"));
			Customerbean.setAddress(req.getParameter("address"));
			int k=new AddcustomerDAO().insert(Customerbean);
			if(k>0)
			{
				req.setAttribute("msg", "Customer Detail Added Successfully");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
			}
		}
	}

}
