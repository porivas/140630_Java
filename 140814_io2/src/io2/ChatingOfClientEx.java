package io2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatingOfClientEx {

	public static void responseTest(Socket socket) throws Exception{
		//		String msg = "Hello~ My name is Yunho Maeng. I'm a Python and Java developer. What is your favorite programing language?\n";
		Scanner scanner1 = new Scanner(System.in);

		String msg = scanner1.nextLine()+"\n";
//		if (scanner1.nextLine().equals("EXIT")){
//			msg.close();
//		}
		OutputStream out = socket.getOutputStream();
		out.write(msg.getBytes());
		out.flush();
		System.out.println("메세지 전송 성공");

		//서버로부터 받은메세지 
		InputStream in = socket.getInputStream();
		Scanner scanner3 = new Scanner(in);
//		if (scanner3.nextLine().equals("EXIT\n")){
//			out.close();
//		}
		System.out.println("받은메세지");
		String msg3 = scanner3.nextLine();
		System.out.println(msg3);
		if (msg3.equals("EXIT")){
			System.out.println("종료합니다.");
			out.close();
		}
		responseTest(socket);
}
	
	public static void main(String[] args) throws Exception {
		
		
//		Scanner scanner3;
		Socket socket = new Socket("192.168.0.79",5555);
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
