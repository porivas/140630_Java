package io2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatingOfServerExByJun {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(5555); //서버를 열어 놓는다. 5555port로
		System.out.println("Ready..........");
		Socket clientSocket = server.accept();
		System.out.println(clientSocket);
		System.out.println("Client가 접속했습니다.");

		start(clientSocket);   
	}
	public static void start(Socket clientSocket) throws Exception {
		InputStream in = clientSocket.getInputStream();      
		Scanner scanner2 = new Scanner(in);
		System.out.println("Client가 보낸 채팅내용");
		System.out.println(scanner2.nextLine());

		//클라이언트로 메시지를 출력   
		System.out.println("내차례~~~~~~");
		Scanner scanner1 = new Scanner(System.in);   
		System.out.println("채팅내용을 입력하세요");   
		String output = scanner1.nextLine() + "\n";
		OutputStream out = clientSocket.getOutputStream();
		out.write(output.getBytes());
		if(output.equals("EXIT\n")) {
			System.out.println("채팅을 종료 합니다.");
			out.close();
			return;
		}
		System.out.println("채팅내용을 보냈습니다.");   
		start(clientSocket);
	}
}
