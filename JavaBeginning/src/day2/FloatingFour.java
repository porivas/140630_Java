package day2;

public class FloatingFour {
	
	public static void main(String[] args){
		int int1;
		float float1= 28.0f, float2 = 5;
		
//		int1 = float1 / float2;  타입이 맞지 않는다. 
		int1 = (int)(float1 / float2);
//		형변환되어서 들어가면 데이터가 짤린다. 
		System.out.println("28.0/5.0 = "+int1);
		System.out.println(float1+","+float2);
		
	}

}
