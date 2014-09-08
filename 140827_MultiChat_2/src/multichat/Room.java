package multichat;

import java.util.Hashtable;
import java.util.Map;


public class Room {

	private Hashtable<String, ChatAgent> members;
	private String roomName;
	
	public Room(String roomName) {
		this.roomName = roomName;
		this.members = new Hashtable<String, ChatAgent>();
	}
	
	public Hashtable<String, ChatAgent> getMembers() {
		return members;
	}

	public void setMembers(Hashtable<String, ChatAgent> members) {
		this.members = members;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	//방에 새로 멤버 추가할때
	public void addMember(String nickName, ChatAgent agent){
		System.out.println("addMember : "+this.roomName);
		agent.setRoomName(this.roomName);
		members.put(nickName, agent);
	}
	
	//방에서 사라질때
	public void removeMember(String nickName){
		members.remove(nickName);
		System.out.println(members.keySet().toString());
	}
	
	public ChatAgent findByNickname(String nickName){
		return members.get(nickName);
	}
	

	
	
	
}
