package day3;

import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] a1)
	{
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		int a, b, c, sum;
		System.out.println("---- 과목 평균 계산기 ---- ");
		System.out.print("성별코드를 입력해주세요: ");
		int sexcode = input.nextInt();
		if (sexcode == 1 || sexcode == 3 )
			System.out.println("남자 응시자 입니다.");	
		else if (sexcode == 2 || sexcode == 4)
			System.out.println("여자 응시자 입니다.");	
		else
			System.out.println("외계인 특별전형 응시자 입니다.");	
		System.out.print("첫 번째 과목의 점수를 입력해주세요:");
		a = input.nextInt();		// Scanner 값 입력후 Tab, Enter, Space
		System.out.print("두 번째 과목의 점수를 입력해주세요:");
		b = input.nextInt();
		System.out.print("세 번째 과목의 점수를 입력해주세요:");
		c = input.nextInt();
		System.out.println("--------------- ");

		if (a < 60)
		{
			System.out.println("과락입니다.");	
			System.out.println("첫 번째 과목의 점수가 "+(60-a)+"점 모자랍니다.");	
		}
		else if (b<60)
		{
			System.out.println("과락입니다.");	
			System.out.println("두 번째 과목의 점수가 "+(60-b)+"점 모자랍니다.");	
		}
		else if (c<60)
		{
			System.out.println("과락입니다.");	
			System.out.println("세 번째 과목의 점수가 "+(60-c)+"점 모자랍니다.");	
		}
		else
			System.out.println("합격입니다.");	
		System.out.println("--------------- ");
		sum = a+b+c;
		double avg = sum / 3.0;  // 여기에서 3을 넣으면 int형 2개의 계산이라 소숫점 표현이 안된다. 
		System.out.println("세과목의 평균점수는"+avg+"입니다");
		System.out.printf("반올림하여 세과목의 평균은 %.2f 입니다.\n", avg);
		// %자리에 뒤에 , 뒤에 오는 avg 변수를 넣어라. .2f 는 소숫점 둘째자리 반올림 
//		String ok = (avg >= 60.0) ? "합격입니다." : "불합격입니다.";
		if (avg >= 90)
		{
			System.out.println("축하합니다.");
			System.out.println("A학점을 취득하셨습니다.");

		}
		else if (avg >= 80)
			System.out.println("B학점을 취득하셨습니다.");
		else if (avg >= 70)
			System.out.println("C학점을 취득하셨습니다.");
		else if (avg >= 60)
			System.out.println("D학점을 취득하셨습니다.");	
		else
			System.out.println("F학점을 취득하셨습니다. 재수강하세요.");
		if (avg < 90)
		{
			System.out.println("분발하세요 ㅠ ㅠ");
			double remain = 90.00 - (double)(avg);
			System.out.printf("A학점까지 %.2f점 남았습니다.", remain);
		}
		


		
//		String d;
//		d = input2.next();
//		System.out.println("d는 "+d+"입니다.");

	}

}
