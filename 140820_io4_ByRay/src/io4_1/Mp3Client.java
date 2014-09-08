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
	// �ؽ���. �޼ҵ带 �ʿ� ��´�. 
	private Map<String, Method> methodMap;
	// ������. ���鶧 �ݵ�� ip�� ���path�� �޴´�. 
	public Mp3Client(String ip, String path) throws Exception{
		super();
		this.ip = ip;
		this.port = 5555;
		this.keyScanner = new Scanner(System.in);
		this.path = path;
		
		this.methodMap = new HashMap<String, Method>();
		
		// this�� �ִ� ��� �޼ҵ带 �ҷ��ͼ� arr�� �̸��� �迭�� ��ƶ�. 
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
		
		System.out.println("�۾��� �����ұ��?");
		getUsage();
		
		while(true){
			methodMap.get(keyScanner.nextLine()).invoke(this, null);
		}
	}
	@KeyAnno("1")
	public void getUsage()throws Exception{
		
		// �͸�Ŭ����. 
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
		
		System.out.println("�ٿ�ε��� ���ϸ��� �Է��ϼ���");
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
				
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			}
			
		}.doExecute();
		
	}
	@KeyAnno("4")
	public void upload()throws Exception{
		
		System.out.println("���ε��� ���ϸ��� �Է��ϼ���");
		final String fileName = keyScanner.nextLine();
		
		new ClientAgent(this.ip,this.port){

			@Override
			protected void sendMsg() throws Exception {
				dos.writeUTF("4");
				dos.writeUTF(fileName);
				FileInputStream fin = new FileInputStream(path+fileName);
				
				CopyUtil.copy(fin, dos, true, false);
				
				System.out.println("���ε尡 �Ϸ�Ǿ����ϴ�.");
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
