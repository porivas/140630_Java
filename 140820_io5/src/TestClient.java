

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TestClient  {

	public static void main(String[] args) throws Exception {
		TestClient testObj = new TestClient();
		testObj.test();
	}

	public void test() throws Exception{
		System.out.println("1......");
		Socket client = new Socket("192.168.0.73",5555);
		System.out.println("2......");
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		DataInputStream in = new DataInputStream(client.getInputStream());
		out.writeUTF("5");
		System.out.println("옵션값 전송완료");
		Scanner sc = new Scanner(System.in);
		System.out.println("패스워드 입력: ");
		String testPass = sc.nextLine();
		out.writeUTF(testPass);
		out.close();
		in.close();
		client.close();
	}

}
