package io4_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Mp3Client_old {

	private Scanner keyScanner;
	private String ip;
	private int port;
	private String path;

	public Mp3Client_old(String ip, String path) {
		super();
		this.ip = ip;
		this.port = 5555;
		this.keyScanner = new Scanner(System.in);
		this.path = path;
	}

	public void execute()throws Exception{

		System.out.println("작업을 시작할까요?");
		getUsage();

		while(true){
			String cmd = keyScanner.nextLine();
			switch (cmd) {
			case "1":
				getUsage();
				break;
			case "2":
				getList();
				break;
			case "3":
				System.out.println("파일명을 입력해 주세요");
				download(keyScanner.nextLine());
				break;
			case "4":
				System.out.println("업로드할 파일명을 입력해 주세요");
				upload(keyScanner.nextLine());
				break;				
			default:
				break;
			}
		}
	}
	public void getUsage()throws Exception{

		Socket socket = null;
		DataInputStream din = null; 
		DataOutputStream dos = null;

		try{
			socket = new Socket(this.ip, this.port);
			din = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			dos.writeUTF("1");

			String usage = din.readUTF();

			System.out.println(usage);


		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{ din.close(); }catch(Exception e){}
			try{ dos.close(); }catch(Exception e){}
			try{ socket.close(); }catch(Exception e){}
		}

	}	


	public void getList()throws Exception{

		Socket socket = null;
		DataInputStream din = null; 
		DataOutputStream dos = null;

		try{
			socket = new Socket(this.ip, this.port);
			din = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			dos.writeUTF("2");

			String list = din.readUTF();

			System.out.println(list);

		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{ din.close(); }catch(Exception e){}
			try{ dos.close(); }catch(Exception e){}
			try{ socket.close(); }catch(Exception e){}
		}

	}

	public void download(String fileName)throws Exception{

		Socket socket = null;
		DataInputStream din = null; 
		DataOutputStream dos = null;

		try{
			socket = new Socket(this.ip, this.port);
			din = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			dos.writeUTF("3");
			dos.writeUTF(fileName);


			String saveFileName = din.readUTF();

			FileOutputStream fos = new FileOutputStream(path+saveFileName);

			CopyUtil_old.copy(din, fos, false, true);

			System.out.println("전송이 완료되었습니다.");


		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{ din.close(); }catch(Exception e){}
			try{ dos.close(); }catch(Exception e){}
			try{ socket.close(); }catch(Exception e){}
		}		
	}

	public void upload(String fileName)throws Exception{

		Socket socket = null;
		DataInputStream din = null; 
		DataOutputStream dos = null;

		try{
			socket = new Socket(this.ip, this.port);
			din = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			dos.writeUTF("4");
			dos.writeUTF(fileName);

			FileInputStream fin = new FileInputStream(path+fileName);

			CopyUtil_old.copy(fin, dos, true, false);

			System.out.println("업로드가 완료되었습니다.");


		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{ din.close(); }catch(Exception e){}
			try{ dos.close(); }catch(Exception e){}
			try{ socket.close(); }catch(Exception e){}
		}		
	}

	public static void main(String[] args)throws Exception {
		Mp3Client_old client = new Mp3Client_old("192.168.0.46","C:\\zzz\\");
		client.execute();
	}
}
