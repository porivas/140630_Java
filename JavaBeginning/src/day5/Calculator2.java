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
		System.out.print("µ¡¼À="+cal.add());
		System.out.print("»¬¼À="+cal.sub());
		System.out.print("°ö¼À="+cal.mul());
		System.out.print("³ª´°¼À="+cal.div());

	}
}
