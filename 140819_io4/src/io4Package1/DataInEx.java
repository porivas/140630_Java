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
		System.out.println("�������");
	}

	public void waitUser() throws Exception{
		String result;

		//�����̸� ����Ʈ �̱�
		String dirName = "C:\\zzz\\mp3";
		File mp3Dir = new File(dirName);
		String[] mp3List = mp3Dir.list();
		StringBuilder builder = new StringBuilder();
		for (String title : mp3List) {
			//��ū(������ "|")�� �߰�
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
		System.out.println("����Ʈ ���ۿϷ�");

		DataInputStream dis = new DataInputStream(client.getInputStream());
		String fileTitle = dis.readUTF();
		System.out.println(fileTitle+" ���۽����մϴ�.");
		/////
		InputStream in2Disk = new FileInputStream("C:\\zzz\\mp3\\"+fileTitle);
		byte[] buffer = new byte[1024*8];   
		while(true) {
			int mp3Count = in2Disk.read(buffer);
			if(mp3Count == -1) {break;}
			System.out.println("2....");
			clientDos.write(buffer, 0, mp3Count);
		}
		System.out.println("���ۿϷ�");
		////
		in2Disk.close();
		clientDos.flush();
		clientDos.close();
		server.close();

		waitUser();
	}




}
