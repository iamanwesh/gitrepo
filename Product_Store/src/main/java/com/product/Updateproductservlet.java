package com.product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/Update")
public class Updateproductservlet extends HttpServlet {
	
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
		String PCode=req.getParameter("pcode");
		ArrayList<Productbean> al=(ArrayList<Productbean>)hs.getAttribute("al");
		Iterator<Productbean> it=al.iterator();
		while(it.hasNext())
		{
			Productbean pb=(Productbean)it.next();
			if(PCode.equals(pb.getPCode()))
			{
				pb.setPrice(Integer.parseInt(req.getParameter("price")));
				pb.setQuant(Integer.parseInt(req.getParameter("pqnt")));
				int k=new UpdateproductDAO().update(pb);
				if(k>0)
				{
					req.setAttribute("msg", "ProductUpdated Successfully");
				}
				break;
			}
		}
		RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
		rd.forward(req, res);
	}
}

}
