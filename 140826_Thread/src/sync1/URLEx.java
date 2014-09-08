package sync1;

import java.io.InputStream;
import java.net.URL;

public class URLEx extends Thread{
	
	String path;
	URL url;
	
	
	public URLEx(String path) throws Exception {
		super();
		this.path = path;
		this.url = new URL(path);
	}
	
	public void view() throws Exception{
		byte[] buffer = new byte[1024];
		
		InputStream in = url.openStream();
		int count = in.read(buffer);
		System.out.println(count);
	}

	public void run(){
		try {
			this.view();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		for(int i = 0; i <700; i++){
			System.out.println(i);
		}
		URLEx obj = new URLEx("http://www.coupang.com/deal.pang?coupang=69158324");
		obj.start();
	}

}
