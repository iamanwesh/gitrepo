package com.admin.servlet;
import java.io.*;
import java.util.*;

import com.admin.DAO.DeleteproductDAO;
import com.admin.bean.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class Deleteproduct extends HttpServlet  
{
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
			ArrayList<Addproductbean> al=(ArrayList<Addproductbean>)hs.getAttribute("haset");
			String Code=req.getParameter("code");
			Iterator<Addproductbean> it=al.iterator();
			while(it.hasNext())
			{
				Addproductbean pb=(Addproductbean)it.next();
				if(Code.equals(pb.getCode()))
				{
					it.remove();
					break;
				}
			}
			int k=new DeleteproductDAO().Delete(Code);
			if(k>0)
			{
				req.setAttribute("message", "product deleted successfully");
				
			}
			RequestDispatcher rd=req.getRequestDispatcher("Viewallproduct.jsp");
			rd.forward(req, res);
		}
	}
}
