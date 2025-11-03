package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// local Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Make Connection To the Database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");

		// Create Statement
		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into employee values(5,'harshit','samsung',45000,2)");

		System.out.println("data update successfully" + i);

		conn.close();
	}

}
