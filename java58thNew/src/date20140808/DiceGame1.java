package date20140808;

import java.util.Scanner;

	

public class DiceGame1 {

	
	Scanner scanner;
	
	public DiceGame1(){
		scanner = new Scanner (System.in);
	}
	
	public void playGame() {
		System.out.println("����ڿ� ��ǻ�Ͱ��� �� ���� ���� ������ �̱�� ����");
		System.out.println("�غ������ Enter");
		scanner.nextLine();
		
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
