package io4_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public abstract class ClientAgent {
	
	private String ip;
	private int port;
	protected Socket socket;
	protected DataInputStream din;
	protected DataOutputStream dos;
	
	public ClientAgent(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public final void doExecute()throws Exception{
		
		try{
			connect();
			sendMsg();
			receiveMsg();
			
		}finally{
			closeAll();
		}
	}

	private void connect() throws Exception{
		
		this.socket = new Socket(this.ip, this.port);
		this.din = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
		
	}
	
	protected abstract void sendMsg()throws Exception;
	
	protected abstract void receiveMsg()throws Exception;
	
	
	private void closeAll() {
		
		if(this.din != null){
			try{ din.close(); }catch(Exception e){}
		}
		if(this.dos != null){
			try{ dos.close(); }catch(Exception e){}
		}
		if(this.socket != null){
			try{ this.socket.close(); }catch(Exception e){}
		}
		
	}


}






