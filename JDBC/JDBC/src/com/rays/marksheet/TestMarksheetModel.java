package com.rays.marksheet;

import java.sql.SQLException;

public class TestMarksheetModel {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Testadd();
		// Testupdate();
		Testdelete();

	}

	public static void Testadd() throws ClassNotFoundException, SQLException {

		MarksheetBean bean = new MarksheetBean();

		MarkseetModel model = new MarkseetModel();

		bean.setName("Rohan");
		bean.setPhy(87);
		bean.setChy(98);
		bean.setMaths(56);

		model.Add(bean);
	}

	public static void Testupdate() throws ClassNotFoundException, SQLException {

		MarksheetBean bean = new MarksheetBean();

		MarkseetModel model = new MarkseetModel();

		bean.setRollno(123452);
		bean.setName("Dhanush");
		bean.setPhy(54);
		bean.setChy(76);
		bean.setMaths(78);

		model.update(bean);

	}

	public static void Testdelete() throws ClassNotFoundException, SQLException {

		MarksheetBean bean = new MarksheetBean();

		MarkseetModel model = new MarkseetModel();

		bean.setRollno(123458);

		model.delete(bean);
	}

}
