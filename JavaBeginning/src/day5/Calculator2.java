package day5;

class Calculator2{
	double a,b;
	public void setData(double a, double b){
		this.a = a;
		this.b = b;
	}
	public double add(){
		return a+b;
	}
	public double sub(){
		return a-b;
	}
	public double mul(){
		return a*b;
	}
	public double div(){
		return a/b;
	}
	public static void main(String[] args){
		Calculator2 cal = new Calculator2();
		cal.setData(20, 10);
		System.out.print("����="+cal.add());
		System.out.print("����="+cal.sub());
		System.out.print("����="+cal.mul());
		System.out.print("������="+cal.div());

	}
}
