package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				"jdbc:postgresql://java-angular-82322.ckbrrrsbxjfy.us-east-1.rds.amazonaws.com:5432/postgres",
				"postgres", 
				"password123");
				}

}
