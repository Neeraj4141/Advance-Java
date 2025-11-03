package com.rays.jdbc.preparedStatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

		// TestAdd();
		// TestDelete();
		// TestUpdate();
		// TestFindByLogin();
		// TestFindByLoginPassword();
		// TestchangePassword();
		// Testsearch();
		Testsearchfilter();
		// TestNextpk();

	}

	public static void TestNextpk() throws ClassNotFoundException, SQLException {

		UserModal model = new UserModal();

		int i = model.nextPK();

		System.out.println("next id to be insert " + i);

	}

	public static void TestAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModal model = new UserModal();

		UserBean bean = new UserBean();

		bean.setFristname("Harshit");
		bean.setLastname("Shankhla");
		bean.setLoginid("harshit@gmail.com");
		bean.setPassword("harshit@123");
		bean.setDob(sdf.parse("2000-05-04"));

		model.add(bean);

	}

	public static void TestDelete() throws Exception {

		UserModal model = new UserModal();

		UserBean bean = new UserBean();

		bean.setId(4);
		model.delete(bean);
	}

	public static void TestUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();

		UserModal model = new UserModal();

		bean.setId(2);
		bean.setFristname("Rahul");
		bean.setLastname("Mewada");
		bean.setLoginid("rahul123@gmail.com");
		bean.setPassword("rahul@123");
		bean.setDob(sdf.parse("1999-03-07"));

		model.update(bean);
	}

	public static void TestFindByLogin() throws ClassNotFoundException, SQLException {

		UserModal model = new UserModal();
		UserBean existsbean = model.findbylogin("neejraj@gamail.com");

		if (existsbean != null) {
			System.out.println("login id is already exists");
			System.out.println(existsbean.getId());
			System.out.println(existsbean.getFristname());
			System.out.println(existsbean.getLastname());
			System.out.println(existsbean.getLoginid());
			System.out.println(existsbean.getPassword());
			System.out.println(existsbean.getDob());
		} else {
			System.out.println("no Record found");
		}

	}

	public static void TestFindByLoginPassword() throws ClassNotFoundException, SQLException {

		UserModal model = new UserModal();

		UserBean existsbean = model.findbyloginpassword("rahul13@gmail.com", "rahul@123");

		if (existsbean != null) {
			System.out.println("login sucessfully");
		} else {
			System.out.println("no Record found");
		}

	}

	public static void TestchangePassword() throws Exception {

		UserModal model = new UserModal();

		model.changePassword("rahul@111", "rahul@222", "rahul123@gmail.com");

	}

	public static void Testsearch() throws ClassNotFoundException, SQLException {

		UserModal model = new UserModal();
		List list = model.search(null);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			UserBean bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFristname());
			System.out.print("\t" + bean.getLastname());
			System.out.print("\t" + bean.getLoginid());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());

		}
	}

	public static void Testsearchfilter() throws ClassNotFoundException, SQLException {

		UserModal model = new UserModal();

		UserBean bean = new UserBean();

		// bean.setFristname("n");
		bean.setLastname("m");
		// bean.setLoginid("n");
		// bean.setPassword("rahul@222");

		List list = model.searchfilter(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFristname());
			System.out.print("\t" + bean.getLastname());
			System.out.print("\t" + bean.getLoginid());
			System.out.print("\t" + bean.getPassword());
			System.out.println("\t" + bean.getDob());

		}

	}

}
