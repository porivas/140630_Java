package date20140806;

import java.util.Scanner;

public class EraserChance extends Chance {

	public EraserChance(){
		super("지우개찬스입니다.");
	}
	
	public boolean getResult(Quiz quiz1){
		System.out.println("답을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		if(quiz1.checkAnswer(sc.nextLine())){
			System.out.println("정답입니다.");
			return true;
		} else {
			System.out.println("틀렸습니다. ");
			return false;
		}
	}
	
	@Override
	public void chanceEvent(Quiz quiz1) {
		// TODO Auto-generated method stub
		System.out.println("당신의 기회는 두번입니다.");
	}
		
}
