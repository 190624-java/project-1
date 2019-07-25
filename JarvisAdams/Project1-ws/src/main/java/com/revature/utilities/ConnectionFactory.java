package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String hostname = "project-1.cvriicvj5pb8.us-east-2.rds.amazonaws.com"; //a.k.a. endpoint
	private static final String port = "1521";
	private static String dbName = "ORCL";
	
	private static String url_ds = "jdbc:oracle:thin:@"
			+hostname
			+":"+port
			+":"+dbName;		
	
	private static final String admin_username = "P1Admin";
	private static final String admin_password = "Project111";

	public ConnectionFactory(){
		
	}
	
	public static Connection getConnection() throws SQLException {
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		//-----------
		//Test for getting Connection without potentially destroying the connection on exit of this function.
//		Connection c;
		try {
			return DriverManager.getConnection(url_ds, admin_username, admin_password);
		}catch(SQLException e) {
			System.out.println("Couldn't establish connection!");
			throw e;
		}
	}
}
