package com.aptiwithabapi.utility;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DatabaseConnection {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		
		OracleDataSource dataSource = null;
		
		try {
			
			dataSource = new OracleDataSource();
			dataSource.setDriverType("thin");
			dataSource.setServerName("localhost");
			dataSource.setPortNumber(1521);
			dataSource.setDatabaseName("xe");
			dataSource.setUser("Ashish");
			dataSource.setPassword("Ashish");
			
			connection = dataSource.getConnection();
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			
		}
		
		return connection;
		
	}

	private DatabaseConnection() {
		// TODO Auto-generated constructor stub
	}
}
