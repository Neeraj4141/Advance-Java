package com.rays.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rays.jdbc.preparedStatement.UserBean;

public class EmployeeModel {

	public int nextPk() throws ClassNotFoundException, SQLException {
		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from employee");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("maximum id = " + pk);

		}
		return pk + 1;

	}

	public void Add(EmployeeBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
		int pk = nextPk();

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getCompany());
		pstmt.setInt(4, bean.getSalary());
		pstmt.setInt(5, bean.getDeptId());

		int i = pstmt.executeUpdate();
		System.out.println("update successfully = " + i);
		conn.close();

	}
	public void Delete(EmployeeBean bean) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1","root","root");
		PreparedStatement pstmt = conn.prepareStatement("delete from Employee where id = ?");
		
		pstmt.setInt(1, bean.getId());
		
		int i = pstmt.executeUpdate();
		System.out.println("data deleted successfully = "+ i);
		conn.close();
	}

}
