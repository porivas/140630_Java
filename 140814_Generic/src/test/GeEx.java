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
		System.out.println("���� ���α׷�");
		Scanner scanner =new Scanner(System.in);
		System.out.println("1. ���� 2. ���� 3. ���� 4.������");
		switch(scanner.nextInt()){
			case 1:
				System.out.println("������ �����մϴ�.");
				Scanner scanner2 =new Scanner(System.in);
				System.out.println("ù ��° ���� �Է��ϼ���");
				prop1 = (E)(scanner2.nextLine());
				System.out.println("�� ��° ���� �Է��ϼ���");
				prop2 = (K)(scanner2.nextLine());
				
//				calc();
//				inputUI();
//				System.out.println(prop1);
//			case 2:
//				System.out.println("������ �����մϴ�.");
//				calc();
//				inputUI();
//			case 3:
//				System.out.println("������ �����մϴ�.");
//				calc();
//				inputUI();
//			case 4:
//				System.out.println("�������� �����մϴ�.");
//				calc();
//				inputUI();

		
		
		
//		GeEx<String, Double> obj2 = new GeEx<String, Double>();
		
	}

	@Override
	public String toString() {
		return "GeEx [prop1=" + prop1 + ", prop2=" + prop2 + "]";
	}
	
	

}
