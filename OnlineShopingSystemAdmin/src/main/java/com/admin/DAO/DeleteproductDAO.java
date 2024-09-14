package com.admin.DAO;

import java.sql.*;

import com.admin.connection.DBconnection;

public class DeleteproductDAO {
public int k=0;
public int Delete (String Code)
{
	try {
		Connection con=DBconnection.getCon();
		PreparedStatement ps=con.prepareStatement("delete from tblproduct where code=?");
		ps.setString(1, Code);
	    k=ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return k;
}
}
