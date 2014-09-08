package thread1;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultiServer1 {

	private ServerSocket serverSocket;
	private Map<String, String> ipMap;
	
	public MultiServer1()throws Exception{
		
		ipMap = new HashMap<String, String>();
		
		ipMap.put("ph", "192.168.0.46");
		ipMap.put("yh", "192.168.0.46");
		ipMap.put("yc", "192.168.0.46");
		
		serverSocket = new ServerSocket(5555);
		
	}
	
	public void waitClient(){
		
		while(true){
			try{
				System.out.println("´ë±âÁß");
				Socket socket = serverSocket.accept();
				Scanner scanner = new Scanner(socket.getInputStream());
				
				//ph|yh|¹ä¸Ô¾ú³Ä?\n
				String userMsg = scanner.nextLine();
				String[] msgArr = userMsg.split("\\|");
				
				String targetIp = ipMap.get(msgArr[1]);
				
				Socket clientSocket = new Socket(targetIp, 5554);
				OutputStream clientOut = clientSocket.getOutputStream();
				clientOut.write( (userMsg+"\n").getBytes());
				clientOut.flush();
				
				clientOut.close();
				clientSocket.close();
				scanner.close();
				socket.close();
				
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				
			}//end finally
		}//end while
	}//end waitClient
	
	public static void main(String[] args)throws Exception {
	
		MultiServer1 server = new MultiServer1();
		server.waitClient();
	}
}















