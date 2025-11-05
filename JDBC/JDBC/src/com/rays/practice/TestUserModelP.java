package com.rays.practice;

import java.sql.SQLException;

public class TestUserModelP {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Testadd();
		// TestDelete();
		//TestUpdate();

	}

	public static void Testadd() throws ClassNotFoundException, SQLException {

		UserModelP model = new UserModelP();

		UserBeanP bean = new UserBeanP();

		
		bean.setName("Ac");
		bean.setPrice(30000);
		bean.setQuntity(2);

		model.Add(bean);

	}

	public static void TestDelete() throws ClassNotFoundException, SQLException {

		UserBeanP bean = new UserBeanP();

		UserModelP model = new UserModelP();

		bean.setId(6);
		model.delete(bean);

	}

	public static void TestUpdate() throws ClassNotFoundException, SQLException {

		UserBeanP bean = new UserBeanP();
		UserModelP model = new UserModelP();

		bean.setId(6);
		bean.setName("laptoop");
		bean.setPrice(4000);
		bean.setQuntity(5);

		model.update(bean);
	}

}
