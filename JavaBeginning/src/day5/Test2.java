package day5;

class MethodTest4{
	int a, b;
	public int add (int a, int b){
		int result = a+b;
		return result;
	}
	public void sum(){
		int result = a+b;
		System.out.println("���� �����="+result);
	}
	public void set(int c, int d)
	{
		a = c; b = d;
	}
	public void print(){
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}

public class Test2 {
	public static void main(String[] args){
		MethodTest4 a = new MethodTest4();
		int b = a.add(10, 20);
		System.out.println("���� �����="+b);
		System.out.println("���� �����="+a.add(10, 20));
		System.out.println("a="+a.a);
		System.out.println("b="+a.b);
		a.sum();
		a.print();
		a.set(10,20);
		System.out.println("a="+a.a);
		System.out.println("b="+a.b);
		a.sum();
		a.print();

	}

}
