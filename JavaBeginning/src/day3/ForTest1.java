package day3;

import java.util.Scanner;

public class ForTest1 {
	public static void main(String[] args)
	{
		System.out.println("�� ���� �Է¹޾� �� ������ ������ ���� ����մϴ�.");
		
		Scanner input = new Scanner(System.in);
		System.out.print("ù ��° ���ڸ� �Է����ּ���: ");
		int a = input.nextInt();
		System.out.print("�� ��° ���ڸ� �Է����ּ���: ");
		int b = input.nextInt();
		
		if (a>b)
		{
			int i = b, sum =0;
			for (i=1; i <= a ; ++i)
			{
				sum = sum + i;
			}
			System.out.println(b+"���� "+a+"������ ����" + sum + "�Դϴ�.");
		}
		else if (a<=b)
		{
			int i = a, sum =0;
			for (i=1; i <= b ; ++i)
			{
				sum = sum + i;
			}
			System.out.println(a+"���� "+b+"������ ����" + sum + "�Դϴ�.");			
		}

//		int i, sum =0;
//		for (i=1; i <= 10 ; ++i)
//		{
//			sum = sum + i;
//		}
//		System.out.println("1���� 10������ ����" + sum + "�Դϴ�.");
	}

}
