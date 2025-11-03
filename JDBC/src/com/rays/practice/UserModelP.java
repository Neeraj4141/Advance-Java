package com.rays.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.jdbc.Driver;

public class UserModelP {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public int nextPk() throws ClassNotFoundException, SQLException {

		int pk = 0;

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("select max(id)from product");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void Add(UserBeanP bean) throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into product values(?,?,?,?)");
		int pk = nextPk();

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPrice());
		pstmt.setInt(4, bean.getQuntity());

		int i = pstmt.executeUpdate();
		System.out.println("update successfully " + i);
		conn.close();

	}

	public void delete(UserBeanP bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from product where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("record delete successfully " + i);
		conn.close();

	}

	public void update(UserBeanP bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn
				.prepareStatement("update product set name = ?, price = ?, quntity =? where id = ?");

		pstmt.setString(1, bean.getName());
		pstmt.setInt(2, bean.getPrice());
		pstmt.setInt(3, bean.getQuntity());
		pstmt.setInt(4, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("rocord update successfully" + i);
		conn.close();

	}
}
