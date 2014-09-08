package server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CopyOfServerEx1_ori1 extends Mp3serverAbs {

	String filePath;
	InputStream in;
	OutputStream out;

	// 1번 서버 내 파일리스트 보내주기
	//	public void sendFileList() throws Exception {
	//		System.out.println("리스트 작동");
	//
	////		System.out.println("1번 서버 내 파일리스트 보내주기");
	//		filePath = "C:\\zzz\\";
	//		sendListHelper(filePath);
	//		String fileList = mp3Buffer.toString();
	//		// fileList = null;
	//	     byte[] msgArr = fileList.getBytes("UTF-8");
	//
	//		dos.write(msgArr);
	//		dos.flush();
	//	}

	StringBuffer mp3Buffer = new StringBuffer();

	public void sendListHelper(String filePath) throws Exception {
		System.out.println("헬퍼 작동");
		File mp3Dir = new File(filePath);
		File[] mp3List = mp3Dir.listFiles();
		for (File file : mp3List) {
			if (file.isFile()) {
				mp3Buffer.append(file.getName() + "|");
			} else if (file.isDirectory()) {
				//				System.out.println(filePath + file.getName());
				sendListHelper(filePath + file.getName());
			}
		}

	}

	public void runWebServer() throws Exception{
		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready......");

		byte[] arr = new byte[1024];

		Socket socket = server.accept();

		in = socket.getInputStream();
		out = socket.getOutputStream();

		int count = in.read(arr);

		System.out.println(count);
		System.out.println(new String(arr));

		//	      String msg = "sending message";

		System.out.println("리스트 작동");

		//			System.out.println("1번 서버 내 파일리스트 보내주기");
		filePath = "C:\\zzz\\";
		sendListHelper(filePath);
		String fileList = mp3Buffer.toString();
		// fileList = null;
		System.out.println(fileList);
		byte[] msgArr1 = fileList.getBytes("UTF-8");

		out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); // 200:정상응답
		//out.write(new String("Cache-Control: private\r\n").getBytes()); // 이전브라우저가 갖고있던 정보 유무
		out.write(new String("Content-Length: " + msgArr1.length + "\r\n").getBytes()); // contents 정보?
		out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n") // contents type(MIME type)
		.getBytes());

		out.flush();
	}


	public static void main(String[] args) throws Exception {
		CopyOfServerEx1_ori1 newServer = new CopyOfServerEx1_ori1();
		newServer.runWebServer();


	}
}