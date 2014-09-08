package date20140812_io_Store;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FoodStoreUI {
	
	Scanner sc = new Scanner(System.in);
	Scanner sc2;
	private FoodStoreManager  rManager= new FoodStoreManager();
	private FoodStoreDAO textManager = new FoodStoreDAO();
	private ArrayList tempList;
	
	String userMenu;
	double userlng;
	double userlat;
	int selectNum;
	public FoodStoreUI() throws Exception {
		super();
//		FoodStoreDAO test1 = new FoodStoreDAO();
//		System.out.println("저장테스트");
//		test1.SaveDate(23.11, 77.777, "대박집", "대박막걸리, 대박전, 대박 순대", "포장마차");
//		test1.LoadData();
		printSelectionList();


	}
	
	public void printSelectionList() throws Exception{
		System.out.print("원하는 기능을 선택해 주세요 \n1. 원하는 메뉴 입력시 가까운 음식점 찾기 \n2. 위치정보로 근처 음식점 정렬\n3. 음식점 정보 추가\n4. 음식점 정보 수정\n5. 특정 음식점 삭제\n6. 현재 음식점 정보 확인\n선택번호: ");				
		
		switch(sc.nextInt()){
			case 1 : 
				System.out.println("원하는 메뉴를 입력해주세요!!!!");
				userMenu = sc.next();
				System.out.println("자신의 현재 위치를 입력하세요!!!");
				System.out.println("경도를 입력하세요");
				userlng = sc.nextDouble();
				System.out.println("위도를 입력하세요");
				userlat = sc.nextDouble();
				System.out.println(Arrays.toString(rManager.findStoresByMenuName(userlat, userlng, userMenu)));
				printSelectionList();
		
				break ;
			case 2 :
				System.out.println("자신의 현재 위치를 입력하세요!!!");
				System.out.println("경도를 입력하세요");
				userlng = sc.nextDouble();
				System.out.println("위도를 입력하세요");
				userlat = sc.nextDouble();
				System.out.println(Arrays.toString((rManager.findStoresByDistance(userlat, userlng))));				
				printSelectionList();

				break ;
				
			case 3 :
				System.out.println("3. 음식점 정보 추가");
				// 사용자 정보입력
					System.out.println("위도, 경도, 가게명, 메뉴리스트(쉼표로 구분), 음식종류 순으로 입력하세요");
					sc = new Scanner(System.in);
					System.out.print("위도:");
					double storeLat = Double.parseDouble(sc.nextLine());
					System.out.print("경도:");
					double storeLng = Double.parseDouble(sc.nextLine());
					System.out.print("가게명:");
					String storeName = sc.nextLine();
					System.out.print("메뉴리스트:");
					String storeMenu = sc.nextLine();
					System.out.print("가게종류:");
					String storeType = sc.nextLine();
					textManager.addData(storeLng, storeLat, storeName, storeMenu, storeType);
					System.out.println("input 완료");
					printSelectionList();

				break ;
				
			case 4 : 
				System.out.println("4. 음식점 정보 수정");
				CurrentList();
				System.out.print("원하는 번호를 입력하세요: ");
				sc2 = new Scanner(System.in);
				selectNum = sc2.nextInt();
				System.out.println("위도, 경도, 가게명, 메뉴리스트(쉼표로 구분), 음식종류 순으로 입력하세요");
				sc = new Scanner(System.in);
				System.out.print("위도:");
				double storeLat2 = Double.parseDouble(sc.nextLine());
				System.out.print("경도:");
				double storeLng2 = Double.parseDouble(sc.nextLine());
				System.out.print("가게명:");
				String storeName2 = sc.nextLine();
				System.out.print("메뉴리스트:");
				String storeMenu2 = sc.nextLine();
				System.out.print("가게종류:");
				String storeType2 = sc.nextLine();
				tempList = textManager.LoadData();
				tempList.set(selectNum, storeLat2+" "+ storeLng2+" "+storeName2+" "+storeMenu2+" "+storeType2);
//				rManager.getStores2().get(selectNum)
//				rManager.getStores2().get(selectNum).setName(storeName2);
//				rManager.getStores2().get(selectNum).setMenu(storeMenu2);
//				rManager.getStores2().get(selectNum).setType(storeType2);
				textManager.SaveData(tempList);
				printSelectionList();
				break ;
			
			case 5 : 
				System.out.println("5. 특정 음식점 삭제");
				CurrentList();
				System.out.print("원하는 번호를 입력하세요: ");
				sc2 = new Scanner(System.in);
				selectNum = sc2.nextInt();
				tempList = textManager.LoadData();
				tempList.remove(selectNum);
				textManager.SaveData(tempList);
				System.out.println("== 삭제되었습니다 ==");
				CurrentList();
				printSelectionList();
				break ;
			case 6 :
				System.out.println("6. 현재 음식점 정보 확인");
				CurrentList();
				printSelectionList();
				break ;
		}
	}
	
	public void CurrentList() throws Exception{
		tempList = textManager.LoadData();
		for (int i = 0; i < tempList.size(); i++) {
			System.out.println(i+"번: "+tempList.get(i));
		}
		
	}
	
}

