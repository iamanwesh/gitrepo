package com.shopingservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.admin.bean.Addproductbean;
import com.shopingDAO.ViewallproductDAO;
@SuppressWarnings("serial")
@WebServlet("/viewall")
public class Viewallproductservlet extends HttpServlet
{
		protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException
		{
			HttpSession hs1=req.getSession(false);
			if(hs1==null)
			{
				req.setAttribute("msg", "Session Expired");
				RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
				rd.forward(req, res);
			}
			else
			{
				ArrayList<Addproductbean> haset1=new ViewallproductDAO().retrieveone();
				hs1.setAttribute("haset", haset1);
				RequestDispatcher rd=req.getRequestDispatcher("viewallproductjsp.jsp");
				rd.forward(req, res);
			}
		}
}
