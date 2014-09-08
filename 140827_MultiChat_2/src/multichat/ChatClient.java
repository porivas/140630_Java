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
	 * ChatClient Ŭ���� ������ �κ� �Ű������� ip/port�� �Է¹޾� ���� ����
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
	 * Thread ���۽�ų �κ� Override
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
						System.out.println("����ڰ� �����Ǿ����ϴ�.");
					} else {
						System.out.println("�г����� �Է��ϼ���(SET_NICK:�ϰ�����̸�)");
					}
					break;
				case "RE_ROOM_MAKE":
					if(msgArr[1].equals("N")){
						System.out.println("���̸��� �Է��ϼ���(ROOM_NAME:���̸�)");
					} else {
						System.out.println("���� ����������ϴ�.");
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
			
			//System.out.println("�Է��ϼ���");
			String msg = keyScanner.nextLine();
			dos.writeUTF(msg);
			dos.flush();
			if (msg.matches(".*EXIT.*")) {
				System.out.println("�����մϴ�.");
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
