package thread1;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MtoMServer extends Thread {
	
	ServerSocket server;
	Socket socket;
	Scanner inscanner;
	Scanner keyscanner;
	OutputStream out;
	
	public MtoMServer(int port) throws Exception{
		super();
		this.server = new ServerSocket(port);
		this.keyscanner = new Scanner(System.in);
		waitClient();
		
	}

	private void waitClient() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("wait client");
		socket = this.server.accept();
		inscanner = new Scanner(socket.getInputStream());
		out = socket.getOutputStream();
	}

	public void sendMsg() throws Exception{
		while(true){
			System.out.println("보낼 메세지 입력: ");
			String myMsg  = keyscanner.nextLine()+"\n";
			out.write(myMsg.getBytes());
			out.flush();
		}
	}
	
	public void receiveMsg(){
		while(true){
			String msg = inscanner.nextLine();
			synchronized(System.out){
				System.out.println("수신 메세지: ");
				System.out.println(msg);

			}
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		receiveMsg();
	}

	public static void main(String[] args) throws Exception {
		MtoMServer mServer = new MtoMServer(5555);
		mServer.start();
		mServer.sendMsg();
	}

}
