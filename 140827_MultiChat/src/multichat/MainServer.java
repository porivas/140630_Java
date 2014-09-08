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
   
   //������ Ŭ���̾�Ʈ���� �г����� ������� ��û�Ѵ�.
   public boolean resultNick(String nick){
      System.out.println(agentList.containsKey(nick));
      return agentList.containsKey(nick);
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
      
      if(!(this.resultNick(nickName))){
         agent.setNickName(nickName);
         agentList.put(nickName, agent);
         this.broadcast(nickName + "���� �����ϼ̽��ϴ�.", agent.getNickName());
         return;
      }
      agent.writeMsg("������� �г����Դϴ�. �ٽ��Է����ּ���");
      
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
      agent.closeAgent();
      agentList.remove("nickName");
   }


   public void makeRoom() {
      // TODO Auto-generated method stub
      
   }
}