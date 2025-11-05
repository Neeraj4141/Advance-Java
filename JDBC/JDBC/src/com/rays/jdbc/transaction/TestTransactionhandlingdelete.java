package com.rays.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransactionhandlingdelete {
	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate("delete from employee where id = a");
			i = stmt.executeUpdate("delete from employee where id = 15");
			i = stmt.executeUpdate("delete from employee where id = 16");

			conn.commit();
			System.out.println("data comited succsessfully " + i);
		} catch (Exception e) {
			conn.rollback();
			System.out.println("data roll back successfullu");
			e.printStackTrace();

		}
	}

}
