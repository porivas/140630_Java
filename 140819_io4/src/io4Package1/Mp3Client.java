package io4Package1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Mp3Client {

	Socket client;
	DataInputStream dis;
	DataOutputStream dos;
	Scanner sc;
	String fileName;
	OutputStream out2Disk;

	public void getList() throws Exception {

		client = new Socket("192.168.0.73", 5555);
		dis = new DataInputStream(client.getInputStream()); 
		String result = dis.readUTF();
		//      System.out.println(result);
		String[] arr = result.split("\\|");  
		int i=0;
		for (String string : arr) {
			System.out.println((i+1)+". "+string);
			i++;
		}
		sc = new Scanner(System.in);
		System.out.println("���ϴ� ���Ϲ�ȣ�� �Է�: ");
		int userSelection = sc.nextInt();
		System.out.println(arr[userSelection-1]+"���� �����ϼ̽��ϴ�.");
		dos = new DataOutputStream(client.getOutputStream()); 
		fileName = arr[userSelection-1];
		dos.writeUTF(fileName);
		System.out.println("���ϸ� ���ۿϷ�");
		///

		///
	}

	public void download() throws Exception {
		out2Disk = new FileOutputStream("C:\\zzz\\mp3\\"+"copy_"+fileName);
		dis = new DataInputStream(client.getInputStream());
		byte[] buffer = new byte[1024*8];   
		while(true) {
			int mp3Count = dis.read(buffer);
			if(mp3Count == -1) break;
			out2Disk.write(buffer, 0, mp3Count);
		}
		System.out.println("���ۿϷ�");
		dos.close();
		dis.close();
		out2Disk.close();
		client.close();
	}

	public static void main(String[] args) throws Exception {
		Mp3Client mp = new Mp3Client();
		mp.getList();
		mp.download();
	}

}