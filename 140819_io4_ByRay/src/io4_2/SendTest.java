package io4_2;

import java.io.FileOutputStream;

public class SendTest extends ClientAgent {

	public SendTest(String ip, int port) {
		super(ip, port);
	}
	@Override
	protected void sendMsg() throws Exception {
		// TODO Auto-generated method stub
		dos.writeUTF("aaa.mp3");
		dos.flush();
	}
	@Override
	protected void receiveMsg() throws Exception {
		// TODO Auto-generated method stub
		String title = din.readUTF();

		FileOutputStream fos 
		= new FileOutputStream("C:\\zzz\\copy_" +title);

		byte[] buffer = new byte[1024*8];

		while(true){

			int count = din.read(buffer);
			if(count == -1){ break;}
			fos.write(buffer,0,count);
		}
	}

	public static void main(String[] args) throws Exception {

		SendTest obj = new SendTest("127.0.0.1",5555);
		obj.doExecute();
	}

}

