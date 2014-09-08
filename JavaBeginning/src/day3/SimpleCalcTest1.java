package day3;

import java.util.Scanner;

public class SimpleCalcTest1 {
	public static void main(String[] args)
	{
job2:
{
		while(true)
	{

		System.out.println("==간이 계산기 프로그램==");
		System.out.println("1. 덧셈 2. 뺄셈 3. 곱셈 4. 나눗셈 5. 나머지 찾기 6. 종료");
		System.out.print("원하는 연산번호를 선택하세요: ");
		Scanner input = new Scanner(System.in);
		int calc = input.nextInt();
		switch (calc)
		{
		case 1:
			System.out.println("덧셈을 시작합니다.");
			break;
		case 2:
			System.out.println("뺄셈을 시작합니다.");
			break;
		case 3:
			System.out.println("곱셈을 시작합니다.");
			break;
		case 4:
			System.out.println("나눗셈을 시작합니다.");
			break;
		case 5:
			System.out.println("나머지찾기 시작합니다.");
			break;		
		case 6:
//			 break job2; 
		{
			System.out.print("종료하시겠습니까? (Y/N) : ");
			
			Scanner scan = new Scanner(System.in);
			String a = scan.next();
			switch (a)
			{
			case "y":	case "Y":				break job2;
//			case "Y": 				break job2; 
			case "n":	case "N": 				
				System.out.println(a+"을 입력하셨습니다.");
				System.out.println("프로그램을 다시 시작합니다.");
				continue;

//			case "N": 				continue;
			default: 
				{
				System.out.println(a+"을/를 입력하셨습니다.");
				System.out.println("Y 또는 N을 입력해주세요");
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
				System.out.println(a+"을/를 입력하셨습니다.");
				System.out.println("Y 또는 N을 입력해주세요");
			 	break;

		} */

		default:
			System.out.println("1~6 사이의 숫자를 입력해주세요.");
			break;		
		}
	
		if (calc == 1 || calc == 2 || calc ==3 || calc == 4 || calc == 5)
		{
		System.out.print("첫 번째 숫자를 입력해주세요.");
		int val1 = input.nextInt();

		System.out.print("두 번째 숫자를 입력해주세요.");
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
			System.out.println(val1+"×"+val2+"="+(val1*val2));
			break;
		case 4:
			System.out.println(val1+"÷"+val2+"="+(val1/val2));
			break;
		case 5:
			System.out.println(val1+"을/를"+val2+"로 나누었을 때 나머지는 "+(val1%val2));
			break;		

		}
		}
		else
			System.out.println("프로그램을 다시 시작합니다.");	
		}
		
		
}
		System.out.println("프로그램을 종료합니다.");
	}

}
