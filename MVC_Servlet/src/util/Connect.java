package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	static Connection conn;
	private Connect() {}
	public static Connection getConnection() throws SQLException {
		if(conn==null || conn.isClosed())
			return getConn();			
		return conn;
		
	}
	private static Connection getConn() {
		String url="jdbc:mysql://127.0.0.1:3306/Login?autoReconnect=true&useSSL=false";
		String user="root";
		String pass="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
		}catch (Exception e) {
			System.out.println("Connection Fail: "+e.getMessage());
		}
		return conn;
	}	
}
