package com.admin.DAO;
import java.sql.*;
import javax.servlet.http.*;

import com.admin.bean.Loginbean;
import com.admin.connection.DBconnection;
@SuppressWarnings("serial")
public class LoginDAO extends HttpServlet
{
	public Loginbean Logbean=null;
	public Loginbean login(HttpServletRequest req)
	{
		try
		{
			Connection con=DBconnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from tbladmin  where id=? and password=? ");
			ps.setString(1, req.getParameter("id"));
			ps.setString(2, req.getParameter("password"));
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Logbean=new Loginbean();
				Logbean.setId(rs.getInt(1));
				Logbean.setPassword(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Invalid Cradential");
		}
		return Logbean;
	}
	
}
