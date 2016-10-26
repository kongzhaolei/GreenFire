package com.needle.greenfire.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtil {
	private PreparedStatement pstmt = null;
	private Connection con = null;

	public DbUtil() {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("db");
			String driver = bundle.getString("driver");
			String url = bundle.getString("url");
			String username = bundle.getString("username");
			String password = bundle.getString("password");
			System.out.println(driver);
			Class.forName(driver);
			this.con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return this.con;
	}

	public void close() {
		if (this.pstmt != null) {
			try {
				this.pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (this.con != null)
			try {
				this.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
