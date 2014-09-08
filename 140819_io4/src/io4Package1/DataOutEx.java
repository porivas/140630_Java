package io4Package1;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class DataOutEx {

	//bad code
	public static void main(String[] args) throws Exception{
		
		Socket socket = new Socket("192.168.0.85", 5555);
		
		DataInputStream din =
				new DataInputStream(socket.getInputStream());
		
		String title = din.readUTF();
		System.out.println(title);
		
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











