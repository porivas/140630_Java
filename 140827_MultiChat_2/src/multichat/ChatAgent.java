package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ChatAgent extends Thread{

	private Socket socket;
	private Socket oriSocket;
	private DataInputStream din;
	private DataOutputStream dos;
	private MainServer mainServer;
	private String nickName;
	private String roomName;

	public ChatAgent(Socket socket, MainServer main) throws Exception{
		this.oriSocket = socket;
		this.socket = socket;
		this.din = new DataInputStream(socket.getInputStream());
		this.dos = new DataOutputStream(socket.getOutputStream());
		this.mainServer = main;
		this.roomName = "����";
	}

	@Override
	public void run() {
		try {
			readMsg();
		} catch (Exception e) {
			System.out.println("�������ϴ�");
			try { 
				
			} catch (Exception e1) {e1.printStackTrace();}
		}
	}

	private void readMsg() throws Exception {

		while(true){

			String msg = din.readUTF();
			this.parsingMsg(msg);
			//mainServer.broadcast(parsedMsg, this.nickName);
		}

	}

	public void writeMsg(String msg)throws Exception{

		dos.writeUTF(msg);
	}

	public void closeAgent() throws Exception {
		System.out.println("Ŭ�������");
		din.close();
		dos.close();
		socket.close();
	}

	public void reNick(String nickName) throws Exception{
		//dos.writeUTF("�г����� �Է����ּ���(SET_NICK:�ϰ�����г���)"); 
		if(mainServer.checkNick(nickName)){
			dos.writeUTF("RE_NICK:N");
		} else {
			dos.writeUTF("RE_NICK:Y");
			mainServer.setNick(nickName, this);
		}

	}

	private void reRoomName(String roomName) throws Exception {
		// TODO Auto-generated method stub
		if(mainServer.checkRoomName(roomName)){
			dos.writeUTF("RE_ROOM_MAKE:N");
		} else {
			dos.writeUTF("RE_ROOM_MAKE:Y");
			mainServer.makeRoom(roomName, this);
		}
	}

	public void parsingMsg(String msg) throws Exception {
		String[] msgArr = msg.split(":");
		switch(msgArr[0]){
		case "START" :
			dos.writeUTF("RE_NICK:N");
			break;
		case "SET_NICK" : 
			this.reNick(msgArr[1]);
			break;
		case "ALL" : 
			mainServer.all(msgArr[1], msgArr[2]);
			break;
		case "SECRET" : 
			mainServer.secret(msgArr[1], msgArr[2], msgArr[3]);
			break;
		case "EXIT" : //msgArr[1] �ڱ� �г���
			mainServer.exit(msgArr[1], this);
//			System.out.println("3....");
			closeAgent();
			break;
		case "ROOM_MAKE" : 
			this.reRoomName(msgArr[1]);
			break;
		case "ROOM_JOIN" :
			mainServer.joinRoom(msgArr[1], msgArr[2]);
			break;
		case "ROOM_INVITE" :
			mainServer.inviteRoom(msgArr[1], msgArr[2], msgArr[3]);
			break;
		case "ROOM_MSG":
			mainServer.roomMsg(this, msgArr[1]);
			break;
		case "LIST_ROOM" :
			//�� ����� �����ݴϴ�
			dos.writeUTF(mainServer.showRoomList());
			break;
		case "ROOM_USER" :
			mainServer.showRoomUser();
			break;
		case "ALL_USER" :
			//��ü ����ڸ� �����ݴϴ�. 
			mainServer.showAllList();
			break;
		default:
			mainServer.all(this.nickName, msgArr[0]);
			break;
		}
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}






}
