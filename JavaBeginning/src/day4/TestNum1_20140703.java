package day4;

import java.util.Scanner;

public class TestNum1_20140703 {
	public static void main(String[] args)
	{
		while(true)
		{
		Scanner input = new Scanner(System.in);
		
		System.out.print("첫 번째 정수입력: ");
		int num1 = input.nextInt();
		System.out.print("두 번째 정수입력: ");
		int num2 = input.nextInt();

		if (num1 > num2)
		{
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		int sum = 0;
		
		for (int i = num1; i <= num2; i++ )
		{
			sum = sum + i;	

		}

		System.out.print("답: ");
		System.out.println(sum);
	}
	}

}
