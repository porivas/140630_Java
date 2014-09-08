package io4Package1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataInEx_old {
	//bad code
	public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready server....");
		
		Socket socket = server.accept();
		
		System.out.println("client connected..." + socket);
		
		DataOutputStream clientDos 
		 = new DataOutputStream(socket.getOutputStream());
		
		
		String title = "02. 馬馬馬叙.mp3";
		
		clientDos.writeUTF(title);
		
		InputStream in = new FileInputStream("C:\\zzz\\02. 馬馬馬叙.mp3");
		
		byte[] buffer = new byte[1024*8];
		
		while (true){
			int count = in.read(buffer);
			if(count == -1){
				break;
			}
			clientDos.write(buffer,0, count);
			
		}
		clientDos.flush();
		clientDos.close();
		
	}
}









