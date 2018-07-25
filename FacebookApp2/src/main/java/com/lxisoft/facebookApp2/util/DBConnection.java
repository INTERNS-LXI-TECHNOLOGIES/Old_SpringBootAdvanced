package com.lxisoft.FacebookApp2.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.lxisoft.FacebookApp2.controller.RegisterServlet;

public class DBConnection {
	final static org.slf4j.Logger sfl4jlogger = org.slf4j.LoggerFactory.getLogger(RegisterServlet.class);

	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/security"; // MySQL URL
																// followed by
																// the database
																// name
		String username = "root"; // MySQL username
		String password = "root"; // MySQL password

		sfl4jlogger.trace("database connection ready to use");
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver"); // loading MySQL
														// drivers. This differs
														// for database servers
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			con = DriverManager.getConnection(url, username, password); // attempting
																		// to
																		// connect
																		// to
																		// MySQL
																		// database
			System.out.println("Printing connection object " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
