package date20140731;

import java.util.Scanner;

public class YearTypeCheck {
	public static void main(String[] args) {
//		System.out.println("Hello World");
		Scanner scanner = new Scanner (System.in);
		System.out.println("Input Number");
		int userInput = scanner.nextInt();
		
		if (userInput % 400 == 0){
			System.out.println("�����Դϴ�.");
		}
		else if (userInput % 100 == 0){
			System.out.println("����Դϴ�.");
		}
		else if (userInput % 4 == 0)
		{
			System.out.println("�����Դϴ�.");
		}
		else{
			System.out.println("����Դϴ�.");
		}
		
	}

}
