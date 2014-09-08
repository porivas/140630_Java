package day5;

import java.util.Scanner;

class MethodTest3 {
	public void pass(int a, int b, int c) {
		int avg = (a + b + c) / 3;
		if (avg >= 60)
			System.out.println("합격입니다.1");
		else
			System.out.println("불합격입니다.1");
	}

	public boolean pass1(int a, int b, int c) {
		int avg = (a + b + c) / 3;
		if (avg >= 60)
			return true;
		else
			return false;
	}

	public String pass2(int a, int b, int c) {
		int avg = (a + b + c) / 3;
		if (avg >= 60)
			return "합격입니다.3";
		else
			return "불합격입니다.3";
	}

}

public class DayTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("첫 번째 정수입력: ");
		int d = input.nextInt();
		System.out.print("두 번째 정수입력: ");
		int e = input.nextInt();
		System.out.print("세 번째 정수입력: ");
		int f = input.nextInt();
		System.out.println("=======");
		System.out.print("pass에 의한 결과: ");
		MethodTest3 g = new MethodTest3();
		g.pass(d, e, f);

		System.out.print("pass1에 의한 결과: ");
		boolean h = g.pass1(d, e, f);
		if (h == true)
			System.out.println("합격입니다.2");
		else
			System.out.println("불합격입니다.2");

		System.out.print("pass2에 의한 결과: ");
		System.out.println(g.pass2(d, e, f));

	}
}