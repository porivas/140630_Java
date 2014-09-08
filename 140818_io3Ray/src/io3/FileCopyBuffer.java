package io3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyBuffer {

	public static void main(String[] args)throws Exception {
		
		long start = System.currentTimeMillis();
		
		InputStream in = 
				new FileInputStream("C:\\zzz\\sample.pdf");
		OutputStream out=
				new FileOutputStream("C:\\zzz\\copySample.pdf");
		
		byte[] buffer = new byte[1024*8];
		
		while(true){
			int count = in.read(buffer);
			//System.out.println(count);
			if(count == -1){
				break;
			}
			out.write(buffer,0,count);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
	}
}




























