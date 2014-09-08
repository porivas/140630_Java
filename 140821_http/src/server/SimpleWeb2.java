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
		//�������� ���ϴ� ���� �б�
		//�������� ���ϴ� ������ �����ֱ� 
		
		InputStream in = socket.getInputStream();
		Scanner scanner = new Scanner(in);
		String fileName = scanner.nextLine();
		String[]  arr = fileName.split(" ");
		System.out.println(fileName);
		System.out.println(arr[1]);
		
		String targetFileName = arr[1].replace("/", "C:\\zzz\\");
		System.out.println(targetFileName);
		
		//���� ���� ���ϱ� 
		File file = new File(targetFileName);
		long fileSize = file.length();
		
		//�����͸� ���� �� ����� OutputStream
		OutputStream out = socket.getOutputStream();
		
		//�ʿ��� ��� ������ �̸� ������
	     out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); // 200:��������
	   //out.write(new String("Cache-Control: private\r\n").getBytes()); // ������������ �����ִ� ���� ����
	     out.write(new String("Content-Length: " + fileSize + "\r\n").getBytes()); // contents ����?
	     out.write(new String("Content-Type: text/html; charset=charset=EUC-KR\r\n\r\n").getBytes()); // contents type(MIME type)
	    
	    //���� �����Ϳ� ������ ���� 
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
		System.out.println("��������...");
		SimpleWeb2 web2 = new SimpleWeb2(8111);
		web2.runServer();
		
	}
	
}
