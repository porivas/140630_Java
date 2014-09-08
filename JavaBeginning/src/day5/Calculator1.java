package day5;

class Calculator1
{
	public double add(double a, double b){
		return a+b;
	}
	public double sub(double a, double b){
		return a-b;
	}
	public double mul(double a, double b){
		return a*b;
	}
	public double div(double a, double b){
		return a/b;
	}
	public static void main(String[] args){
		Calculator1 cal = new Calculator1();
		double r = cal.add(20, 10);
		System.out.print("µ¡¼À="+r);
		r = cal.sub(20, 10);
		System.out.print("»¬¼À="+r);
		r = cal.mul(20, 10);
		System.out.print("°ö¼À="+r);
		r = cal.div(20, 10);
		System.out.print("³ª´°¼À="+r);
	}

}
