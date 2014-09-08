package day7;

public class CallByValue {
	public static void passingValue(int a){
		a += 50;
		System.out.println("In passingValue: a = "+a);
	}
	public static void passingRef(Aclass aclass){
		aclass.a +=20;
		aclass.msg += " world";
		System.out.println("In passingRef: aclass.a= "+aclass.a+"\t"+"aclass.msg= "+aclass.msg);
	}
	
	public static void main(String[] args){
	int a = 10;
	String msg = "hello";
	Aclass aclass = new Aclass(a,msg);
	System.out.println("Passing by Value Test");
	System.out.println("Before\t a= "+a);
	CallByValue.passingValue(a);
	System.out.println("After\t a= "+a);
	System.out.println("\n\n Passing by Reference Test");
	System.out.println("Before\t aclass.a= "+aclass.a+"\t aclass.msg = "+aclass.msg);
	CallByValue.passingRef(aclass);
	System.out.println("After\t aclass.a= "+aclass.a+"\t aclass.msg = "+aclass.msg);
	}
}

class Aclass{
	String msg;
	int a;
	
	public Aclass(int n, String m){
		msg = m;
		a = n;
	}
}
