package io4_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mp3Client {
	
	private Scanner keyScanner;
	private String ip;
	private int port;
	private String path;
	// 해쉬맵. 메소드를 맵에 담는다. 
	private Map<String, Method> methodMap;
	// 생성자. 만들때 반드시 ip랑 경로path를 받는다. 
	public Mp3Client(String ip, String path) throws Exception{
		super();
		this.ip = ip;
		this.port = 5555;
		this.keyScanner = new Scanner(System.in);
		this.path = path;
		
		this.methodMap = new HashMap<String, Method>();
		
		// this에 있는 모든 메소드를 불러와서 arr란 이름의 배열에 담아라. 
		Method[] arr = this.getClass().getDeclaredMethods();
		//
		
		//foreach
		for (Method method : arr) {
			KeyAnno anno = method.getAnnotation(KeyAnno.class);
			if(anno == null){
				continue;
			}
			methodMap.put(anno.value(), method);
		}	
	}
	
	public void execute()throws Exception{
		
		System.out.println("작업을 시작할까요?");
		getUsage();
		
		while(true){
			methodMap.get(keyScanner.nextLine()).invoke(this, null);
		}
	}
	@KeyAnno("1")
	public void getUsage()throws Exception{
		
		// 익명클래스. 
		new ClientAgent(this.ip,this.port){

			@Override
			protected void sendMsg() throws Exception {
				dos.writeUTF("1");
			}

			@Override
			protected void receiveMsg() throws Exception {
				System.out.println(din.readUTF());
			}
			
		}.doExecute();
		
	}	
	
	@KeyAnno("2")
	public void getList()throws Exception{
		
		new ClientAgent(this.ip,this.port){

			@Override
			protected void sendMsg() throws Exception {
				dos.writeUTF("2");
			}

			@Override
			protected void receiveMsg() throws Exception {
				System.out.println(din.readUTF());
			}
			
		}.doExecute();
		
	}
	@KeyAnno("3")
	public void download()throws Exception{
		
		System.out.println("다운로드할 파일명을 입력하세요");
		final String fileName = keyScanner.nextLine();
		
		new ClientAgent(this.ip,this.port){

			@Override
			protected void sendMsg() throws Exception {
				dos.writeUTF("3");
				dos.writeUTF(fileName);
			}

			@Override
			protected void receiveMsg() throws Exception {
				String saveFileName = din.readUTF();
				
				FileOutputStream fos = new FileOutputStream(path+saveFileName);
				
				CopyUtil.copy(din, fos, false, true);
				
				System.out.println("전송이 완료되었습니다.");
			}
			
		}.doExecute();
		
	}
	@KeyAnno("4")
	public void upload()throws Exception{
		
		System.out.println("업로드할 파일명을 입력하세요");
		final String fileName = keyScanner.nextLine();
		
		new ClientAgent(this.ip,this.port){

			@Override
			protected void sendMsg() throws Exception {
				dos.writeUTF("4");
				dos.writeUTF(fileName);
				FileInputStream fin = new FileInputStream(path+fileName);
				
				CopyUtil.copy(fin, dos, true, false);
				
				System.out.println("업로드가 완료되었습니다.");
			}

			@Override
			protected void receiveMsg() throws Exception {
				
			}
			
		}.doExecute();
		
	}
	
	public static void main(String[] args)throws Exception {
		Mp3Client client = new Mp3Client("127.0.0.1","C:\\zzz\\");
		client.execute();
	}
}
