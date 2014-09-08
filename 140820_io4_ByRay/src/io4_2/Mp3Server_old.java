package io4_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Mp3Server_old {

	private ServerSocket serverSocket;
	private Mp3Service_old service;
	
	public Mp3Server_old()throws Exception{
		serverSocket = new ServerSocket(5555);
		service = new Mp3Service_old("C:\\zzz\\mp3");
		System.out.println("ready server.....");
		waitClient();
	}
	
	public void waitClient(){
		System.out.println("������ ������Դϴ�.");
		
		Socket client = null;
		DataInputStream din = null;
		DataOutputStream dos = null;
		try{
			client = serverSocket.accept();
			System.out.println("Ŭ���̾�Ʈ�� ����Ǿ����ϴ�." + client);
			din = new DataInputStream(client.getInputStream());
			dos = new DataOutputStream(client.getOutputStream());
			
			String cmd = din.readUTF();
			System.out.println(cmd);
			
			switch (cmd) {
			case "1":
				showUsage(din, dos);
				break;
			case "2":
				sendList(din, dos);
				break;
			case "3":
				sendMp3(din, dos);
				break;
			case "4":
				receiveMp3(din, dos);
				break;				
			default:
				showUsage(din, dos);
				break;
			}
			
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{ dos.close(); }catch(Exception e){}
			try{ din.close(); }catch(Exception e){}
			try{ client.close(); }catch(Exception e){}
		}
		waitClient();
	}
	

	public void showUsage(DataInputStream din, DataOutputStream dos)throws Exception{
		dos.writeUTF("1.����,2.����Ʈ,3.�ٿ�ε� <���ϸ�>, 4.���ε� <���ϸ�>");
	}
	
	public void sendList(DataInputStream din, DataOutputStream dos)throws Exception{
		dos.writeUTF(service.getList());
		
	}
	
	public void sendMp3(DataInputStream din, DataOutputStream dos)throws Exception{
		
		File targetFile = service.getFile(din.readUTF());
		
		dos.writeUTF(targetFile.getName());
		
		FileInputStream fin = new FileInputStream(targetFile);
		
		CopyUtil_old.copy(fin, dos, true, false);
		
		
	}
	public void receiveMp3(DataInputStream din, DataOutputStream dos)throws Exception{
		
		String uploadFileName = din.readUTF();
		
		service.saveFile(uploadFileName, din);
		
		
	}
	
	public static void main(String[] args) throws Exception{
	
		Mp3Server_old server = new Mp3Server_old();
	}
}





