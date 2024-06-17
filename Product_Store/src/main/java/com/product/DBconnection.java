package com.product;
import static com.product.DBinfo.*;
import java.sql.*;
public class DBconnection {
	private static Connection con;
	private  DBconnection() {}
	static
	{
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl,uname,pword);
			
		}catch(Exception e) {e.printStackTrace();}
	}
	public static Connection getCon()
	{
		return con;
	}
}
