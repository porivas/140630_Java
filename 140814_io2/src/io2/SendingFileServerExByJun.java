package io2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendingFileServerExByJun {
	public static void main(String[] args) throws Exception {
	    ServerSocket server = new ServerSocket(5555); //������ ���� ���´�. 5555port��
	    System.out.println("Ready..........");
	    
	    Socket clientSocket = server.accept();
	    System.out.println(clientSocket);
	    System.out.println("Client�� �����߽��ϴ�.");
	    
	    InputStream in = clientSocket.getInputStream();            
	    OutputStream out = new FileOutputStream("c:\\zzz\\test.jpg");
	    
	    while(true) {
	       int data = in.read();
	       System.out.println(data);
	       if(data == -1) {
	          out.close();
	          break;
	       }
	       out.write(data);
	    } //while end
	 } //main end
	}

