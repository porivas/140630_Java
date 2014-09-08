package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1  extends Mp3serverAbs {
	public static void main(String[] args) throws Exception {
		ServerEx1 ex1 = new ServerEx1();
		ex1.helloWeb();
	}

	public void helloWeb() throws Exception{
		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready....");

		byte[] arr = new byte[1024];

		Socket socket = server.accept();

		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		int count = in.read(arr);

		System.out.println(count);

		System.out.println(new String(arr)); //바이트배열 ==> 문자열

		//	      String msg2 ="<li><a href='http://www.naver.com'>안녕 웹페이지? 으하항</li></a>";
		//		String msg1 = "<audio controls><source src="+"C:\\zzz\\aaa.mp3"+"></audio>";
		String tempPath = "C:\\zzz\\aaa.mp3";
		File testMP3 = new File("C:\\zzz\\aaa.mp3");
		fis = new FileInputStream(tempPath);
		String msg ="<audio controls><source src="+tempPath+"type='audio/mpeg'></audio>";

//		byte[] msgArr = msg.getBytes("UTF-8");
		byte[] msgArr = testMP3.


		// 지금부터 내가 보내는 정보는 HTTP 1.1 정보이고 200(정상적인 응답) 이다. 
		out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); 
		// 옛날 브라우져가 가진 정보를 사용하지 못하도록 
      out.write(new String("Cache-Control: private\r\n").getBytes()); 
		// 내가 지금부터 정보를 얼마나 보낼 것인지 길이를 말해준다. 
		out.write(new String("Content-Length: "+testMP3.length()+"\r\n").getBytes()); 
		// MIME정보. 타입. 브라우져의 정보.  
		out.write(new String("Content-Type: audio/mpeg3; charset=UTF-8\r\n\r\n").getBytes());

		out.write(msgArr);
	
		out.flush();

	}

}
