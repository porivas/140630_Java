package day2;

public class FloatingFour {
	
	public static void main(String[] args){
		int int1;
		float float1= 28.0f, float2 = 5;
		
//		int1 = float1 / float2;  Ÿ���� ���� �ʴ´�. 
		int1 = (int)(float1 / float2);
//		����ȯ�Ǿ ���� �����Ͱ� ©����. 
		System.out.println("28.0/5.0 = "+int1);
		System.out.println(float1+","+float2);
		
	}

}
