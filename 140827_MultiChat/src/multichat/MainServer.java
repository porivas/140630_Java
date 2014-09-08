package multichat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

public class MainServer {

   private ServerSocket server;
   private Hashtable<String, ChatAgent> agentList;
   //private List<ChatAgent> agentList;

   public MainServer(int port) throws Exception {

      this.server = new ServerSocket(port);
      //this.agentList = new ArrayList<ChatAgent>();
      this.agentList = new Hashtable<String, ChatAgent>();
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
   
   //접속한 클라이언트에게 닉네임을 보내라고 요청한다.
   public boolean resultNick(String nick){
      System.out.println(agentList.containsKey(nick));
      return agentList.containsKey(nick);
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
      
      if(!(this.resultNick(nickName))){
         agent.setNickName(nickName);
         agentList.put(nickName, agent);
         this.broadcast(nickName + "님이 입장하셨습니다.", agent.getNickName());
         return;
      }
      agent.writeMsg("사용중인 닉네임입니다. 다시입력해주세요");
      
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
      agent.closeAgent();
      agentList.remove("nickName");
   }


   public void makeRoom() {
      // TODO Auto-generated method stub
      
   }
}