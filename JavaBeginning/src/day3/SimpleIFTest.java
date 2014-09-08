package day3;

import java.util.Scanner;

public class SimpleIFTest {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
/*		System.out.print("숫자를 입력해주세요: ");

		int count = input.nextInt();
		if (count<0)			// if라인에 세미콜론 쓰면 그냥 if에서 끝남
			System.out.println(count+"은(는) 음수입니다.");
		else if (count > 0)
			System.out.println(count+"은(는) 양수입니다.");
		else
			System.out.println(count+"0입니다.");
*/
		
//		int grade = input.nextInt();
		System.out.print("점수를 입력해주세요: ");
		double grade = input.nextDouble();
		if (grade >= 90)
		{
			System.out.println("축하합니다.");
			System.out.println("A학점을 취득하셨습니다.");

		}
		else if (grade >= 80)
			System.out.println("B학점을 취득하셨습니다.");
		else if (grade >= 70)
			System.out.println("C학점을 취득하셨습니다.");
		else if (grade >= 60)
			System.out.println("D학점을 취득하셨습니다.");	
		else
			System.out.println("F학점을 취득하셨습니다. 재수강하세요.");	

/*		else if (grade < 90)
		{
			System.out.println("분발하세요 ㅠ ㅠ");
			double remain = 90.00 - (double)(grade);
			System.out.printf("A학점까지 %.2f점 남았습니다.", remain);
		}
*/
		System.out.print("성별코드를 입력해주세요: ");
		int sexcode = input.nextInt();
		if (sexcode == 1 || sexcode == 3 )
			System.out.println("남자입니다.");	
		else if (sexcode == 2 || sexcode == 4)
			System.out.println("여자입니다.");	
		else
			System.out.println("외계인입니다.");	



			
			
		
	}

}
