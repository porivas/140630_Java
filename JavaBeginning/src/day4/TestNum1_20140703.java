package day4;

import java.util.Scanner;

public class TestNum1_20140703 {
	public static void main(String[] args)
	{
		while(true)
		{
		Scanner input = new Scanner(System.in);
		
		System.out.print("ù ��° �����Է�: ");
		int num1 = input.nextInt();
		System.out.print("�� ��° �����Է�: ");
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

		System.out.print("��: ");
		System.out.println(sum);
	}
	}

}
