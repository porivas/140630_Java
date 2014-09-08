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
//		System.out.println("�����׽�Ʈ");
//		test1.SaveDate(23.11, 77.777, "�����", "��ڸ��ɸ�, �����, ��� ����", "���帶��");
//		test1.LoadData();
		printSelectionList();


	}
	
	public void printSelectionList() throws Exception{
		System.out.print("���ϴ� ����� ������ �ּ��� \n1. ���ϴ� �޴� �Է½� ����� ������ ã�� \n2. ��ġ������ ��ó ������ ����\n3. ������ ���� �߰�\n4. ������ ���� ����\n5. Ư�� ������ ����\n6. ���� ������ ���� Ȯ��\n���ù�ȣ: ");				
		
		switch(sc.nextInt()){
			case 1 : 
				System.out.println("���ϴ� �޴��� �Է����ּ���!!!!");
				userMenu = sc.next();
				System.out.println("�ڽ��� ���� ��ġ�� �Է��ϼ���!!!");
				System.out.println("�浵�� �Է��ϼ���");
				userlng = sc.nextDouble();
				System.out.println("������ �Է��ϼ���");
				userlat = sc.nextDouble();
				System.out.println(Arrays.toString(rManager.findStoresByMenuName(userlat, userlng, userMenu)));
				printSelectionList();
		
				break ;
			case 2 :
				System.out.println("�ڽ��� ���� ��ġ�� �Է��ϼ���!!!");
				System.out.println("�浵�� �Է��ϼ���");
				userlng = sc.nextDouble();
				System.out.println("������ �Է��ϼ���");
				userlat = sc.nextDouble();
				System.out.println(Arrays.toString((rManager.findStoresByDistance(userlat, userlng))));				
				printSelectionList();

				break ;
				
			case 3 :
				System.out.println("3. ������ ���� �߰�");
				// ����� �����Է�
					System.out.println("����, �浵, ���Ը�, �޴�����Ʈ(��ǥ�� ����), �������� ������ �Է��ϼ���");
					sc = new Scanner(System.in);
					System.out.print("����:");
					double storeLat = Double.parseDouble(sc.nextLine());
					System.out.print("�浵:");
					double storeLng = Double.parseDouble(sc.nextLine());
					System.out.print("���Ը�:");
					String storeName = sc.nextLine();
					System.out.print("�޴�����Ʈ:");
					String storeMenu = sc.nextLine();
					System.out.print("��������:");
					String storeType = sc.nextLine();
					textManager.addData(storeLng, storeLat, storeName, storeMenu, storeType);
					System.out.println("input �Ϸ�");
					printSelectionList();

				break ;
				
			case 4 : 
				System.out.println("4. ������ ���� ����");
				CurrentList();
				System.out.print("���ϴ� ��ȣ�� �Է��ϼ���: ");
				sc2 = new Scanner(System.in);
				selectNum = sc2.nextInt();
				System.out.println("����, �浵, ���Ը�, �޴�����Ʈ(��ǥ�� ����), �������� ������ �Է��ϼ���");
				sc = new Scanner(System.in);
				System.out.print("����:");
				double storeLat2 = Double.parseDouble(sc.nextLine());
				System.out.print("�浵:");
				double storeLng2 = Double.parseDouble(sc.nextLine());
				System.out.print("���Ը�:");
				String storeName2 = sc.nextLine();
				System.out.print("�޴�����Ʈ:");
				String storeMenu2 = sc.nextLine();
				System.out.print("��������:");
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
				System.out.println("5. Ư�� ������ ����");
				CurrentList();
				System.out.print("���ϴ� ��ȣ�� �Է��ϼ���: ");
				sc2 = new Scanner(System.in);
				selectNum = sc2.nextInt();
				tempList = textManager.LoadData();
				tempList.remove(selectNum);
				textManager.SaveData(tempList);
				System.out.println("== �����Ǿ����ϴ� ==");
				CurrentList();
				printSelectionList();
				break ;
			case 6 :
				System.out.println("6. ���� ������ ���� Ȯ��");
				CurrentList();
				printSelectionList();
				break ;
		}
	}
	
	public void CurrentList() throws Exception{
		tempList = textManager.LoadData();
		for (int i = 0; i < tempList.size(); i++) {
			System.out.println(i+"��: "+tempList.get(i));
		}
		
	}
	
}

