package com.admin.DAO;

import java.sql.*;

import com.admin.bean.Addproductbean;
import com.admin.connection.*;

public class UpdateproductDAO
{
	int k=0;
	public int update(Addproductbean productbean)
	{
		try
		{
			Connection con=DBconnection.getCon();
			PreparedStatement ps=con.prepareStatement("Update productDetail set price=? ,  Stock=? where code=?");
			ps.setInt(1, productbean.getPrice());
			ps.setInt(2, productbean.getStock());
			ps.setString(3, productbean.getCode());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
