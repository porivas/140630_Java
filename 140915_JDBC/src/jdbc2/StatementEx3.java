package jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StatementEx3 {
	public static void main(String[] args) throws Exception {
		//try ~ with Resources(TWR)
//		String driverName = "oracle.jdbc.OracleDriver";
//		String urlPath = "jdbc:oracle:thin:@61.72.16.181:5021:orcl";
//		
//		String sql = "select sysdate from dual";
//		
//		Class.forName(driverName); //문자열로 된 class이름을 동적으로 변환
//		
		long start = System.currentTimeMillis();
//		
		for (int i = 0; i < 100; i++) {
			try(
//				Connection con = DriverManager.getConnection(urlPath,"han00","han00");
				Connection con = MyConnectionPool.getInstance().getConnection();
				PreparedStatement stnt = con.prepareStatement("select sysdate from dual");
				ResultSet rs = stnt.executeQuery();
				//resultset은 select할때만 사용
					){
				System.out.println(rs);
				rs.next();
				System.out.println(rs.getString(1));
				rs.close();
				stnt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
