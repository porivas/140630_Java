package day5;

class MethodTest{
	public int sum(int start, int end){
		int total= 0;
		for (int i = start; i<=end; i++)
			total = total + i;
		return total;
	}
	public char grade(int kor, int eng, int math){
		int avg = (kor + eng + math)/3;
		if(avg >= 90)
			 return 'A';
		else if (avg >=80)
			 return 'B';
		else if (avg >=70)
			 return 'C';
		else if (avg >=60)
			 return 'D';
		else
			 return 'F';
	}
	public int countEven(int start, int end){
		int count =0;
		for (int i = start; i<=end; i++)
			if(i%2==0)
				count++;
		return count;
	}	
	public void printString(String message, int count){
		for (int i = 0; i<count; i++)
			System.out.println(message);
	}
}
class Test{
	public static void main(String[] args)	{
		MethodTest a = new MethodTest();
		int b = a.sum(10,20);
		System.out.println("10~20= "+b);
		char c = a.grade(90, 80, 100);
		System.out.println("90.80.100 = "+c);
		int d = a.countEven(10, 20);
		System.out.println("10~20.Â¦¼ö "+d);
		a.printString("Hello", 5);
	}
}