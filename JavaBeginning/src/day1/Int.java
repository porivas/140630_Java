package day1;

public class Int {
	public static void main(String[] args){
		int int1 = 5, int2 = 28;
		int int3, int4, int5;
		
		int3 = int2*int1;
		int4 = int2 / int1;
		int5 = 25 / int1;
		double int6 = int2 / int1;
		
		System.out.println("28 * 5 = "+ int3+"입니다.");
		System.out.println("28 / 5 = "+ int4+"입니다.");
		System.out.println("25 / 5 = "+ int5+"입니다.");
		System.out.println("변수 변경 시도 28 / 5 = "+ int6);
	}

}
