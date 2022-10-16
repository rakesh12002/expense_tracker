package com.expense.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
private static Connection connection =null;
	
	public static Connection getconnection() throws SQLException {
		if(connection!=null) {
			return connection;
		}
		else {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/expense";
			String user="root";
			String password="123456789";
			
			try {
				Class.forName(driver);
				connection=DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		return connection;
	}
}
