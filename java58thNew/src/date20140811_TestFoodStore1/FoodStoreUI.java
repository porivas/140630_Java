package date20140811_TestFoodStore1;
import java.util.Arrays;
import java.util.Scanner;

public class FoodStoreUI {
	
	Scanner sc = new Scanner(System.in);
	private FoodStoreManager  rManager= new FoodStoreManager();
	
	public FoodStoreUI() {
		super();
		System.out.println("���ϴ� ����� ������ �ּ��� (1 : ���ϴ� �޴� �Է½� ����� ������ ã��, 2 : ��ġ������ ��ó ������ ����)");
		
		String userMenu;
		switch(sc.nextInt()){
			case 2 :
				System.out.println("�ڽ��� ���� ��ġ�� �Է��ϼ���!!!");
				System.out.println("�浵�� �Է��ϼ���");
				Double userlng = sc.nextDouble();
				System.out.println("������ �Է��ϼ���");
				Double userlat = sc.nextDouble();

				System.out.println(Arrays.toString((rManager.findStoresByDistance(userlat, userlng))));
				
				break;
				
			case 1 : 
				System.out.println("���ϴ� �޴��� �Է����ּ���!!!!");
				userMenu = sc.next();
				System.out.println("�ڽ��� ���� ��ġ�� �Է��ϼ���!!!");
				System.out.println("�浵�� �Է��ϼ���");
				userlng = sc.nextDouble();
				System.out.println("������ �Է��ϼ���");
				userlat = sc.nextDouble();
			
				System.out.println(Arrays.toString(rManager.findStoresByMenuName(userlat, userlng, userMenu)));
				
				break;
		}

	}
}

