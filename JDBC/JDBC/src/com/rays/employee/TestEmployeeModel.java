package com.rays.employee;

import java.sql.SQLException;

public class TestEmployeeModel {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Testnextpk();
		// TestAdd();
		Testdelete();

	}

	public static void Testnextpk() throws ClassNotFoundException, SQLException {

		EmployeeModel model = new EmployeeModel();

		int i = model.nextPk();
		System.out.println("next id to be insert = " + i);

	}

	public static void TestAdd() throws ClassNotFoundException, SQLException {

		EmployeeModel model = new EmployeeModel();

		EmployeeBean bean = new EmployeeBean();

		bean.setName("Chetan");
		bean.setCompany("TCS");
		bean.setSalary(78000);
		bean.setDeptId(3);

		model.Add(bean);
	}

	public static void Testdelete() throws ClassNotFoundException, SQLException {
		
		EmployeeBean bean = new EmployeeBean();

		EmployeeModel model = new EmployeeModel();

		bean.setId(16);
		model.Delete(bean);
	}

}
