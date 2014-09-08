package day4;

import java.util.Scanner;

public class WhileTest2 {
	public static void main(String[] args)
	{
		System.out.println("구구단을 계산합니다.");
		System.out.println();

//		System.out.print("원하는 구구단 숫자를 입력하세요: ");
//		Scanner input = new Scanner(System.in);
//		int num1 = input.nextInt();
		
//		int x;
//		int x = num1;
//		int y = 1;
/*		while (y<=9)
		{
			System.out.println(x+"*"+y+"="+x*y);
			y++;
		}
*/
/*
		for (int x = 1; x <= 9; x++)
		{
			System.out.printf("%d단 시작합니다.\n",x);

			for (int y=1; y<=9; y++)
			{
				System.out.println(x+"*"+y+"="+x*y);
			}

		}
*/
		for (int i = 1; i <= 9; i = i+3)
		{
			System.out.println(i + "단" + "\t" + (i+1)+"단"+"\t"+(i+2)+"단");
			for (int j =1; j<=9; j++)
			{
				System.out.print(i+"*"+j+"="+ i*j);
				System.out.print("\t");
				System.out.print((i+1)+"*"+j+"="+ (i+1)*j);
				System.out.print("\t");
				System.out.print((i+2)+"*"+j+"="+ (i+2)*j);
				System.out.println();
			}
			System.out.println();

		}
	}

}
