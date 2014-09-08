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
			//한모금 빨기 한모금은 1 byte의 데이터
			int data = in1.read();
			System.out.println(data);
			
			if (data == -1){
				out.close();
				break;}
			out.write(data);	
		}
	
		out.flush();
		System.out.println("파일 전송 성공");

		
		//서버로부터 받은메세지 
		InputStream in = socket.getInputStream();
		Scanner scanner3 = new Scanner(in+"\n");
//		if (scanner3.nextLine().equals("EXIT\n")){
//			out.close();
//		}
		System.out.println("받은파일경로");
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
