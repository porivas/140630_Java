package day5;

public class Calculator3 {
	double a, b, result;
	public void setData(double a, double b){
		this.a = a;
		this.b = b;
	}
	public void add(){
		result = a+b;
	}
	public void sub(){
		result = a-b;
	}
	public void mul(){
		result = a*b;
	}
	public void div(){
		result = a/b;
	}
	public double getResult(){
		return result;
	}
	public void printResult(){
		System.out.println("�����="+result);
	}
	public static void main(String[] args){
		Calculator3 cal = new Calculator3();
		cal.setData(20, 10);
		cal.add();
		cal.printResult();
		System.out.println("����="+cal.getResult());
		cal.sub();
		cal.printResult();
		cal.mul();
		cal.printResult();
		cal.div();
		cal.printResult();
		System.out.println("������="+cal.getResult());

		// ���ݺ��� ���� �׽�Ʈ �մϴ�. 

		System.out.println("Sublime Text2 �ѱ� ��� �׽�Ʈ");


	}
}
