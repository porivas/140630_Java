package io4_1;

// ����: Mp3������ ��������
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataInEx {
	//bad code
	public static void main(String[] args) throws Exception{
		
		//mp3 ������ ���� �� �ִ� ������ ����
		ServerSocket server = new ServerSocket(5555);
		System.out.println("ready server....");
		
		Socket socket = server.accept();
		
		System.out.println("client connected..." + socket);
		//���븦 �ȴ´�. (������ ����)
		DataOutputStream clientDos 
		 = new DataOutputStream(socket.getOutputStream());
		
		String title = "My Fathers Eyes.mp3";
		// �뷡���� �����ִ� �۾�
		clientDos.writeUTF(title);		// �����ڵ�. UTF����. �ѱ۶�����
		
		// �� �ϵ��ũ�� �ȴ� ���� 
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









