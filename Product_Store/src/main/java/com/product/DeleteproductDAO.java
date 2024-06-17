package com.product;
import java.sql.*;
public class DeleteproductDAO {
public int k=0;
public int delete(String pCode)
{
	try
	{
		Connection con=DBconnection.getCon();
		PreparedStatement ps=con.prepareStatement("delete from productDetail where product_code=?");
		ps.setString(1, pCode);
		k=ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
}
}
