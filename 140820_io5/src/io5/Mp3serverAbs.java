package io5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Mp3serverAbs {
	
	ServerSocket serverSocket;
	protected DataInputStream dis;
	protected DataOutputStream dos;
	protected FileOutputStream fos;
	protected FileInputStream fis;
	protected Socket clientSocket;

	public Mp3serverAbs() {
		super();
	}

	public void connectUser() throws Exception {
		this.serverSocket = new ServerSocket(5555);
		System.out.println("ready.......");
		clientSocket = this.serverSocket.accept();
		System.out.println("클라이언트가 접속했습니다.");
		this.dis = new DataInputStream(clientSocket.getInputStream());
		this.dos = new DataOutputStream(clientSocket.getOutputStream());

	}
	
	public void closeAll() throws Exception{
		dos.close();
		dis.close();
		clientSocket.close();
		serverSocket.close();
	}
	
}