package day4;

public class WhileBreakTest {
	public static void main(String[] args)
	{
		int j=1, sum=0;
		while (true) 	// ���ѷ���
		{
			if (j>100) 
				break;
			sum = sum + j;
			j++;
			
		}
		System.out.println("1����"+(j-1)+"������ ��: " +sum);
		
	}

}
