package day4;

import java.util.Scanner;

public class ForTest2 {
	public static void main (String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("�־��� ���ڰ� Ȧ���� ���� ���մϴ�. ");
		System.out.print("ù ��° ���ڸ� �Է��ϼ���adg: ");
		int num1 = input.nextInt();
		System.out.print("�� ��° ���ڸ� �Է��ϼ���: ");
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
//		System.out.println("�־��� ���ڰ� Ȧ���� ���� "+ sum +"�Դϴ�.");
		System.out.printf("%d���� %d ������ Ȧ���� ���� %d�̰� ������ %d�Դϴ�.", num1, num2, sum, count);

		
	}

}
