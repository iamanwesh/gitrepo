package com.admin.shopingDAO;
import java.sql.*;
import javax.servlet.http.*;

import com.admin.connection.*;
import com.admin.shopingbean.Addcustomerbean;
@SuppressWarnings("serial")
public class CustomerLoginDAO extends HttpServlet
{
	public Addcustomerbean customerbean=null;
	public Addcustomerbean login(HttpServletRequest req)
	{
		try
		{
			Connection con=DBconnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from tblcustomer  where email=? and password=? ");
			ps.setString(1, req.getParameter("email"));
			ps.setString(2, req.getParameter("password"));
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				customerbean=new Addcustomerbean();
				customerbean.setEmail(rs.getString(1));
				customerbean.setPassword(rs.getString(2));
				customerbean.setName(rs.getString(3));
				customerbean.setGender(rs.getString(4));
				customerbean.setPhone(rs.getString(5));
				customerbean.setAddress(rs.getString(6));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return customerbean;
	}
}
