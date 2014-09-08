package date20140812_io1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class StringEx {

	public static void main(String[] args) throws Exception {
		String name = "C:\\zzz\\memo.txt";
		Scanner KeyScanner = new Scanner(System.in);
		OutputStream out = new FileOutputStream(name, true);
		while (true){
			System.out.println("메시지를 입력해주세요");
			String msg = KeyScanner.nextLine()+"\n";
			if (msg.equals("EXIT"+"\n")){
				break;
			}
			byte[] msgBytes = msg.getBytes("UTF-8");
			out.write(msgBytes);
		}
		
	}
}
