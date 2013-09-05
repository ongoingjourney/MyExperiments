package com.sanjeeb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;

public class TestingJDBC {

	public static void main(String[] args) {
		String portNumber = "3306";
		String user = "root";
		String password = "abc123";
		String dbName = "first_db";
		String url = "jdbc:mysql://localhost:" + portNumber + "/" + dbName;
		String tableName = "Persons";
		Connection conn = getConnection(url, user, password);
		showDatabasePST(conn);
		for(int i = 0; i < 7; ++i)
			runInsertIntoPersonTablePST(conn, tableName, PersonFactory.getPerson());
		
		// showTablesPST(conn);
		closeConnection(conn);
	}
	
	private static Connection getConnection(String url, String user, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	private static void runInsertIntoPersonTablePST(Connection conn, String tableName, Map<String, String> values) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(createInsertString(tableName, values));
			pstmt.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	private static String createInsertString(String tableName, Map<String, String> values) {
		if(tableName == null || tableName.trim().length() == 0 || values == null || values.keySet().isEmpty()) {
			throw new IllegalArgumentException();
		}
		StringBuilder bldr = new StringBuilder();
		bldr.append("INSERT INTO " + tableName)
			.append("(");
		
		Iterator<String> ite = values.keySet().iterator();
		
		while(ite.hasNext()) {
			bldr.append(ite.next() + ", ");
		}
		bldr.delete(bldr.length()-2, bldr.length()-1);
		bldr.append(") VALUES(");
		ite = values.keySet().iterator();
		while(ite.hasNext()) {
			bldr.append("'" + values.get(ite.next()) + "', ");
		}
		bldr.delete(bldr.length()-2, bldr.length()-1);
		bldr.append(")");
		System.out.println(bldr.toString());
		return bldr.toString();
	}
	
//	private static void showTablesPST(Connection conn) {
//		try {
//			PreparedStatement pstmt = conn.prepareStatement("SHOW TABLES");
//			ResultSet results = pstmt.getResultSet();
//			while(results.next()) {
//				System.out.println(results.getString("Tables_in_first_db"));
//			}
//			} catch (SQLException ex) {
//				ex.printStackTrace();
//			}
//	}
	
	private static void showDatabasePST(Connection conn) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("SHOW DATABASES");
			if(!pstmt.execute()) {
				System.out.println("Can't execute");
				return;
			}
			ResultSet results = pstmt.getResultSet();
			while(results.next()) {
				System.out.println(results.getString("Database"));
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