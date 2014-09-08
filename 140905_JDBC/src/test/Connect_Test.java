package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_Test {
	
	public static void main(String[] args) throws Exception {
		// Driver loading 
		Class.forName("oracle.jdbc.OracleDriver");
		// URL connect
		String path = "jdbc:oracle:thin:@thinker.ipdisk.co.kr:1521:orcl";
		String userid = "user00";
		String userpw = "user00";
		
		Connection con = DriverManager.getConnection(path, userid, userpw);
		// Connection을 소켓이라고 생각할 것. 
		System.out.println(con);
		con.close();
		// 
	}

}
