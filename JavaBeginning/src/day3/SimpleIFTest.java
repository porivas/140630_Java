package day3;

import java.util.Scanner;

public class SimpleIFTest {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
/*		System.out.print("���ڸ� �Է����ּ���: ");

		int count = input.nextInt();
		if (count<0)			// if���ο� �����ݷ� ���� �׳� if���� ����
			System.out.println(count+"��(��) �����Դϴ�.");
		else if (count > 0)
			System.out.println(count+"��(��) ����Դϴ�.");
		else
			System.out.println(count+"0�Դϴ�.");
*/
		
//		int grade = input.nextInt();
		System.out.print("������ �Է����ּ���: ");
		double grade = input.nextDouble();
		if (grade >= 90)
		{
			System.out.println("�����մϴ�.");
			System.out.println("A������ ����ϼ̽��ϴ�.");

		}
		else if (grade >= 80)
			System.out.println("B������ ����ϼ̽��ϴ�.");
		else if (grade >= 70)
			System.out.println("C������ ����ϼ̽��ϴ�.");
		else if (grade >= 60)
			System.out.println("D������ ����ϼ̽��ϴ�.");	
		else
			System.out.println("F������ ����ϼ̽��ϴ�. ������ϼ���.");	

/*		else if (grade < 90)
		{
			System.out.println("�й��ϼ��� �� ��");
			double remain = 90.00 - (double)(grade);
			System.out.printf("A�������� %.2f�� ���ҽ��ϴ�.", remain);
		}
*/
		System.out.print("�����ڵ带 �Է����ּ���: ");
		int sexcode = input.nextInt();
		if (sexcode == 1 || sexcode == 3 )
			System.out.println("�����Դϴ�.");	
		else if (sexcode == 2 || sexcode == 4)
			System.out.println("�����Դϴ�.");	
		else
			System.out.println("�ܰ����Դϴ�.");	



			
			
		
	}

}
