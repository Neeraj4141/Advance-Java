package com.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestAap {
	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

		System.out.println(rb.getString("driver"));
		System.out.println(rb.getString("url"));
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));

		ResourceBundle rb1 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("hi"));

		System.out.println(rb1.getString("greeting"));

		ResourceBundle rb2 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("bh"));

		System.out.println(rb2.getString("bh"));

		ResourceBundle rb3 = ResourceBundle.getBundle("com.rays.bundle.aap", new Locale("msg"));

		System.out.println(rb3.getString("msg"));
		
		ResourceBundle rb4 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("subh"));
		
		System.out.println(rb4.getString("shubhakamnaye"));

	}

}
