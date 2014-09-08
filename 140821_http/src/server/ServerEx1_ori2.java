package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ServerEx1_ori2 extends Mp3serverAbs {
	String filePath;
	String fileList;
	 ServerSocket server;
	 OutputStream out ;
	String localMp3Root = "http:/192.168.0.73:5555/mp3/";

   public static void main(String[] args) throws Exception {
	   
	   ServerEx1_ori2 mp3Server3 = new ServerEx1_ori2();
	   
	   mp3Server3.showFileList();
	   mp3Server3.runProcess();
	   mp3Server3.runServer(5555);

   }
   
   StringBuffer mp3Buffer = new StringBuffer();

	public void sendListHelper(String filePath) throws Exception {
		
		System.out.println("���� �۵�");
		File mp3Dir = new File(filePath);
		File[] mp3List = mp3Dir.listFiles();
		for (File file : mp3List) {
			if (file.isFile()) {
				//listen?file=aaa.mp3
//				<a href="#" class="test" on-click="location.href='��ũ';">
//				mp3Buffer.append("<li><A HREF ='"+file.getName()+ " on-click="location.href='http://www.naver.com';>"+file.getName() + "<br></li></a>");
				mp3Buffer.append("<li><A HREF =\""+"\\mp3\\"+file.getName()+ "\">"+file.getName() + "<br></li></a>");
//				mp3Buffer.append("<audio controls><source src='"+"\\mp3\\"+file.getName()+" type=\"audio/mpeg\">"+file.getName() + "<br></a></audio>");

			} else if (file.isDirectory()) {
				//				System.out.println(filePath + file.getName());
				System.out.println("������� Ž��");
				sendListHelper(filePath + file.getName());
			}
			
		}

	}
	// 1�� ���� �� ���ϸ���Ʈ �����ֱ�
	public void showFileList() throws Exception {
		System.out.println("����Ʈ�۵�");
//		System.out.println("1�� ���� �� ���ϸ���Ʈ �����ֱ�");
		filePath = "C:\\Workspace\\140821_http\\mp3";
		sendListHelper(filePath);
		fileList = mp3Buffer.toString();
		// fileList = null;
		}

   
   public void runProcess() throws Exception{
	   server = new ServerSocket(5555); 
	      System.out.println("ready......");

	      byte[] arr = new byte[1024];

	      Socket socket = server.accept();

	      InputStream in = socket.getInputStream();
	      out = socket.getOutputStream();

	      int count = in.read(arr);

	      System.out.println(count);
	      System.out.println(new String(arr));
	      
		  System.out.println(fileList);
	      String msg = fileList;
	      byte[] msgArr = msg.getBytes("UTF-8");

	      out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); // 200:��������
	      //out.write(new String("Cache-Control: private\r\n").getBytes()); // ������������ �����ִ� ���� ����
	      out.write(new String("Content-Length: " + msgArr.length + "\r\n").getBytes()); // contents ����?
	      out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n") // contents type(MIME type)
	            .getBytes());

	      out.write(msgArr);
	      out.flush();
	      server.close();
   }
   
   public void runServer(int port) throws Exception{
	   serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		//�������� ���ϴ� ���� �б�
		//�������� ���ϴ� ������ �����ֱ� 
		
		InputStream in = socket.getInputStream();
		Scanner scanner = new Scanner(in);
		String fileName = scanner.nextLine();
		String[]  arr = fileName.split(" ");
		System.out.println(fileName);
		System.out.println(arr[1]);
		
		String targetFileName = arr[1].replace("/mp3/", "C:\\Workspace\\140821_http\\mp3\\");
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
	     out.write(new String("Content-Type: audio/mpeg3; charset=charset=EUC-KR\r\n\r\n").getBytes()); // contents type(MIME type)
	    
	    //���� �����Ϳ� ������ ���� 
	     System.out.println(file);
	     FileInputStream fin2 = new FileInputStream(file);
	     
	     while(true){
	    	 int data = fin2.read();
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
   
}