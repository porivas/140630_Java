package date20140806;

import java.util.Scanner;

public class EraserChance extends Chance {

	public EraserChance(){
		super("���찳�����Դϴ�.");
	}
	
	public boolean getResult(Quiz quiz1){
		System.out.println("���� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		if(quiz1.checkAnswer(sc.nextLine())){
			System.out.println("�����Դϴ�.");
			return true;
		} else {
			System.out.println("Ʋ�Ƚ��ϴ�. ");
			return false;
		}
	}
	
	@Override
	public void chanceEvent(Quiz quiz1) {
		// TODO Auto-generated method stub
		System.out.println("����� ��ȸ�� �ι��Դϴ�.");
	}
		
}
