package io3;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args)throws Exception {
		String[] ips = {"192.168.0.46","192.168.0.39"};
//			{"192.168.0.84",	// ����
//				"192.168.0.39",		// �μ���
//				"192.168.0.80", 	// ������
//			"192.168.0.16"}; 	// ����
//		//			"192.168.0.73"	// ��
		byte[] buffer = new byte[1024*8];
		for (String ips1 : ips) {
			Socket socket = new Socket(ips1,5555);
			System.out.println(socket);
			InputStream in = socket.getInputStream();
			FileOutputStream fos = new FileOutputStream("C:\\zzz\\"+ips1+"song.mp3");
			while(true){
				int count = in.read(buffer);
				if(count == -1){break;}
				System.out.println(count);
				fos.write(buffer, 0, count);
			}
			System.out.println(ips1+"�������� �Ϸ�");
			socket.close();	
		}
		//		for (String ip : ips){

		//		}
	}

}
