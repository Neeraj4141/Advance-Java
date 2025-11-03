package com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class MarkseetModel {

	public int nextPk() throws ClassNotFoundException, SQLException {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(rollno) from marksheet");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("maximum id = "+ pk);

		}
		conn.close();
		return pk + 1;
	}

	public void Add(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?)");
		int pk = nextPk();

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChy());
		pstmt.setInt(5, bean.getMaths());

		int i = pstmt.executeUpdate();
		System.out.println("Record update successfully" + i);
		conn.close();

	}

	public void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn
				.prepareStatement("update marksheet set name = ?,phy = ?,chy = ?,maths = ? where rollno = ?");

		pstmt.setString(1, bean.getName());
		pstmt.setInt(2, bean.getPhy());
		pstmt.setInt(3, bean.getChy());
		pstmt.setInt(4, bean.getMaths());
		pstmt.setInt(5, bean.getRollno());

		int i = pstmt.executeUpdate();
		System.out.println("Record update successfully " + i);
		conn.close();

	}

	public void delete(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where rollno = ?");

		pstmt.setInt(1, bean.getRollno());
		int i = pstmt.executeUpdate();

		System.out.println("Rocord delete successfully " + i);
		conn.close();

	}
	

}
