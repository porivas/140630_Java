package day10;

public class Count2 {
	int var1 = 0;
	static int var2 = 0;
	
	public static void main(String[] args){
		Count2 c1 = new Count2();
		Count2 c2 = new Count2();
		c1.var1 = 1;
		c1.var2 = 2; 
		// Count2.var2�� �׳� var2��� �ص� �ȴ�.
		c2.var1++;	// 1
		c2.var2++;	// 2
		System.out.println(c1.var1+", "+c1.var2);
		//System�̶�� Ŭ������ out�̶�� static�޼ҵ尡 ����. 
	}

}
