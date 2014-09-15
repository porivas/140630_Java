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
		// Connection�� �����̶�� ������ ��. 
		// try ~ with ���. try() ��ȣ�ȿ� close�ؾ��ϴ� ���� �ִ´�. 
		System.out.println(con);
		
		Thread.sleep(100); // SQL ����ð�. �������� ���� = �������� ����. 
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