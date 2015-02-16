package org.employee.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection
{

	public static final String DB_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	public static final String DB_URL = "jdbc:jtds:sqlserver://192.168.10.100:1433/rath_6_feb_124";
	public static final String DB_NAME = "rath_6_feb_124";
	public static final String DB_PASSWORD = "rath_6_feb_124";
	Connection conn;

	public Connection dbConnection()
	{

		try
		{
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
			
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}
}
