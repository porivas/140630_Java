package io3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyBuffer {
	public static void main(String[] args) throws Exception {
		System.out.println("버퍼메인시작");
		long start = System.currentTimeMillis();
		InputStream in = new FileInputStream("C:\\zzz\\testPdf.pdf");
		OutputStream out = new FileOutputStream("C:\\zzz\\testPdf.pdf");
		byte[] buffer = new byte[1024*8];
		
		while(true){
			int count = in.read(buffer);
			System.out.println(count);
			if(count == -1){
				break;
			}
			out.write(buffer,0,count);

		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);


	}

}
