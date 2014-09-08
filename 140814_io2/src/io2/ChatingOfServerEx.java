package io2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatingOfServerEx {
public static void main(String[] args)throws Exception {
	Scanner scanner2 = new Scanner(System.in);
	   ServerSocket server = new ServerSocket(5555);      
	      System.out.println("Ready..........");      
	      Socket clientSocket = server.accept();      
	      System.out.println(clientSocket);
	      
	      //클라이언트에서온 메시지를 받는다
	      InputStream in= clientSocket.getInputStream();
	      Scanner scanner= new Scanner(in);
			if (scanner.nextLine().equals("EXIT")){
				in.close();
			}
	      System.out.println(scanner.nextLine());
	      System.out.println("== 메세지 수신 완료 ==");
	      //클라이언트로 메시지를 출력   
	      OutputStream out = clientSocket.getOutputStream();    
	      String msg2 = scanner2.nextLine()+"\n";
//	      String msg2 = "안녕? \n";
	      out.write(msg2.getBytes());
	      System.out.println("== 메세지 송신 완료 ==");
	      out.close();
}
}
