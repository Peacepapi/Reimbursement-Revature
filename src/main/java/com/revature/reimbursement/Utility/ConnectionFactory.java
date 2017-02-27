package com.revature.reimbursement.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String url = "jdbc:oracle:thin:@hello.cgbbs6xdwjwh.us-west-2.rds.amazonaws.com:1521:orcl";
	private static final String user = "pierce";
	private static final String password = "marvin";

	public static Connection getConnection() throws Exception {
		// Load the Driver
		Class.forName("oracle.jdbc.OracleDriver"); // Reflection API
		// open a connection
		return DriverManager.getConnection(url, user, password);
	}
}