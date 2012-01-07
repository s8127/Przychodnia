package com.przychodnia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	private Connection connection;

	
	public DBManager() throws SQLException {
				
			connection = DriverManager.getConnection("jdbc:hsqldb:mem:localhost/przychodnia");							
		
	}
	

	public Connection getConnection() {
		return connection;
	}
		
	

}
