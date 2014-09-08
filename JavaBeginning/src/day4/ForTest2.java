package day4;

import java.util.Scanner;

public class ForTest2 {
	public static void main (String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("주어진 숫자간 홀수의 합을 구합니다. ");
		System.out.print("첫 번째 숫자를 입력하세요adg: ");
		int num1 = input.nextInt();
		System.out.print("두 번째 숫자를 입력하세요: ");
		int num2 = input.nextInt();
		
		int i, sum=0, count=0, change;
		
		if (num1 > num2)
		{
			change = num2;
			num2 = num1;
			num1 = change;

		}

			for (i = num1; i<= num2; i++)
			{
				if(i % 2 == 1)
				{
					sum = sum + i;
					count++;
				}
			}
//		System.out.println("주어진 숫자간 홀수의 합은 "+ sum +"입니다.");
		System.out.printf("%d부터 %d 사이의 홀수의 합은 %d이고 개수는 %d입니다.", num1, num2, sum, count);

		
	}

}
