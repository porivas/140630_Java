package http2;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Mp3Server {
	
	private ServerSocket serverSocket;
	
	
	public Mp3Server(int port) throws Exception{
		this.serverSocket = new ServerSocket(port);
		System.out.println("ready............");
		readyAgent();
		mainLoop();
	}

	public void readyAgent(){
		
		//agentMap.put("/list", new ListAgentlet());
	}
	
	public void mainLoop()throws Exception{
		
		ServerSocket server = this.serverSocket;
		
		while(true){
			
			Socket socket = server.accept();
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			try{
				Agentlet agent = null;
				RequestInputStream request = new RequestInputStream(in);
				ResponseOutputStream response = new ResponseOutputStream(out,new ByteArrayOutputStream());
				
				if(request.getExt().equals("htm") == false){
					
					agent = new StrictAgentlet();
				}
				agent.doJob(request, response);
				
				response.getBos().writeTo(response.getOut());
				
			}catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try{ in.close(); }catch(Exception e){}				
				try{ out.close(); }catch(Exception e){}
				try{ socket.close(); }catch(Exception e){}
			}
		}
		
		//this.serverSocket.close();
		
	}
	


	public static void main(String[] args) throws Exception{
	
		Mp3Server server = new Mp3Server(5555);
	}
}


















