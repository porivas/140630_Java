package io4Package1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataInEx {

	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////////////////////////
		DataInEx user = new DataInEx();
		user.waitUser();
		System.out.println("대기종료");
	}

	public void waitUser() throws Exception{
		String result;

		//파일이름 리스트 뽑기
		String dirName = "C:\\zzz\\mp3";
		File mp3Dir = new File(dirName);
		String[] mp3List = mp3Dir.list();
		StringBuilder builder = new StringBuilder();
		for (String title : mp3List) {
			//토큰(구분자 "|")을 추가
			builder.append(title + "|");
		}
		result = builder.toString();

		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready server.......");

		Socket client = server.accept();
		System.out.println("client connected....." + client);

		DataOutputStream clientDos = new DataOutputStream(client.getOutputStream());
		//String title = "Step Up.mp3";      
		clientDos.writeUTF(result);
		System.out.println("리스트 전송완료");

		DataInputStream dis = new DataInputStream(client.getInputStream());
		String fileTitle = dis.readUTF();
		System.out.println(fileTitle+" 전송시작합니다.");
		/////
		InputStream in2Disk = new FileInputStream("C:\\zzz\\mp3\\"+fileTitle);
		byte[] buffer = new byte[1024*8];   
		while(true) {
			int mp3Count = in2Disk.read(buffer);
			if(mp3Count == -1) {break;}
			System.out.println("2....");
			clientDos.write(buffer, 0, mp3Count);
		}
		System.out.println("전송완료");
		////
		in2Disk.close();
		clientDos.flush();
		clientDos.close();
		server.close();

		waitUser();
	}




}
