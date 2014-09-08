package date20140806_3;

public class Main {
//	public static void main(String[] args) {
		ChineseCook cook = new ChineseCook();
		
		cook.makeZaZang();
		
		ChineseCook cook2 = new SeoulCook();
		
		System.out.println("======");
		
		cook2.makeZaZang();
		((SeoulCook)cook2).makeZamBong();
		
		System.out.println("======");

		ChineseCook cook3 = new KangNamCook();
		
		cook3.makeZaZang();
		
	}
}
