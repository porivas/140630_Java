package day3;

import java.util.Scanner;

public class SimpleCalcTest1 {
	public static void main(String[] args)
	{
job2:
{
		while(true)
	{

		System.out.println("==���� ���� ���α׷�==");
		System.out.println("1. ���� 2. ���� 3. ���� 4. ������ 5. ������ ã�� 6. ����");
		System.out.print("���ϴ� �����ȣ�� �����ϼ���: ");
		Scanner input = new Scanner(System.in);
		int calc = input.nextInt();
		switch (calc)
		{
		case 1:
			System.out.println("������ �����մϴ�.");
			break;
		case 2:
			System.out.println("������ �����մϴ�.");
			break;
		case 3:
			System.out.println("������ �����մϴ�.");
			break;
		case 4:
			System.out.println("�������� �����մϴ�.");
			break;
		case 5:
			System.out.println("������ã�� �����մϴ�.");
			break;		
		case 6:
//			 break job2; 
		{
			System.out.print("�����Ͻðڽ��ϱ�? (Y/N) : ");
			
			Scanner scan = new Scanner(System.in);
			String a = scan.next();
			switch (a)
			{
			case "y":	case "Y":				break job2;
//			case "Y": 				break job2; 
			case "n":	case "N": 				
				System.out.println(a+"�� �Է��ϼ̽��ϴ�.");
				System.out.println("���α׷��� �ٽ� �����մϴ�.");
				continue;

//			case "N": 				continue;
			default: 
				{
				System.out.println(a+"��/�� �Է��ϼ̽��ϴ�.");
				System.out.println("Y �Ǵ� N�� �Է����ּ���");
			 	break;
				}
			}
		}

/*			if (a=="y" || a == "Y") 
			 {
				 break job2; 
			 }
			 else if (a=="n" || a == "N") {
				 break;}
			 else
				System.out.println(a+"��/�� �Է��ϼ̽��ϴ�.");
				System.out.println("Y �Ǵ� N�� �Է����ּ���");
			 	break;

		} */

		default:
			System.out.println("1~6 ������ ���ڸ� �Է����ּ���.");
			break;		
		}
	
		if (calc == 1 || calc == 2 || calc ==3 || calc == 4 || calc == 5)
		{
		System.out.print("ù ��° ���ڸ� �Է����ּ���.");
		int val1 = input.nextInt();

		System.out.print("�� ��° ���ڸ� �Է����ּ���.");
		int val2 = input.nextInt();
		switch (calc)
		{
		case 1:
			System.out.println(val1+"+"+val2+"="+(val1+val2));
			break;
		case 2:
			System.out.println(val1+"-"+val2+"="+(val1-val2));
			break;
		case 3:
			System.out.println(val1+"��"+val2+"="+(val1*val2));
			break;
		case 4:
			System.out.println(val1+"��"+val2+"="+(val1/val2));
			break;
		case 5:
			System.out.println(val1+"��/��"+val2+"�� �������� �� �������� "+(val1%val2));
			break;		

		}
		}
		else
			System.out.println("���α׷��� �ٽ� �����մϴ�.");	
		}
		
		
}
		System.out.println("���α׷��� �����մϴ�.");
	}

}
