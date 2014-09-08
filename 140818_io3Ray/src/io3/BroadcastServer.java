package io3;
// 2��° ����

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class BroadcastServer {

	ServerSocket mainServer;
	Map<String, String> ipMap;
	private Scanner scFile;
	
	public BroadcastServer()throws Exception{
		// ������ ���� HashMap�� ������ �־��ֱ�. 
		InputStream loadFile = new FileInputStream("c:\\zzz\\Mp3User.properties.txt");
		Properties props = new Properties();
		props.load(loadFile);
		Iterator names = props.keySet().iterator();
		ipMap = new HashMap<String, String>();
		while(names.hasNext()){
			String var1 = (String) names.next();
			String var2 = (String) props.get(var1);
			ipMap.put(var1, var2);
		}
		
//		ipMap.put("��ȣ","192.168.0.73");
//		ipMap.put("����","192.168.0.85");
////		ipMap.put("������", "192.168.0.70");
//		ipMap.put("����", "192.168.0.76");
//		ipMap.put("����", "192.168.0.80");
//		ipMap.put("�μ�", "192.168.0.39");
//		ipMap.put("����", "192.168.0.84");
		
		mainServer = new ServerSocket(8080);		//���� ����
		System.out.println("ready......main ");		
		waitEndUser();
	}

	private void waitEndUser() {
		
		Socket endUser = null;
		InputStream in = null;
		OutputStream out = null;
		Scanner scanner = null;
		
		byte[] buffer = new byte[1024*8];		// ���ۻ���
		
		try{
			endUser = mainServer.accept();		// ������� ���� ������ ��ٸ��� �����ϸ� ������. �ش� ���� endUser�� ����
			System.out.println("EndUser: " + endUser);		// ������ �������� ���
			
			in = endUser.getInputStream();		//	 �������Լ� ���ƿ��� ���� ��Ʈ
			out = endUser.getOutputStream();	//	 �������� ������ ���� ��Ʈ
			scanner = new Scanner(in);			//	 ���� ���� ��ĳ�ʿ� ����
			String serverName = scanner.nextLine();			// �������� ���� ù��° ���� �ؽ�Ʈ ������ serverName�� ���� 
			String targetIp = ipMap.get(serverName);		// ipMap���� serverName�� Ű������ �ϴ� value�� �޾ƿ�
			Socket mp3Socket = new Socket(targetIp,5555);	// ���ο� ��Ʈ��ȣ�� 5555, ������ ���� ip�� ���� ������ ��Ĺ����
			InputStream mp3In = mp3Socket.getInputStream();	// 5555�� ��Ʈ�� ������ ������ ��ǻ�ͷκ��� mp3������ ���ƿ�
			System.out.println("mp3In" +mp3In);
	
			while(true){
				int mp3Count = mp3In.read(buffer);
				if(mp3Count == -1){ break;}
				out.write(buffer,0, mp3Count);
			}
			// ���۸� Ȱ���� ����. 
			out.flush();
			mp3In.close();
			mp3Socket.close();

		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try{ scanner.close();}catch(Exception e){}
			try{ in.close();}catch(Exception e){}
			try{ out.close();}catch(Exception e){}
			try{ endUser.close();}catch(Exception e){}
		}
		
		waitEndUser();		// ���ȣ���� ���� �ݺ�
	}
	
	public static void main(String[] args)throws Exception {
		
		BroadcastServer server = new BroadcastServer();
	}
	
}





