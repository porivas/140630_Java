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
		roomMap.put("대기실", new Room("대기실"));
		this.waitClient();
	}

	private void waitClient() {
		
		while(true){
			try {
				System.out.println("대기중");
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
		
		//값만 뽑아내는 법.
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
	//새로운 클라이언트가 입장했을때 수행하는 작업
	public void newClient(ChatAgent agent) throws Exception{
		//start();
		
		String nickName = agent.reNick();
		if(!(this.resultNick(nickName))){
			agent.setNickName(nickName);
			agentList.put(nickName, agent);
			this.broadcast(nickName + "님이 입장하셨습니다.", agent.getNickName());
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
	
	//어떤 작업을 요청하는지 파싱하거.
	public String[] parsingMsg(String msg){
		String[] msgArr = msg.split(":");
		
		return msgArr;
	}
	
	public static void main(String[] args) throws Exception {
		
		MainServer server = new MainServer(5555);
	}

	//닉네임 설정
	public void setNick(String nickName, ChatAgent agent) throws Exception {
		
			agent.setNickName(nickName);
			agentList.put(nickName, agent);
			roomMap.get("대기실").addMember(nickName, agent);
			this.broadcast(nickName + "님이 입장하셨습니다.", agent.getNickName());
		
	}

	//모든 사람에게 메시지 보내기
	public void all(String nickName, String msg) throws Exception {
		
		Collection<ChatAgent> values = agentList.values();
		
		//값만 뽑아내는 법.
		for (ChatAgent chatAgent : values) {
			try {
				chatAgent.writeMsg(nickName + "| " + msg);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				String errorNick = chatAgent.getNickName();
				this.all(errorNick, errorNick+"님이 통신상문제로 퇴장셨습니다.");
				chatAgent.closeAgent();
				agentList.remove(errorNick);
			}
		}
	}

	//귓속말 보내기
	public void secret(String sender, String reciever, String msg) throws Exception {
		ChatAgent recievedAgent = agentList.get(reciever);
		try {
		recievedAgent.writeMsg(sender + "|(귓속말)" + msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			String errorNick = recievedAgent.getNickName();
			this.all(errorNick, errorNick+"님이 통신상문제로 퇴장셨습니다.");
			recievedAgent.closeAgent();
			agentList.remove(errorNick);
		}
	}

	//채팅방 나가기
	public void exit(String nickName, ChatAgent agent) throws Exception {
		all(nickName, nickName+"님이 퇴장하셨습니다.");
		
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
		System.out.println("들어가고싶은방 : " + agent.getRoomName());
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
		
		//키로 값을 뽑아내는 법.
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
	
	// INVITE:초대자:초대받은사람:초대하고싶은방이름
	public void inviteRoom(String host, String guest, String roomName) throws Exception {
		// TODO Auto-generated method stub
		ChatAgent guestAgent = agentList.get(guest);
		roomMap.get(guestAgent.getRoomName()).removeMember(guest);
		//guestAgent.setRoomName(roomName);
		System.out.println("초대받은사람" + guestAgent.getName());
		(roomMap.get(roomName)).addMember(guest, guestAgent);	
	}
	
	public void roomMsg(ChatAgent chat, String msg) throws Exception {
		// RoomMap에 있는 Room을 추출. 방제목 기준으로 
		// Room 에서 Hashtable<String, ChatAgent> members
		
		// 현재 방에 있는 사용자 목록을 해쉬테이블에 저장 
		Hashtable<String, ChatAgent> userArr = roomMap.get(chat.getRoomName()).getMembers();
		Collection<ChatAgent> agentValues = userArr.values();
		for (ChatAgent chatAgent : agentValues) {
			try {
				chatAgent.writeMsg(chat.getNickName() + "| " + msg);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				String errorNick = chatAgent.getNickName();
				this.all(errorNick, errorNick+"님이 통신상문제로 퇴장셨습니다.");
				chatAgent.closeAgent();
				agentList.remove(errorNick);
			}
		}
		
		//모든 사람에게 메시지 보내기
		/*public void all(String nickName, String msg) throws Exception {
			
			Collection<ChatAgent> values = agentList.values();
			
			//값만 뽑아내는 법.
			for (ChatAgent chatAgent : values) {
				try {
					chatAgent.writeMsg(nickName + "| " + msg);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					String errorNick = chatAgent.getNickName();
					this.all(errorNick, errorNick+"님이 통신상문제로 퇴장셨습니다.");
					chatAgent.closeAgent();
					agentList.remove(errorNick);
				}
			}
		}*/
		
	}
	
}
