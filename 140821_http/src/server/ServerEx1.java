package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1  extends Mp3serverAbs {
	public static void main(String[] args) throws Exception {
		ServerEx1 ex1 = new ServerEx1();
		ex1.helloWeb();
	}

	public void helloWeb() throws Exception{
		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready....");

		byte[] arr = new byte[1024];

		Socket socket = server.accept();

		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		int count = in.read(arr);

		System.out.println(count);

		System.out.println(new String(arr)); //����Ʈ�迭 ==> ���ڿ�

		//	      String msg2 ="<li><a href='http://www.naver.com'>�ȳ� ��������? ������</li></a>";
		//		String msg1 = "<audio controls><source src="+"C:\\zzz\\aaa.mp3"+"></audio>";
		String tempPath = "C:\\zzz\\aaa.mp3";
		File testMP3 = new File("C:\\zzz\\aaa.mp3");
		fis = new FileInputStream(tempPath);
		String msg ="<audio controls><source src="+tempPath+"type='audio/mpeg'></audio>";

//		byte[] msgArr = msg.getBytes("UTF-8");
		byte[] msgArr = testMP3.


		// ���ݺ��� ���� ������ ������ HTTP 1.1 �����̰� 200(�������� ����) �̴�. 
		out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); 
		// ���� �������� ���� ������ ������� ���ϵ��� 
      out.write(new String("Cache-Control: private\r\n").getBytes()); 
		// ���� ���ݺ��� ������ �󸶳� ���� ������ ���̸� �����ش�. 
		out.write(new String("Content-Length: "+testMP3.length()+"\r\n").getBytes()); 
		// MIME����. Ÿ��. �������� ����.  
		out.write(new String("Content-Type: audio/mpeg3; charset=UTF-8\r\n\r\n").getBytes());

		out.write(msgArr);
	
		out.flush();

	}

}
