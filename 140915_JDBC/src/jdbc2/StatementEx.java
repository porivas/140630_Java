package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StatementEx {

	public static void main(String[] args) throws Exception {

		// try ~ with Resources(TWR) Auto Closer
		// 이렇게 코딩하면 Finally 안써도 된다. 
		String driverName="oracle.jdbc.OracleDriver";
		String urlPath="jdbc:oracle:thin:@61.72.16.181:5021:orcl";
		String userid = "c##user02";
		String userpw = "user02";

		String sql = "select sysdate from dual";

		Class.forName(driverName);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {

			try(
					// 소켓연결
					Connection con = DriverManager.getConnection(urlPath, userid, userpw);
					// OutputStream
					PreparedStatement stmt = con.prepareStatement(sql);
					// InputStream (select 문 사용할 때만 ResultSet 사용한다.) 
					ResultSet rs = stmt.executeQuery(); 

					){
				System.out.println(con);
				System.out.println("ready.....");

				System.out.println(rs);
				System.out.println(rs.next()); // 한 칸 반드시 내려와야 한다. (첫 번째 칸에는 메타데이터가 있다) 
				System.out.println(rs.getString(1));
				
				// 커넥션 하나로 여러번 맺는 코드 
				
			}catch(Exception e){
				e.printStackTrace();
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("결과값");
		System.out.println(end-start);

	}

}
