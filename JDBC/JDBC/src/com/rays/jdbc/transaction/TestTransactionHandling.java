package com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionHandling {
	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("insert into employee values(14,'mohit','m$m',42000,2)");
			i = stmt.executeUpdate("insert into employee values(15,'rajveer','microsoft',56000,3)");
			i = stmt.executeUpdate("insert into employee values(16,'raajvardhan','tencent',60000,2)");

			conn.commit();
			System.out.println("transaction is commited " + i);

		} catch (Exception e) {
			System.out.println("transaction is rolledback");
			conn.rollback();
		}
	}

}
