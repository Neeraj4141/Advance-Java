package com.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionHandling {
	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into employee values(16,'ravi','bse', 45000, 3)");
			i = stmt.executeUpdate("insert into employee values(17,'arjun','m/m', 50000, 1)");

			conn.commit();
			System.out.println("transaction is commit");

		} catch (Exception e) {
			System.out.println("transation is rollback");
			conn.rollback();

		}
	}

}
