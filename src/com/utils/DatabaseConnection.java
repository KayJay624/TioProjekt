package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DatabaseConnection {
    private final String psqlServerName ="jdbc:postgresql://localhost:5432/contactdb";
	private final String psqlUserName = "postgres";
	private final String psqlUserPassword = "postgres";
    	
    private Connection c = null;
   
    private static class DatabaseConnectionLoader {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    private DatabaseConnection() {
        if (DatabaseConnectionLoader.INSTANCE != null) {
            throw new IllegalStateException("DatabaseConnection object already instantiated!");
        } else {
        	             	
        	try {
				Class.forName("org.postgresql.Driver");			
				c = DriverManager.getConnection(psqlServerName, psqlUserName, psqlUserPassword);
				c.setAutoCommit(false);
        	} catch (Exception e) {				
				e.printStackTrace();
			}
        	System.out.println("Connected to PSQL successfully");            
        }
    }

       
    public Connection getPsqlConnection() {    	
    	return c;
    }
    
    public static DatabaseConnection getInstance() {
        return DatabaseConnectionLoader.INSTANCE;
    }
}
