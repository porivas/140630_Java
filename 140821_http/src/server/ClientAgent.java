package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public abstract class ClientAgent {
	private String ip;
	private int port;
	protected Socket socket;
	protected  DataInputStream dis;
	protected  DataOutputStream dos;

	
	//»ý¼ºÀÚ
	public ClientAgent(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}
	public final void doExecute()throws Exception{
		
		try{
			connect();
			sendMsg();
			recieveMsg();
			

		}finally{
			closeAll();
		}
	}

	
	public void connect () throws Exception{
		
		this.socket = new Socket( this.ip, this.port);
		this.dis = new DataInputStream(socket.getInputStream());
		this.dos = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public abstract void sendMsg() throws Exception;
	
	public abstract void recieveMsg()throws Exception;
	
	
	
	public void closeAll(){
		
		if(this.dis != null){
			try{ dis.close(); }catch(Exception e){}
		}
		if(this.dos != null){
			try{ dos.close(); }catch(Exception e){}
		}
		if(this.socket != null){
			try{ this.socket.close(); }catch(Exception e){}
		}
		
	}

}
