package day2;

public class ArithmeticOPTest1 {
	
	public static void main (String[] args)
	{
		int a=5, b=2;
		int sum=a+b;
		System.out.println("a+b"+sum);
		int mod=a%b;
		System.out.println("a%b"+mod);
		int c = ++a;
		System.out.println("a�� ������������(prefix)="+c);
		System.out.println("a������ ��: "+a);
		int d = b++;
		System.out.println("b�� ������������(postfix)="+d);
		System.out.println("b������ ��: "+b);

	}

}
