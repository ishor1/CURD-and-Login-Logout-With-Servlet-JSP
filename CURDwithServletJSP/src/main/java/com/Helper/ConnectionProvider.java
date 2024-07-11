package com.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con=null;
	public static Connection getConnection() {
		try {
			if(con==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}





}

