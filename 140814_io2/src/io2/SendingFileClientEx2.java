package io2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class SendingFileClientEx2 {

	public static void responseTest(Socket socket) throws Exception{
		//		String msg = "Hello~ My name is Yunho Maeng. I'm a Python and Java developer. What is your favorite programing language?\n";
		Scanner scanner1 = new Scanner(System.in);
		String msg ="C:\\zzz\\copy7.jpg";
		InputStream in1 = new FileInputStream(msg);
		OutputStream out = socket.getOutputStream();
		while(true){
			//�Ѹ�� ���� �Ѹ���� 1 byte�� ������
			int data = in1.read();
			System.out.println(data);
			
			if (data == -1){
				out.close();
				break;}
			out.write(data);	
		}
	
		out.flush();
		System.out.println("���� ���� ����");

		
		//�����κ��� �����޼��� 
		InputStream in = socket.getInputStream();
		Scanner scanner3 = new Scanner(in+"\n");
//		if (scanner3.nextLine().equals("EXIT\n")){
//			out.close();
//		}
		System.out.println("�������ϰ��");
		String msg3 = scanner3.nextLine();
		System.out.println(msg3);
		InputStream in2 = new FileInputStream(msg3);
		responseTest(socket);
}
	
	public static void main(String[] args) throws Exception {
		
		
//		Scanner scanner3;
		Socket socket = new Socket("192.168.0.84",5555);
		System.out.println(socket);
		responseTest(socket);
		
		//		InputStream in = socket.getInputStream();
		//		OutputStream out = new FileOutputStream("aaa.html");
		//		while(true){
		//			int data = in.read();
		//			
		//			if (data == -1){
		//				break;
		//			}
		//			out.write(data);
		//		}
	}
	
	


}
