package io2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatingOfServerExByJun {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(5555); //������ ���� ���´�. 5555port��
		System.out.println("Ready..........");
		Socket clientSocket = server.accept();
		System.out.println(clientSocket);
		System.out.println("Client�� �����߽��ϴ�.");

		start(clientSocket);   
	}
	public static void start(Socket clientSocket) throws Exception {
		InputStream in = clientSocket.getInputStream();      
		Scanner scanner2 = new Scanner(in);
		System.out.println("Client�� ���� ä�ó���");
		System.out.println(scanner2.nextLine());

		//Ŭ���̾�Ʈ�� �޽����� ���   
		System.out.println("������~~~~~~");
		Scanner scanner1 = new Scanner(System.in);   
		System.out.println("ä�ó����� �Է��ϼ���");   
		String output = scanner1.nextLine() + "\n";
		OutputStream out = clientSocket.getOutputStream();
		out.write(output.getBytes());
		if(output.equals("EXIT\n")) {
			System.out.println("ä���� ���� �մϴ�.");
			out.close();
			return;
		}
		System.out.println("ä�ó����� ���½��ϴ�.");   
		start(clientSocket);
	}
}
