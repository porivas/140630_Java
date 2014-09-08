package day3;

import java.util.Scanner;

public class SwitchTest {
	public static void main (String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("지금이 몇 월인지 입력하세요:");

		int month = input.nextInt();
		
		String MtoS;
/*		switch (month)
		{
			case 12: case 1: case 2:
				MtoS = "겨울입니다.";
				break;
			case 3: case 4: case 5:
				MtoS = "봄입니다.";
				break;
			case 6: case 7: case 8:
				MtoS = "여름입니다.";
				break;
			case 9: case 10: case 11:
				MtoS = "가을입니다.";
				break;
			default:
				MtoS = "12개월 이내의 달이 아닙니다.";
		}
*/	
		if (month == 12 || month == 1 || month == 2 )
			MtoS = "겨울입니다.";
		else if (month == 3 || month == 4 || month == 5 )
			MtoS = "봄입니다.";
		else if (month == 6 || month == 7 || month == 8 )
			MtoS = "여름입니다.";
		else if (month == 9 || month == 10 || month == 11 )
			MtoS = "가을입니다.";
		else
			MtoS = "12개월 이내의 달이 아닙니다.";

		System.out.println(month+"월은 "+ MtoS);
	}


}
