package com.product;
import java.sql.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class AdminLoginDAO extends HttpServlet
{
public AdminBean ab=null;
public AdminBean login(HttpServletRequest req)
{
	try
	{
		Connection con=DBconnection.getCon();
		PreparedStatement ps=con.prepareStatement("select * from AdminTab54 where uname=? and pword=? ");
		ps.setString(1, req.getParameter("uname"));
		ps.setString(2, req.getParameter("pword"));
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			ab=new AdminBean();
			ab.setUname(rs.getString(1));
			ab.setPword(rs.getString(2));
			ab.setFname(rs.getString(3));
			ab.setLname(rs.getString(4));
			ab.setAddr(rs.getString(5));
			ab.setMail(rs.getString(6));
			ab.setPhno(rs.getLong(7));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return ab;
}
}
