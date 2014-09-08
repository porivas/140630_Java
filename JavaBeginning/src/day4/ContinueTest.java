package day4;

public class ContinueTest {
	public static void main(String[] args){
/*		for (int count = 1; count <=10; count++){
			if (count == 5)
//				continue;
				break;
			
		System.out.print(count+" ");
*/
		int sum = 0, i;
		for (i=1; i<=100; i++)
		{
//			if (i%2 == 1) continue;			sum = sum + i;
			if(i%2 ==0) 					sum = sum +i;
			
		}
		System.out.printf("1부터 100사이에 있는 짝수의 합은: %d \n", sum);
		
	}

}
