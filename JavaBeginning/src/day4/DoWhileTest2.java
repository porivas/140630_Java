package day4;

import java.util.Scanner;

public class DoWhileTest2 {
	public static void main(String[] args)
	{
		int choice;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("***�ݺ��� ���� ����***");
			System.out.println(" 1. while �ݺ���");
			System.out.println(" 2. do-while �ݺ���");
			System.out.println(" 3. for �ݺ���");
			System.out.print("���ϴ� ��ȣ�� �Է��ϼ���: ");
			choice = scan.nextInt();
			System.out.println();
		} while(choice < 1 || choice > 3);
		
		switch(choice)
		{
		
		case 1:
			System.out.println(" ***1. while �ݺ���");
			System.out.println(" ������ ���� �˻��ϰ� ������ ���� ��� �ݺ��κ��� �����ϴ� �ݺ���");
			break;
		case 2:
			System.out.println(" ***2. do-while �ݺ���");
			System.out.println(" �ݺ��κ��� ���� �����ϰ� ������ �˻��Ѵ�. �ּ��� �ѹ��� ����Ǵ� �ݺ���");
			break;
		case 3:
			System.out.println(" ***3. for �ݺ���");
			System.out.println("������ Ƚ����ŭ �ݺ� �κ��� �����ϴ� �ݺ���");
			break;
		}
		
	}

}
