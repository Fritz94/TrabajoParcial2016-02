package com.dev.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	
	private static final String url ="jdbc:mysql://localhost:3306/basedatos";
	private static final String user = "root";
	private static final String password = "root";
	
	private static Connection con;
	
	private Dbconnection(){};
	
	public static Connection getInstance()
	{
		if (con == null)
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
			}
			
			catch (SQLException | ClassNotFoundException e)
			{
				
			}
		}
		return con;
	}


}
