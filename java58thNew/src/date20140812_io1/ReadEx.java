package date20140812_io1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ReadEx {
	
	public static void main(String[] args) throws Exception {
		InputStream in = new FileInputStream("C:\\zzz\\memo.txt");
//		String urlStr = "http://www.naver.com";
//		InputStream in = new URL(urlStr).openStream();
		Scanner inScanner = new Scanner(in,"UTF-8");
		while (true){
			try{
				System.out.println(inScanner.nextLine());
			}
			catch(Exception e){
				break;
			}
		}
				
	}
	

}
