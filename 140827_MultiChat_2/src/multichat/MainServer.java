package multichat;

import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class MainServer {

	private ServerSocket server;
	private Hashtable<String, ChatAgent> agentList;
	
	private Map<String, Room> roomMap; 
	

	public MainServer(int port) throws Exception {

		this.server = new ServerSocket(port);
		//this.agentList = new ArrayList<ChatAgent>();
		this.agentList = new Hashtable<String, ChatAgent>();
		this.roomMap = new Hashtable<String, Room>();
		roomMap.put("����", new Room("����"));
		this.waitClient();
	}

	private void waitClient() {
		
		while(true){
			try {
				System.out.println("�����");
				Socket socket = server.accept();
				ChatAgent agent = new ChatAgent(socket, this);
				agent.start();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	public synchronized void broadcast(String msg, String nickName){
		
		//this.parsingMsg(msg);
		
		Collection<ChatAgent> values = agentList.values();
		
		//���� �̾Ƴ��� ��.
		for (ChatAgent chatAgent : values) {
			try {
				chatAgent.writeMsg(nickName + "| " + msg);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				agentList.remove(chatAgent);
				// TODO: handle exception
			}
		}
		
		/*
		for(ChatAgent chatAgent : agentList){
			try {
				chatAgent.writeMsg(msg);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				agentList.remove(chatAgent);
				// TODO: handle exception
			}
		}
		*/
	}
	
	/*
	//���ο� Ŭ���̾�Ʈ�� ���������� �����ϴ� �۾�
	public void newClient(ChatAgent agent) throws Exception{
		//start();
		
		String nickName = agent.reNick();
		if(!(this.resultNick(nickName))){
			agent.setNickName(nickName);
			agentList.put(nickName, agent);
			this.broadcast(nickName + "���� �����ϼ̽��ϴ�.", agent.getNickName());
			return;
		}
		this.newClient(agent);
	}
	*/
	
	public boolean checkNick(String nick){
		System.out.println(agentList.containsKey(nick));
		return agentList.containsKey(nick);
	}
	
	public boolean checkRoomName(String roomName) {
		return roomMap.containsKey(roomName);
	}
	
	//� �۾��� ��û�ϴ��� �Ľ��ϰ�.
	public String[] parsingMsg(String msg){
		String[] msgArr = msg.split(":");
		
		return msgArr;
	}
	
	public static void main(String[] args) throws Exception {
		
		MainServer server = new MainServer(5555);
	}

	//�г��� ����
	public void setNick(String nickName, ChatAgent agent) throws Exception {
		
			agent.setNickName(nickName);
			agentList.put(nickName, agent);
			roomMap.get("����").addMember(nickName, agent);
			this.broadcast(nickName + "���� �����ϼ̽��ϴ�.", agent.getNickName());
		
	}

	//��� ������� �޽��� ������
	public void all(String nickName, String msg) throws Exception {
		
		Collection<ChatAgent> values = agentList.values();
		
		//���� �̾Ƴ��� ��.
		for (ChatAgent chatAgent : values) {
			try {
				chatAgent.writeMsg(nickName + "| " + msg);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				String errorNick = chatAgent.getNickName();
				this.all(errorNick, errorNick+"���� ��Ż����� ����̽��ϴ�.");
				chatAgent.closeAgent();
				agentList.remove(errorNick);
			}
		}
	}

	//�ӼӸ� ������
	public void secret(String sender, String reciever, String msg) throws Exception {
		ChatAgent recievedAgent = agentList.get(reciever);
		try {
		recievedAgent.writeMsg(sender + "|(�ӼӸ�)" + msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			String errorNick = recievedAgent.getNickName();
			this.all(errorNick, errorNick+"���� ��Ż����� ����̽��ϴ�.");
			recievedAgent.closeAgent();
			agentList.remove(errorNick);
		}
	}

	//ä�ù� ������
	public void exit(String nickName, ChatAgent agent) throws Exception {
		all(nickName, nickName+"���� �����ϼ̽��ϴ�.");
		
		//agent.closeAgent();
		roomMap.get(agent.getRoomName()).removeMember(nickName);;
		agentList.remove(nickName);
	}


	public void makeRoom(String roomName, ChatAgent agent) {
		// TODO Auto-generated method stub
		String nickName = agent.getNickName();
		roomMap.put(roomName, new Room(roomName));
		roomMap.get(agent.getRoomName()).removeMember(nickName);
		roomMap.get(roomName).addMember(nickName, agent);	
	}

	public void joinRoom(String nickName, String roomName) {
		// TODO Auto-generated method stub
		ChatAgent agent = agentList.get(nickName);
		System.out.println("��������� : " + agent.getRoomName());
		roomMap.get(agent.getRoomName()).removeMember(nickName);
		roomMap.get(roomName).addMember(nickName, agent);	
	}
/*	
	public String findValues(){

	}
	*/

	public String showRoomList() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		
		//Ű�� ���� �̾Ƴ��� ��.
		Iterator<String> room = roomMap.keySet().iterator();
		
		while(room.hasNext()){
			String key = room.next();
			builder.append(key + "|");
		}
		
		return builder.toString();
	}

	public void showRoomUser() {
		// TODO Auto-generated method stub
		
	}

	public void showAllList() {
		// TODO Auto-generated method stub
		
	}
	
	// INVITE:�ʴ���:�ʴ�������:�ʴ��ϰ�������̸�
	public void inviteRoom(String host, String guest, String roomName) throws Exception {
		// TODO Auto-generated method stub
		ChatAgent guestAgent = agentList.get(guest);
		roomMap.get(guestAgent.getRoomName()).removeMember(guest);
		//guestAgent.setRoomName(roomName);
		System.out.println("�ʴ�������" + guestAgent.getName());
		(roomMap.get(roomName)).addMember(guest, guestAgent);	
	}
	
	public void roomMsg(ChatAgent chat, String msg) throws Exception {
		// RoomMap�� �ִ� Room�� ����. ������ �������� 
		// Room ���� Hashtable<String, ChatAgent> members
		
		// ���� �濡 �ִ� ����� ����� �ؽ����̺� ���� 
		Hashtable<String, ChatAgent> userArr = roomMap.get(chat.getRoomName()).getMembers();
		Collection<ChatAgent> agentValues = userArr.values();
		for (ChatAgent chatAgent : agentValues) {
			try {
				chatAgent.writeMsg(chat.getNickName() + "| " + msg);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				String errorNick = chatAgent.getNickName();
				this.all(errorNick, errorNick+"���� ��Ż����� ����̽��ϴ�.");
				chatAgent.closeAgent();
				agentList.remove(errorNick);
			}
		}
		
		//��� ������� �޽��� ������
		/*public void all(String nickName, String msg) throws Exception {
			
			Collection<ChatAgent> values = agentList.values();
			
			//���� �̾Ƴ��� ��.
			for (ChatAgent chatAgent : values) {
				try {
					chatAgent.writeMsg(nickName + "| " + msg);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					String errorNick = chatAgent.getNickName();
					this.all(errorNick, errorNick+"���� ��Ż����� ����̽��ϴ�.");
					chatAgent.closeAgent();
					agentList.remove(errorNick);
				}
			}
		}*/
		
	}
	
}
