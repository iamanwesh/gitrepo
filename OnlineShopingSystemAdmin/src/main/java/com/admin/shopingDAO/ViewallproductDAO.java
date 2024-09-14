package com.admin.shopingDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import  com.admin.bean.Addproductbean;
import com.admin.connection.*;

public class ViewallproductDAO 
{
	ArrayList<Addproductbean> haset1=new ArrayList<Addproductbean>();
	public  ArrayList<Addproductbean> retrieveone()
	{
		try {
			Connection con=DBconnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from tblproduct");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Addproductbean productbean=new Addproductbean();
				productbean.setCode(rs.getString(1));
				productbean.setImage(rs.getString(2));
				productbean.setName(rs.getString(3));
				productbean.setPrice(rs.getInt(4));
				productbean.setStock(rs.getInt(5));
				productbean.setProduct_catagory(rs.getString(6));
				haset1.add(productbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return haset1;
	}
}
