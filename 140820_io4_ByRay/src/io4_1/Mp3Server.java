package io4_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Mp3Server {

	private ServerSocket serverSocket;
	private Mp3Service service;
	
	public Mp3Server()throws Exception{
		serverSocket = new ServerSocket(5555);
		service = new Mp3Service("C:\\zzz\\mp3");
		System.out.println("ready server.....");
		waitClient();
	}
	
	public void waitClient(){
		System.out.println("연결을 대기중입니다.");
		
		Socket client = null;
		DataInputStream din = null;
		DataOutputStream dos = null;
		try{
			client = serverSocket.accept();
			System.out.println("클라이언트가 연결되었습니다." + client);
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
		dos.writeUTF("1.사용법,2.리스트,3.다운로드 <파일명>, 4.업로드 <파일명>");
	}
	
	public void sendList(DataInputStream din, DataOutputStream dos)throws Exception{
		dos.writeUTF(service.getList());
		
	}
	
	public void sendMp3(DataInputStream din, DataOutputStream dos)throws Exception{
		
		File targetFile = service.getFile(din.readUTF());
		
		dos.writeUTF(targetFile.getName());
		
		FileInputStream fin = new FileInputStream(targetFile);
		
		CopyUtil.copy(fin, dos, true, false);
		
		
	}
	public void receiveMp3(DataInputStream din, DataOutputStream dos)throws Exception{
		
		String uploadFileName = din.readUTF();
		
		service.saveFile(uploadFileName, din);
		
		
	}
	
	public static void main(String[] args) throws Exception{
	
		Mp3Server server = new Mp3Server();
	}
}





