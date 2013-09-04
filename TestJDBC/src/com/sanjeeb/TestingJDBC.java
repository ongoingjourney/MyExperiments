package com.sanjeeb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TestingJDBC {

	public static void main(String[] args) {
		String portNumber = "3306";
		String user = "root";
		String password = "abc123";
		String url = "jdbc:mysql://localhost/";
		String dbName = "first_db";
		String tableName = "";
		Connection conn = getConnection(url, portNumber, user, password);
		ptsmtShowDatabase(conn);
		ptsmtUseDatabase(conn, dbName);
		//ptsmtShowTables(conn);
		//runCreateTable(getConnection(url, portNumber, user, password), tableName)
		closeConnection(conn);
	}
	
	private static Connection getConnection(String url, String portNumber, String user, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn =  DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	private static void ptsmtRunCreateTable(Connection conn, String tableName ) {
		try {
		PreparedStatement pstmt = conn.prepareStatement("CREATE ?");
		pstmt.setString(1, tableName);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	private static void ptsmtShowTables(Connection conn) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
			Boolean result = pstmt.execute();
			System.out.println(result);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	
	private static void ptsmtUseDatabase(Connection conn, String dbName) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("USE ?");
			pstmt.setString(1, dbName);
//			pstmt.setNString(1, dbName);
			System.out.println(pstmt.toString());
			Boolean result = pstmt.execute();
			System.out.println(result);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
	}
	
	private static void ptsmtShowDatabase(Connection conn) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("SHOW DATABASES");
			if(!pstmt.execute()) {
				System.out.println("Can't execute");
				return;
			}
			ResultSet results = pstmt.getResultSet();
			while(results.next()) {
				//System.out.println(results.getString("Database"));
			}
			pstmt.close();
		} catch (SQLException ex) {
				ex.printStackTrace();
		}
	}
	
	private static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
