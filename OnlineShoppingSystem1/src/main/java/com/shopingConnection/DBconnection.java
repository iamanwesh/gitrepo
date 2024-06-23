package com.shopingConnection;
import java.sql.*;
import static com.shopingConnection.DBinfo.*;
public class DBconnection
{
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
