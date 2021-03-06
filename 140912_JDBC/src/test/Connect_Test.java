package test;


import java.sql.Connection;
import java.sql.DriverManager;

public class Connect_Test implements Runnable {
	
	public void makeConnection() throws Exception{
		// Driver loading 
		Class.forName("oracle.jdbc.OracleDriver");
		// URL connect
		String path = "jdbc:oracle:thin:@thinker.ipdisk.co.kr:1521:orcl";
		String userid = "user00";
		String userpw = "user00";
		
		try(Connection con = DriverManager.getConnection(path, userid, userpw)){
		// Connection을 소켓이라고 생각할 것. 
		// try ~ with 기법. try() 괄호안에 close해야하는 것을 넣는다. 
		System.out.println(con);
		
		Thread.sleep(100); // SQL 실행시간. 쓰레드의 숫자 = 접속자의 숫자. 
		}
//		con.close();
	}
	
	public static void main(String[] args) throws Exception {

		Connect_Test obj = new Connect_Test ();
		for (int i = 0; i < 10; i++) {
			Thread th = new Thread(obj);
			th.start();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			makeConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
