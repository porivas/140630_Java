package day2;

public class AssignOPTest {
	public static void main(String[] args)
	{
		int a = 10;
		System.out.println("a= "+a);
		a += 4;			// a=a+4
		System.out.println("a += 4의 결과"+a);
		a -= 4;
		System.out.println("a -= 4의 결과"+a);
		a *= 4;
		System.out.println("a *= 4의 결과"+a);
		a /= 4;
		System.out.println("a /= 4의 결과"+a);
		a %= 4;
		System.out.println("a %= 4의 결과"+a);
		a *= a+4;		// a=a*(a+4)
		System.out.println("a *= a+4의 결과"+a);
		a = a*(a);
		System.out.println("a(a)의 결과"+a);

	}

}
