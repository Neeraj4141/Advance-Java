package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProduct {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		Statement stmt = conn.createStatement();
		 int i = stmt.executeUpdate("insert into product value(6,'mixer',2000,1);");
		System.out.println("updatesucessfully");

		conn.close();
		stmt.close();

	}
}
