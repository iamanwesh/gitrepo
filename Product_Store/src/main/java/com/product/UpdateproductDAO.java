package com.product;

import java.sql.*;

public class UpdateproductDAO{
	int k=0;
	public int update(Productbean pb)
	{
		try
		{
			Connection con=DBconnection.getCon();
			PreparedStatement ps=con.prepareStatement("Update productDetail set product_price=? , product_quantity=? where product_code=?");
			ps.setInt(1, pb.getPrice());
			ps.setInt(2, pb.getQuant());
			ps.setString(3, pb.getPCode());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
