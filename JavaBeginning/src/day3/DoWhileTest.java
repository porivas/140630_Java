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
				// ��� �� ���� ����Ǵ� ���� �ٸ���. 
		System.out.println("1���� 10������ ����" + hap + "�Դϴ�.");
	}

}
