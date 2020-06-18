package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.sql.PreparedStatement;

public class DBConnectionUtil {
	private static  String URL;
	private static  String USER;
	private static  String PASSWORD;
	
	
	
	public static Connection getConnection() {
		Connection conn= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		 try {
			 Properties properties = PropertiesUtil.readProperties();
			 URL = properties.getProperty("url");
			 USER= properties.getProperty("user");
			 PASSWORD = properties.getProperty("password");
			 conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	public static void close(Statement st) {
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement pst) {
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn,Statement st, ResultSet rs) {
		close(rs);
		close(st);
		close(conn);
	}
	
	public static void close(Connection conn,PreparedStatement pst) {
		close(pst);
		close(conn);
	}
	public static void close(Connection conn,PreparedStatement pst, ResultSet rs) {
		close(rs);
		close(pst);
		close(conn);
	}
	
}
