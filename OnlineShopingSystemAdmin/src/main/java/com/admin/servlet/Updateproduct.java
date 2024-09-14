package com.admin.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.admin.DAO.UpdateproductDAO;
import com.admin.bean.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class Updateproduct extends HttpServlet {
	
@SuppressWarnings("unchecked")
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException ,IOException
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
				pb.setPrice(Integer.parseInt(req.getParameter("price")));
				pb.setStock(Integer.parseInt(req.getParameter("stock")));
				int k=new UpdateproductDAO().update(pb);
				if(k>0)
				{
					req.setAttribute("msg", "ProductUpdated Successfully");
				}
				break;
			}
		}
		RequestDispatcher rd=req.getRequestDispatcher("Viewallproduct.jsp");
		rd.forward(req, res);
	}

}
}