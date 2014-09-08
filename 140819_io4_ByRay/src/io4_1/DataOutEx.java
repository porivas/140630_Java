package io4_1;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class DataOutEx {

	//bad code
	public static void main(String[] args) throws Exception{
		// 서버에서 열어놓은 포트를 통해서 접속
		Socket socket = new Socket("127.0.0.1", 5555);
		
		// 서버에 꽂아서 나한테 가져올 빨대
		DataInputStream din =
				new DataInputStream(socket.getInputStream());
		
		String title = din.readUTF(); // 받을때도 한글이 깨지지 않게 하기 위해 받아요.
		System.out.println(title);
		
		// 내 하드로 받아야 하고, 그 경로 적어줘야. 
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











