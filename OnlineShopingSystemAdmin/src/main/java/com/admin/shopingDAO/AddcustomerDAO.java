package com.admin.shopingDAO;
import java.sql.*;
import com.admin.connection.*;
import com.admin.shopingbean.Addcustomerbean;
public class AddcustomerDAO 
{
	int k=0;
	public int insert(Addcustomerbean Customerbean)
	{
		try {
			Connection con=DBconnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into tblcustomer  values(?,?,?,?,?,?)");
			ps.setString(1, Customerbean.getEmail());
			ps.setString(2, Customerbean.getPassword());
			ps.setString(3, Customerbean.getName());
			ps.setString(4, Customerbean.getGender());
			ps.setString(5, Customerbean.getPhone());
			ps.setString(6, Customerbean.getAddress());
			k=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}
}
