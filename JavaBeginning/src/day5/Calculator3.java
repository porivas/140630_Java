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
		System.out.println("결과값="+result);
	}
	public static void main(String[] args){
		Calculator3 cal = new Calculator3();
		cal.setData(20, 10);
		cal.add();
		cal.printResult();
		System.out.println("덧셈="+cal.getResult());
		cal.sub();
		cal.printResult();
		cal.mul();
		cal.printResult();
		cal.div();
		cal.printResult();
		System.out.println("나눗셈="+cal.getResult());

		// 지금부터 저장 테스트 합니다. 

		System.out.println("Sublime Text2 한글 출력 테스트");


	}
}
