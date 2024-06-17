package com.product;
import java.sql.*;
import java.util.ArrayList;
public class ViewProductDAO {
ArrayList<Productbean> al=new ArrayList<Productbean>();
public  ArrayList<Productbean> retrieve()
{
	try {
		Connection con=DBconnection.getCon();
		PreparedStatement ps=con.prepareStatement("select * from ProductDetail");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Productbean pb=new Productbean();
			pb.setPCode(rs.getString(1));
			pb.setPname(rs.getString(2));
			pb.setPrice(rs.getInt(3));
			pb.setQuant(rs.getInt(4));
			al.add(pb);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return al;
}
}
