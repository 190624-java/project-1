package com.revature.project1.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String url = "jdbc:oracle:thin:"
			+ "@sinhky01-project1.czbmyzgcpgqi.us-east-2.rds.amazonaws.com"
			+ ":1521:ORCL";
	// jdbc:oracle:thin:@hostname:1521:sid
	private static final String username = "sinhart190624";
	private static final String password = "N7u3nyauZ4MS7ZP";
	
	public static Connection getConnection() throws SQLException {
		//THIS WILL BE ON THE TEST AND IN CLIENT INTERVIEWS
		try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return DriverManager.getConnection(url, username, password);
	}
}
