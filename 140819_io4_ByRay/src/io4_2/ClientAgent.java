package io4_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// 추상클래스. 반복되는 코드 줄이려고. 
public abstract class ClientAgent {
	
	// 지역변수선언. 
	private String ip;
	private int port;
	protected Socket socket;
	protected DataInputStream din;
	protected DataOutputStream dos;
	
	// 생성자. 객체생성제한. 
	public ClientAgent(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}
	
	// 최종 조합
	public final void doExecute()throws Exception{
		try{
			connect();
			sendMsg();
			receiveMsg();
		}finally{
			closeAll();
		}
	}

	// 소켓연결하고, in, out 해주기.
	private void connect() throws Exception {
		this.socket = new Socket(this.ip, this.port);
		this.din = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
	}
	
	// 추상메소드. 거의 같은 기능이지만 약간만 다른 부분을 구현해주기 위해서. 
	protected abstract void sendMsg()throws Exception;
	// 추상메소드. 거의 같은 기능이지만 약간만 다른 부분을 구현해주기 위해서. 
	protected abstract void receiveMsg()throws Exception;

	//
	private void closeAll() {
		// 열려있는 소켓과 InputStream, OutputStream을 역순으로 닫는다. 
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

