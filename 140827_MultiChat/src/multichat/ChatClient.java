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
   
   public ChatClient(String ip, int port) throws Exception {
      this.socket = new Socket(ip, port);
      this.din = new DataInputStream(this.socket.getInputStream());
      this.dos = new DataOutputStream(this.socket.getOutputStream());
      this.keyScanner = new Scanner(System.in);
   }
   
   
   
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



   public void readMsg() throws Exception {
      while(true){
         String serverMsg = din.readUTF();
         if(serverMsg.equals("RE_NICK")){
            System.out.println("닉네임을 입력해주세요(SET_NICK:하고싶은닉네임)");
         } else {
            System.out.println(serverMsg);
         }
      }
   }
   
   public void writeMsg() throws Exception {
      while(true){
         
         //System.out.println("입력하세요");
         String msg = keyScanner.nextLine();
         dos.writeUTF(msg);
         dos.flush();
      }
   }
   
   public static void main(String[] args) throws Exception {
      ChatClient client = new ChatClient("192.168.0.79", 5555);
      client.start();
      client.writeMsg();
   }
   
}