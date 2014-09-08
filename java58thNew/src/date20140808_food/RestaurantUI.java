package date20140808_food;

import java.util.Scanner;


public class RestaurantUI {
	Scanner sc = new Scanner(System.in);
	private RestaurantManager  rManager= new RestaurantManager();
	
	public RestaurantUI() {
		super();
		rManager.createStore();
		System.out.println("���ϴ� ����� ������ �ּ��� (1 : ���ϴ� �޴� �Է½� ����� ������ ã��, 2 : ��ġ������ ��ó ������ ����)");
		
		switch(sc.nextInt()){
			case 1 :
				System.out.println("���ϴ� �޴��� �Է����ּ���!!!!");
				String userMenu = sc.next();
				System.out.println("�ڽ��� ���� ��ġ�� �Է��ϼ���!!!");
				System.out.println("�浵�� �Է��ϼ���");
				Double userlng = sc.nextDouble();
				System.out.println("������ �Է��ϼ���");
				Double userlat = sc.nextDouble();
				
				int getNearIdx = rManager.displayNearestStore(userlng, userlat, userMenu);
				System.out.println("��Ű� ���� ����� �������� \"" +  rManager.foodArr[getNearIdx].getName()+ "\"�Դϴ�");
				
				break;
			case 2 : 
				System.out.println("�ڽ��� ���� ��ġ�� �Է��ϼ���!!!");
				userlng = sc.nextDouble();
				userlat = sc.nextDouble();
				Restaurant[] getNearStoreArr= rManager.storeSort(userlng, userlat);
				for (int i = 0; i < getNearStoreArr.length; i++) {
					System.out.println(getNearStoreArr[i].getName());
				}			
				break;
		}
		
		}
			
	
	

}
