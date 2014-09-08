package date20140808;
import java.util.Scanner;
public class DiceGame2 {

	Scanner scanner;

	public DiceGame2(){
		scanner = new Scanner (System.in);
	}

	public void playGame() {
		System.out.println("사용자와 컴퓨터간에 특정수와 더 가까우면 이기는 게임");
		System.out.println("준비됐으면 Enter");
		scanner.nextLine();
		
		int answer = (int)(Math.random()*6)+1;
		System.out.println("목표 숫자는 "+answer+"입니다.");
		
		int userValue = (int)(Math.random()*6)+1;
		int comValue = (int)(Math.random()*6)+1;

		boolean result = false;

		if(userValue == comValue){
			System.out.println("비겼으니 다시 합니다.");
			playGame();
		}
		if(userValue > comValue){
			System.out.println("이김");
			result = true;
		}else{
			System.out.println("짐");
			result = false;
		}
	}


}
