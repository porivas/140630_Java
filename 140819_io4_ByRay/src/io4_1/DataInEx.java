package io4_1;

// 서버: Mp3파일을 보내는쪽
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataInEx {
	//bad code
	public static void main(String[] args) throws Exception{
		
		//mp3 파일을 보낼 수 있는 소켓을 연다
		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready server....");
		
		Socket socket = server.accept();
		
		System.out.println("client connected..." + socket);
		//빨대를 꽂는다. (나가는 빨대)
		DataOutputStream clientDos 
		 = new DataOutputStream(socket.getOutputStream());
		
		String title = "My Fathers Eyes.mp3";
		// 노래제목 보내주는 작업
		clientDos.writeUTF(title);		// 유니코드. UTF지원. 한글때문에
		
		// 내 하드디스크에 꽂는 빨대 
		InputStream in = new FileInputStream("C:\\zzz\\My Fathers Eyes.mp3");
		
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









