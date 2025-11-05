package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// local Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Make Connection To the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");

		// Create Statement
		Statement stmt = conn.createStatement();

		// Execute Query and get Result
		ResultSet rs = stmt.executeQuery("select * from marksheet");

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.println("\t" + rs.getInt(5));

		}
		conn.close();
	}

}
