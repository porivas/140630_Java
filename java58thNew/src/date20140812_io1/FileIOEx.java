package date20140812_io1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileIOEx {
	
	public static void main(String[] args) throws Exception{
		//����ã��
		String urlStr = "http://postfiles11.naver.net/20130725_154/tubetint_1374755521256hzvRJ_JPEG/20090804_02500118090264_01L.jpg?type=w3";
		InputStream in = new URL(urlStr).openStream();
//		InputStream in = new FileInputStream("C:\\zzz\\smile.jpg");
		OutputStream out = new FileOutputStream("C:\\zzz\\copy7.jpg");
		System.out.println(in);
		
		while(true){
			//�Ѹ�� ���� �Ѹ���� 1 byte�� ������
			int data = in.read();
			System.out.println(data);
			
			if (data == -1){break;}
			
			out.write(data);
			
		}
		
		
		
	}

}
