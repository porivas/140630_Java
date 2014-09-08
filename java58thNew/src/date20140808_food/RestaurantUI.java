package date20140808_food;

import java.util.Scanner;


public class RestaurantUI {
	Scanner sc = new Scanner(System.in);
	private RestaurantManager  rManager= new RestaurantManager();
	
	public RestaurantUI() {
		super();
		rManager.createStore();
		System.out.println("원하는 기능을 선택해 주세요 (1 : 원하는 메뉴 입력시 가까운 음식점 찾기, 2 : 위치정보로 근처 음식점 정렬)");
		
		switch(sc.nextInt()){
			case 1 :
				System.out.println("원하는 메뉴를 입력해주세요!!!!");
				String userMenu = sc.next();
				System.out.println("자신의 현재 위치를 입력하세요!!!");
				System.out.println("경도를 입력하세요");
				Double userlng = sc.nextDouble();
				System.out.println("위도를 입력하세요");
				Double userlat = sc.nextDouble();
				
				int getNearIdx = rManager.displayNearestStore(userlng, userlat, userMenu);
				System.out.println("당신과 가장 가까운 음식점은 \"" +  rManager.foodArr[getNearIdx].getName()+ "\"입니다");
				
				break;
			case 2 : 
				System.out.println("자신의 현재 위치를 입력하세요!!!");
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
