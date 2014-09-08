package day5;

class MethodTest1
{
	public int add(int a, int b)
	{
		int result = a+b;
		return result;
	}
	public double mul(double a, int b)
	{
		return a*b;
	}
	public void sub(float a, float b)
	{
		float result = a -b;
		System.out.println("°á°ú°ª="+result);
	}

}

public class Test1 {
	public static void main(String[] args)
	{
		MethodTest1 a = new MethodTest1();
		int b = a.add(10,20);
		System.out.println("µ¡¼À °á°ú°ª="+b);
		System.out.println("µ¡¼À °á°ú°ª="+a.add(10, 20));
		double c = a.mul(2.5, 3);
		System.out.println("°ö¼À °á°ú°ª="+c);
		System.out.println("°ö¼À °á°ú°ª="+a.mul(2.5, 3));
		a.sub(2.5f, 1.2f);
//		System.out.println("»¬¼À °á°ú°ª"+a.sub(2.5f, 1.2f));
	}
}
