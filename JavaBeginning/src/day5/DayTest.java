package day5;

import java.util.Scanner;

class MethodTest3 {
	public void pass(int a, int b, int c) {
		int avg = (a + b + c) / 3;
		if (avg >= 60)
			System.out.println("�հ��Դϴ�.1");
		else
			System.out.println("���հ��Դϴ�.1");
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
			return "�հ��Դϴ�.3";
		else
			return "���հ��Դϴ�.3";
	}

}

public class DayTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("ù ��° �����Է�: ");
		int d = input.nextInt();
		System.out.print("�� ��° �����Է�: ");
		int e = input.nextInt();
		System.out.print("�� ��° �����Է�: ");
		int f = input.nextInt();
		System.out.println("=======");
		System.out.print("pass�� ���� ���: ");
		MethodTest3 g = new MethodTest3();
		g.pass(d, e, f);

		System.out.print("pass1�� ���� ���: ");
		boolean h = g.pass1(d, e, f);
		if (h == true)
			System.out.println("�հ��Դϴ�.2");
		else
			System.out.println("���հ��Դϴ�.2");

		System.out.print("pass2�� ���� ���: ");
		System.out.println(g.pass2(d, e, f));

	}
}