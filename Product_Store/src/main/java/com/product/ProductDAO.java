package com.product;
import java.sql.*;
public class ProductDAO {
int k=0;
public int insert(Productbean pb)
{
	try {
		Connection con=DBconnection.getCon();
		PreparedStatement ps=con.prepareStatement("insert into productDetail values(?,?,?,?)");
		ps.setString(1, pb.getPCode());
		ps.setString(2, pb.getPname());
		ps.setInt(3, pb.getPrice());
		ps.setInt(4, pb.getQuant());
		k=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return k;
}
}
