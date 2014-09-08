package date20140811_TestFoodStore1;
import java.util.Arrays;
import java.util.Scanner;

public class FoodStoreUI {
	
	Scanner sc = new Scanner(System.in);
	private FoodStoreManager  rManager= new FoodStoreManager();
	
	public FoodStoreUI() {
		super();
		System.out.println("원하는 기능을 선택해 주세요 (1 : 원하는 메뉴 입력시 가까운 음식점 찾기, 2 : 위치정보로 근처 음식점 정렬)");
		
		String userMenu;
		switch(sc.nextInt()){
			case 2 :
				System.out.println("자신의 현재 위치를 입력하세요!!!");
				System.out.println("경도를 입력하세요");
				Double userlng = sc.nextDouble();
				System.out.println("위도를 입력하세요");
				Double userlat = sc.nextDouble();

				System.out.println(Arrays.toString((rManager.findStoresByDistance(userlat, userlng))));
				
				break;
				
			case 1 : 
				System.out.println("원하는 메뉴를 입력해주세요!!!!");
				userMenu = sc.next();
				System.out.println("자신의 현재 위치를 입력하세요!!!");
				System.out.println("경도를 입력하세요");
				userlng = sc.nextDouble();
				System.out.println("위도를 입력하세요");
				userlat = sc.nextDouble();
			
				System.out.println(Arrays.toString(rManager.findStoresByMenuName(userlat, userlng, userMenu)));
				
				break;
		}

	}
}

