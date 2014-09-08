package io4_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// �߻�Ŭ����. �ݺ��Ǵ� �ڵ� ���̷���. 
public abstract class ClientAgent {
	
	// ������������. 
	private String ip;
	private int port;
	protected Socket socket;
	protected DataInputStream din;
	protected DataOutputStream dos;
	
	// ������. ��ü��������. 
	public ClientAgent(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}
	
	// ���� ����
	public final void doExecute()throws Exception{
		try{
			connect();
			sendMsg();
			receiveMsg();
		}finally{
			closeAll();
		}
	}

	// ���Ͽ����ϰ�, in, out ���ֱ�.
	private void connect() throws Exception {
		this.socket = new Socket(this.ip, this.port);
		this.din = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
	}
	
	// �߻�޼ҵ�. ���� ���� ��������� �ణ�� �ٸ� �κ��� �������ֱ� ���ؼ�. 
	protected abstract void sendMsg()throws Exception;
	// �߻�޼ҵ�. ���� ���� ��������� �ణ�� �ٸ� �κ��� �������ֱ� ���ؼ�. 
	protected abstract void receiveMsg()throws Exception;

	//
	private void closeAll() {
		// �����ִ� ���ϰ� InputStream, OutputStream�� �������� �ݴ´�. 
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

