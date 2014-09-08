package io3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EndUser {
	
	public void downloadMP3(){
		String serverName = "봉재\n"; 			// 수신자
		String serverIp ="192.168.0.84";		// 중계서버 IP
		int port = 8080;
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		FileOutputStream fos = null;
		
		byte[] buffer = new byte[1024*8];
		
		try{
			socket = new Socket (serverIp, port);
			out = socket.getOutputStream();
			in = socket.getInputStream();
			while(true){
				int count = in.read(buffer);
				if (count == -1){break;}
				System.out.println(count);
			}
			out.write(serverName.getBytes());
			out.flush();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{out.close();}catch(Exception e){}
			try{socket.close();}catch(Exception e){}
		}
		
	}
	
	public static void main(String[] args) {
		EndUser obj = new EndUser();
		obj.downloadMP3();
		
	}

}
