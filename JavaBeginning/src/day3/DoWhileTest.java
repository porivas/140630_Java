package day3;

public class DoWhileTest {
	public static void main (String[] args)
	{
		int hap = 0, count = 1;
				do
				{
					hap = hap + count;
					count = count + 1;
				} while (count<=10);
				// 적어도 한 번은 실행되는 점이 다르다. 
		System.out.println("1부터 10까지의 합은" + hap + "입니다.");
	}

}
