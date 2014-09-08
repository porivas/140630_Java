package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
	
	private Socket socket;
	private DataInputStream din;
	private DataOutputStream dos;
	private Scanner keyScanner;
	
	
	/**
	 * ChatClient 클래스 생성자 부분 매개변수로 ip/port를 입력받아 소켓 연결
	 * @param ip
	 * @param port
	 * @throws Exception
	 */
	public ChatClient(String ip, int port) throws Exception {
		this.socket = new Socket(ip, port);
		this.din = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
		this.keyScanner = new Scanner(System.in);
	}
	
	
	
	/**
	 * Thread 동작시킬 부분 Override
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			readMsg();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void readMsg() throws Exception {
		while(true){
			String serverMsg = din.readUTF();
			String[] msgArr = serverMsg.split(":");
			
			
			switch(msgArr[0]){
				case "RE_NICK" : 
					if(msgArr[1].equals("Y")){
						System.out.println("사용자가 생성되었습니다.");
					} else {
						System.out.println("닉네임을 입력하세요(SET_NICK:하고싶은이름)");
					}
					break;
				case "RE_ROOM_MAKE":
					if(msgArr[1].equals("N")){
						System.out.println("방이름을 입력하세요(ROOM_NAME:방이름)");
					} else {
						System.out.println("방이 만들어졌습니다.");
					}
					break;
				default:
					System.out.println(serverMsg);
					break;
			}
		}
	}
	
	public void writeMsg() throws Exception {
		while(true){
			
			//System.out.println("입력하세요");
			String msg = keyScanner.nextLine();
			dos.writeUTF(msg);
			dos.flush();
			if (msg.matches(".*EXIT.*")) {
				System.out.println("종료합니다.");
				/*socket.close();
				din.close();
				dos.close();
				keyScanner.close();*/
				System.exit(0);
				break;
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		ChatClient client = new ChatClient("192.168.0.73", 5555);
		client.start();
		client.writeMsg();
	}
	
}
