package sync1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
	
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Scanner keyScanner = new Scanner(System.in);
	
	public ChatClient(String ip, int port)throws Exception{
		this.socket = new Socket(ip, port);
		this.dis = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
	}
	
	public void readMsg() throws Exception{
		while(true){
			System.out.println(dis.readUTF());
		}
	}
	public void writeMsg() throws Exception{
		while(true){
			System.out.println("입력하세요: ");
			String msg = keyScanner.nextLine();
			dos.writeUTF("yunho:"+msg);
			dos.flush();
		}
	}
	public void run(){
		try {
			readMsg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)throws Exception {
		ChatClient client = new ChatClient("192.168.0.46", 5555);
		client.start();
		client.writeMsg();
	}

}
