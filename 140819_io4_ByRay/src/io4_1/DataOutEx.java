package io4_1;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class DataOutEx {

	//bad code
	public static void main(String[] args) throws Exception{
		// �������� ������� ��Ʈ�� ���ؼ� ����
		Socket socket = new Socket("127.0.0.1", 5555);
		
		// ������ �ȾƼ� ������ ������ ����
		DataInputStream din =
				new DataInputStream(socket.getInputStream());
		
		String title = din.readUTF(); // �������� �ѱ��� ������ �ʰ� �ϱ� ���� �޾ƿ�.
		System.out.println(title);
		
		// �� �ϵ�� �޾ƾ� �ϰ�, �� ��� �������. 
		FileOutputStream fos 
		= new FileOutputStream("C:\\zzz\\copy_" +title);
		
		byte[] buffer = new byte[1024*8];
		
		while(true){
			
			int count = din.read(buffer);
			if(count == -1){ break;}
			fos.write(buffer,0,count);
			
		}
		
		
	}
}











