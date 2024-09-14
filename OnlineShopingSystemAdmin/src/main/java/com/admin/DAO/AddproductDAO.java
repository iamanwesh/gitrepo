package com.admin.DAO;
import java.sql.Connection;

import java.sql.PreparedStatement;
import com.admin.bean.Addproductbean;
import com.admin.connection.DBconnection;

public class AddproductDAO  {
int k=0;
public int insert(Addproductbean productbean)
{
	try {
		Connection con=DBconnection.getCon();
		PreparedStatement ps=con.prepareStatement("insert into tblproduct values(?,?,?,?,?,?)");
		ps.setString(1, productbean.getCode());
		ps.setString(2, productbean.getImage());
		ps.setString(3, productbean.getName());
		ps.setInt(4, productbean.getPrice());
		ps.setInt(5, productbean.getStock());
		ps.setString(6, productbean.getProduct_catagory());
		k=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return k;
}
}
