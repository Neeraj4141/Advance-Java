package com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModal {

	// --------------------generate next primary key-------------------

	public int nextPK() throws ClassNotFoundException, SQLException {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select max(id)from st_user");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("maximum id = " + pk);

		}
		conn.close();
		return pk + 1;

	}

	// ---------------------insert Record----------------------------
	public void add(UserBean bean) throws Exception {

		UserBean existsBean = findbylogin(bean.getLoginid());

		if (existsBean != null) {
			throw new Exception("login id already exist");
		}

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");
		int pk = nextPK();

		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFristname());
		pstmt.setString(3, bean.getLastname());
		pstmt.setString(4, bean.getLoginid());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();
		System.out.println("update sucessfully" + i);
		conn.close();

	}

	// ---------------------delete Record---------------------

	public void delete(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Recorde deleted successfully" + i);
		conn.close();

	}

	// ------------------------update Record---------------------------

	public void update(UserBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set fristname = ?, lastname = ?, loginid = ?, password = ?, dob = ? where id = ?");

		pstmt.setString(1, bean.getFristname());
		pstmt.setString(2, bean.getLastname());
		pstmt.setString(3, bean.getLoginid());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Recorde update successfully" + i);
		conn.close();

	}

	// ------------------record find by login id -------------------------

	public UserBean findbylogin(String login) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root"); 
		PreparedStatement pstmt = conn.prepareStatement("select* from st_user where loginid = ?");
		pstmt.setString(1, login);
		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFristname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}
		return bean;

	}

	// ------------------------ Authenticate ------------------

	public UserBean findbyloginpassword(String login, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select*from st_user where loginid = ? and password = ?");
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setId(rs.getInt(1));
			bean.setFristname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));

		}
		return bean;

	}

	// -----------------------change password--------------------------

	public void changePassword(String oldPassword, String newPassword, String login) throws Exception {

		UserBean existBean = findbylogin(login);

		System.out.println("database password: " + existBean.getPassword());
		System.out.println("oldPassword: " + oldPassword);

		if (existBean.getPassword().equals(oldPassword)) {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			PreparedStatement pstmt = conn.prepareStatement("update st_user set password = ? where loginid = ?");

			pstmt.setString(1, newPassword);

			pstmt.setString(2, login);

			int i = pstmt.executeUpdate();
			System.out.println("password has been changed: " + i);
			conn.close();
		} else {
			throw new Exception("old password is incorrect");
		}

	}

	public List search(UserBean bean) throws ClassNotFoundException, SQLException {

		List list = new ArrayList();

		StringBuffer sql = new StringBuffer("select * from st_user");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");

		System.out.println("sql --------->" + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFristname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);

		}
		return list;

	}

	public List searchfilter(UserBean bean) throws SQLException, ClassNotFoundException {

		List list = new ArrayList();

		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");

		if (bean != null) {
			if (bean.getFristname() != null && bean.getFristname().length() > 0) {

				sql.append(" and fristname like '" + bean.getFristname() + "%'");
			}

			if (bean.getLastname() != null && bean.getLastname().length() > 0) {

				sql.append(" and lastname like '" + bean.getLastname() + "%'");
			}
			if (bean.getLoginid() != null && bean.getLoginid().length() > 0) {

				sql.append(" and loginid like '" + bean.getLoginid() + "%'");
			}
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" and password like '" + bean.getPassword() + "%'");

			}

		}

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");

		System.out.println("sql --------->" + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFristname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);

		}

		return list;

	}

}
