package date20140812;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class URLIoAndDo {
	
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://c.ask.nate.com/imgs/qrsi.php/11950413/21690059/0/1/A/gain.jpg");
		InputStream in = url.openStream();
		OutputStream out = new FileOutputStream("gainFace.png");
		byte[] buffer = new byte[1024];
		while(true) // 파일 크기가 얼마인지 모르니까
		{
			int count = in.read(buffer);
			if(count ==-1){ break;}
			out.write(buffer, 0, count);
			
		}
		in.close();
		out.close();
		System.out.println("파일을 가져왔습니다. ");
	}
	
}
