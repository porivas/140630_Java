package day3;

import java.util.Scanner;

public class ForTest1 {
	public static void main(String[] args)
	{
		System.out.println("두 수를 입력받아 그 사이의 숫자의 합을 계산합니다.");
		
		Scanner input = new Scanner(System.in);
		System.out.print("첫 번째 숫자를 입력해주세요: ");
		int a = input.nextInt();
		System.out.print("두 번째 숫자를 입력해주세요: ");
		int b = input.nextInt();
		
		if (a>b)
		{
			int i = b, sum =0;
			for (i=1; i <= a ; ++i)
			{
				sum = sum + i;
			}
			System.out.println(b+"부터 "+a+"까지의 합은" + sum + "입니다.");
		}
		else if (a<=b)
		{
			int i = a, sum =0;
			for (i=1; i <= b ; ++i)
			{
				sum = sum + i;
			}
			System.out.println(a+"부터 "+b+"까지의 합은" + sum + "입니다.");			
		}

//		int i, sum =0;
//		for (i=1; i <= 10 ; ++i)
//		{
//			sum = sum + i;
//		}
//		System.out.println("1부터 10까지의 합은" + sum + "입니다.");
	}

}
