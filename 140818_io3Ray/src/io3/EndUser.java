package io3;
// 3번째 구동 

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EndUser {

	public void downloadMP3(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("받고싶은 사용자의 이름 입력:");
		String serverName =scanner.nextLine()+"\n";
		String serverIp = "192.168.0.73";
		int port = 8080;
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		FileOutputStream fos = null;
		byte[] buffer = new byte[1024*8];
		
		try{
			socket = new Socket(serverIp, port);
			out = socket.getOutputStream();
			in = socket.getInputStream();
			fos = new FileOutputStream("C:\\zzz\\"+serverName+System.currentTimeMillis()+".mp3");
			out.write(serverName.getBytes());
			out.flush();
			while(true){
				int count = in.read(buffer);
				if(count == -1){ System.out.println("전송완료");break;}
				System.out.println(count);
				fos.write(buffer,0,count);
				
			}
			fos.flush();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
			// 
		}finally{
			try{ out.close();}catch(Exception e){}
			try{ socket.close();}catch(Exception e){}
		}
	}
	public static void main(String[] args)throws Exception {
		EndUser obj = new EndUser();
		obj.downloadMP3();
	}
}
