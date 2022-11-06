package DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class conn {
	static String url="jdbc:oracle:thin:@localhost:1521:XE";
	static String user="multi", pwd="tiger";
	private static Connection conn;
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	public static Connection getCon() throws SQLException{
		if(conn==null) 
		{
			conn=DriverManager.getConnection(url,user,pwd);
		}
		return conn;
	}
}
