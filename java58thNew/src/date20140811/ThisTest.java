package date20140811;

public class ThisTest {
	
	public void doA(){
		System.out.println(ThisTest.this);
	}
	public static void main(String[] args) {
		
		ThisTest obj = new ThisTest();
		System.out.println(obj);
		//System.out.println(ThisTest.this); 이건 안된다.
		obj.doA();
	}
}
