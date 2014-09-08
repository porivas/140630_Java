package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleWeb2 {
	
	private ServerSocket serverSocket;
	
	public SimpleWeb2(int port)throws Exception{
		serverSocket = new ServerSocket(port);
		
	}
	public void runServer() throws Exception{
		Socket socket = serverSocket.accept();
		//브라우저가 원하는 파일 읽기
		//브라우저에 원하는 데이터 보내주기 
		
		InputStream in = socket.getInputStream();
		Scanner scanner = new Scanner(in);
		String fileName = scanner.nextLine();
		String[]  arr = fileName.split(" ");
		System.out.println(fileName);
		System.out.println(arr[1]);
		
		String targetFileName = arr[1].replace("/", "C:\\zzz\\");
		System.out.println(targetFileName);
		
		//실제 파일 구하기 
		File file = new File(targetFileName);
		long fileSize = file.length();
		
		//데이터를 보낼 때 사용할 OutputStream
		OutputStream out = socket.getOutputStream();
		
		//필요한 헤더 데이터 미리 보내기
	     out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); // 200:정상응답
	   //out.write(new String("Cache-Control: private\r\n").getBytes()); // 이전브라우저가 갖고있던 정보 유무
	     out.write(new String("Content-Length: " + fileSize + "\r\n").getBytes()); // contents 정보?
	     out.write(new String("Content-Type: text/html; charset=charset=EUC-KR\r\n\r\n").getBytes()); // contents type(MIME type)
	    
	    //파일 데이터에 파이프 연결 
	     FileInputStream fin = new FileInputStream(file);
	     
	     while(true){
	    	 int data = fin.read();
	    	 if (data == -1){
	    		 break;
	    	 }
	    	 out.write(data);
	     }
	     
	     out.flush();
	     out.close();
	     scanner.close();
	     in.close();
	     
	     socket.close();		
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("서버가동...");
		SimpleWeb2 web2 = new SimpleWeb2(8111);
		web2.runServer();
		
	}
	
}
