package date20140808;
import java.util.Scanner;
public class DiceGame2 {

	Scanner scanner;

	public DiceGame2(){
		scanner = new Scanner (System.in);
	}

	public void playGame() {
		System.out.println("����ڿ� ��ǻ�Ͱ��� Ư������ �� ������ �̱�� ����");
		System.out.println("�غ������ Enter");
		scanner.nextLine();
		
		int answer = (int)(Math.random()*6)+1;
		System.out.println("��ǥ ���ڴ� "+answer+"�Դϴ�.");
		
		int userValue = (int)(Math.random()*6)+1;
		int comValue = (int)(Math.random()*6)+1;

		boolean result = false;

		if(userValue == comValue){
			System.out.println("������� �ٽ� �մϴ�.");
			playGame();
		}
		if(userValue > comValue){
			System.out.println("�̱�");
			result = true;
		}else{
			System.out.println("��");
			result = false;
		}
	}


}
