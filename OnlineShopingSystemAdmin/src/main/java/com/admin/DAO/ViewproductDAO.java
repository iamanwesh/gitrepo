package com.admin.DAO;

import java.sql.*;
import java.util.*;
import javax.servlet.annotation.MultipartConfig;

import com.admin.bean.Addproductbean;
import com.admin.connection.DBconnection;
@MultipartConfig(maxFileSize= 10000)
public class ViewproductDAO {
ArrayList<Addproductbean> haset=new ArrayList<Addproductbean>();
public  ArrayList<Addproductbean> retrieve()
{
	try {
		Connection con=DBconnection.getCon();
		PreparedStatement ps=con.prepareStatement("select * from tblproduct ");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Addproductbean productbeanb=new Addproductbean();
			productbeanb.setCode(rs.getString(1));
			productbeanb.setImage(rs.getString(2));
			productbeanb.setName(rs.getString(3));
			productbeanb.setPrice(rs.getInt(4));
			productbeanb.setStock(rs.getInt(5));
			productbeanb.setProduct_catagory(rs.getString(6));
			haset.add(productbeanb);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return haset;
}
}