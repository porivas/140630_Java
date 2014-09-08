package io3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new FileInputStream("C:\\zzz\\sample.pdf");
			out = new FileOutputStream("C:\\zzz\\copySample.pdf");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(in != null){try{in.close();	}catch(Exception ee){}}
			if(out !=null){try{out.close(); }catch(Exception ee){}}
		}

	}
}
