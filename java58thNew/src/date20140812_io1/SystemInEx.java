package date20140812_io1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class SystemInEx {
	public static void main(String[] args) throws Exception {
		
		InputStream in = System.in;
//		String fileName = System.currentTimeMillis()+".txt";
		String fileName = "20140812_3.txt";

		OutputStream out = new FileOutputStream("C:\\zzz\\"+fileName, true);
		
		System.out.println("�޸��� ���α׷� v1 \n�޼����� �Է��ϼ���");
		while(true) {
			int data = in.read();
			out.write(data);
//			out.write(10);
			System.out.println(data);
			if(data == 10){break;}
		}
		
		
		
	}
}
