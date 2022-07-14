package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/employee";
		String username = "postgres";
		String password = "hggi";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			System.out.println(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}