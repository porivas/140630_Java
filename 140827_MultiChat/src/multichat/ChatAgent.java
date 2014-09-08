package multichat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ChatAgent extends Thread{
   
   private Socket socket;
   private DataInputStream din;
   private DataOutputStream dos;
   private MainServer mainServer;
   private String nickName;
   
   public ChatAgent(Socket socket, MainServer main) throws Exception{
      
      this.socket = socket;
      this.din = new DataInputStream(socket.getInputStream());
      this.dos = new DataOutputStream(socket.getOutputStream());
      this.mainServer = main;
   }

   @Override
   public void run() {
      try {
         readMsg();
      } catch (Exception e) {
         e.printStackTrace();
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
      
      din.close();
      dos.close();
      socket.close();
   }
   
   public void reNick() throws Exception{
         //dos.writeUTF("닉네임을 입력해주세요(SET_NICK:하고싶은닉네임)"); 
         dos.writeUTF("RE_NICK"); 
         
   }
   
   public void parsingMsg(String msg) throws Exception {
      String[] msgArr = msg.split(":");
      switch(msgArr[0]){
         case "START" :
            this.reNick();
            break;
         case "SET_NICK" : 
            mainServer.setNick(msgArr[1], this);
            break;
         case "ALL" : 
            mainServer.all(msgArr[1], msgArr[2]);
            break;
         case "SECRET" : 
            mainServer.secret(msgArr[1], msgArr[2], msgArr[3]);
            break;
         case "EXIT" :
            mainServer.exit(msgArr[1], this);
            break;
         case "MAKE_ROOM" : 
            mainServer.makeRoom();
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
   
   
   

}