package test;

import java.util.Scanner;

public class GeEx<E,K,R> {
	
	 E prop1; // num1
	 K prop2; // num2
	 R prop3; // result
	 
	 
	
	
	public GeEx(E prop1, K prop2, R prop3) {
		super();
		this.prop1 = prop1;
		this.prop2 = prop2;
		this.prop3 = prop3;
	}

	public static void main(String[] args) {
		System.out.println("°è»ê±â ÇÁ·Î±×·¥");
		Scanner scanner =new Scanner(System.in);
		System.out.println("1. µ¡¼À 2. »¬¼À 3. °ö¼À 4.³ª´°¼À");
		switch(scanner.nextInt()){
			case 1:
				System.out.println("µ¡¼ÀÀ» ½ÇÇàÇÕ´Ï´Ù.");
				Scanner scanner2 =new Scanner(System.in);
				System.out.println("Ã¹ ¹øÂ° °ªÀ» ÀÔ·ÂÇÏ¼¼¿ä");
				prop1 = (E)(scanner2.nextLine());
				System.out.println("µÎ ¹øÂ° °ªÀ» ÀÔ·ÂÇÏ¼¼¿ä");
				prop2 = (K)(scanner2.nextLine());
				
//				calc();
//				inputUI();
//				System.out.println(prop1);
//			case 2:
//				System.out.println("»¬¼ÀÀ» ½ÇÇàÇÕ´Ï´Ù.");
//				calc();
//				inputUI();
//			case 3:
//				System.out.println("°ö¼ÀÀ» ½ÇÇàÇÕ´Ï´Ù.");
//				calc();
//				inputUI();
//			case 4:
//				System.out.println("³ª´°¼ÀÀ» ½ÇÇàÇÕ´Ï´Ù.");
//				calc();
//				inputUI();

		
		
		
//		GeEx<String, Double> obj2 = new GeEx<String, Double>();
		
	}

	@Override
	public String toString() {
		return "GeEx [prop1=" + prop1 + ", prop2=" + prop2 + "]";
	}
	
	

}
