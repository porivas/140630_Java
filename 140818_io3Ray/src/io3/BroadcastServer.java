package io3;
// 2번째 구동

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
		// 파일을 통해 HashMap에 데이터 넣어주기. 
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
		
//		ipMap.put("윤호","192.168.0.73");
//		ipMap.put("은애","192.168.0.85");
////		ipMap.put("서버컴", "192.168.0.70");
//		ipMap.put("가현", "192.168.0.76");
//		ipMap.put("봉재", "192.168.0.80");
//		ipMap.put("인수", "192.168.0.39");
//		ipMap.put("준일", "192.168.0.84");
		
		mainServer = new ServerSocket(8080);		//소켓 선언
		System.out.println("ready......main ");		
		waitEndUser();
	}

	private void waitEndUser() {
		
		Socket endUser = null;
		InputStream in = null;
		OutputStream out = null;
		Scanner scanner = null;
		
		byte[] buffer = new byte[1024*8];		// 버퍼생성
		
		try{
			endUser = mainServer.accept();		// 사용자의 소켓 접속을 기다리고 접속하면 수락함. 해당 정보 endUser에 저장
			System.out.println("EndUser: " + endUser);		// 접속한 유저정보 출력
			
			in = endUser.getInputStream();		//	 유저에게서 빨아오는 정보 루트
			out = endUser.getOutputStream();	//	 유저에게 보내는 정보 루트
			scanner = new Scanner(in);			//	 받은 정보 스캐너에 삽입
			String serverName = scanner.nextLine();			// 유저에게 받은 첫번째 줄의 텍스트 정보를 serverName에 저장 
			String targetIp = ipMap.get(serverName);		// ipMap에서 serverName을 키값으로 하는 value를 받아옴
			Socket mp3Socket = new Socket(targetIp,5555);	// 새로운 포트번호는 5555, 접속한 유저 ip와 연결 가능한 소캣생성
			InputStream mp3In = mp3Socket.getInputStream();	// 5555번 포트와 접속한 유저의 컴퓨터로부터 mp3파일을 빨아옴
			System.out.println("mp3In" +mp3In);
	
			while(true){
				int mp3Count = mp3In.read(buffer);
				if(mp3Count == -1){ break;}
				out.write(buffer,0, mp3Count);
			}
			// 버퍼를 활용한 쓰기. 
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
		
		waitEndUser();		// 재귀호출을 통한 반복
	}
	
	public static void main(String[] args)throws Exception {
		
		BroadcastServer server = new BroadcastServer();
	}
	
}





