package io2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SendingFileServerExByJun {
	public static void main(String[] args) throws Exception {
	    ServerSocket server = new ServerSocket(5555); //서버를 열어 놓는다. 5555port로
	    System.out.println("Ready..........");
	    
	    Socket clientSocket = server.accept();
	    System.out.println(clientSocket);
	    System.out.println("Client가 접속했습니다.");
	    
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

