package day3;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] a1)
	{
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		int a, b, c, sum;
		System.out.println("---- ���� ��� ���� ---- ");
		System.out.print("�����ڵ带 �Է����ּ���: ");
		int sexcode = input.nextInt();
		if (sexcode == 1 || sexcode == 3 )
			System.out.println("���� ������ �Դϴ�.");	
		else if (sexcode == 2 || sexcode == 4)
			System.out.println("���� ������ �Դϴ�.");	
		else
			System.out.println("�ܰ��� Ư������ ������ �Դϴ�.");	
		System.out.print("ù ��° ������ ������ �Է����ּ���:");
		a = input.nextInt();		// Scanner �� �Է��� Tab, Enter, Space
		System.out.print("�� ��° ������ ������ �Է����ּ���:");
		b = input.nextInt();
		System.out.print("�� ��° ������ ������ �Է����ּ���:");
		c = input.nextInt();
		System.out.println("--------------- ");

		if (a < 60)
		{
			System.out.println("�����Դϴ�.");	
			System.out.println("ù ��° ������ ������ "+(60-a)+"�� ���ڶ��ϴ�.");	
		}
		else if (b<60)
		{
			System.out.println("�����Դϴ�.");	
			System.out.println("�� ��° ������ ������ "+(60-b)+"�� ���ڶ��ϴ�.");	
		}
		else if (c<60)
		{
			System.out.println("�����Դϴ�.");	
			System.out.println("�� ��° ������ ������ "+(60-c)+"�� ���ڶ��ϴ�.");	
		}
		else
			System.out.println("�հ��Դϴ�.");	
		System.out.println("--------------- ");
		sum = a+b+c;
		double avg = sum / 3.0;  // ���⿡�� 3�� ������ int�� 2���� ����̶� �Ҽ��� ǥ���� �ȵȴ�. 
		System.out.println("�������� ���������"+avg+"�Դϴ�");
		System.out.printf("�ݿø��Ͽ� �������� ����� %.2f �Դϴ�.\n", avg);
		// %�ڸ��� �ڿ� , �ڿ� ���� avg ������ �־��. .2f �� �Ҽ��� ��°�ڸ� �ݿø� 
//		String ok = (avg >= 60.0) ? "�հ��Դϴ�." : "���հ��Դϴ�.";
		if (avg >= 90)
		{
			System.out.println("�����մϴ�.");
			System.out.println("A������ ����ϼ̽��ϴ�.");

		}
		else if (avg >= 80)
			System.out.println("B������ ����ϼ̽��ϴ�.");
		else if (avg >= 70)
			System.out.println("C������ ����ϼ̽��ϴ�.");
		else if (avg >= 60)
			System.out.println("D������ ����ϼ̽��ϴ�.");	
		else
			System.out.println("F������ ����ϼ̽��ϴ�. ������ϼ���.");
		if (avg < 90)
		{
			System.out.println("�й��ϼ��� �� ��");
			double remain = 90.00 - (double)(avg);
			System.out.printf("A�������� %.2f�� ���ҽ��ϴ�.", remain);
		}
		


		
//		String d;
//		d = input2.next();
//		System.out.println("d�� "+d+"�Դϴ�.");

	}

}
