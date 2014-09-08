package date20140806;

public class DoubleChance extends Chance {
	
	public DoubleChance(){
		super("해당 문제의 상금을 두배로 올려줍니다.");
	}

	@Override
	public void chanceEvent(Quiz quiz1) {
		// TODO Auto-generated method stub
		quiz1.setRewards((quiz1.getRewards())*2);
		System.out.println("상금이 기존 상금 두배" + quiz1.getRewards() + "원으로 변경되었습니다.");
	}

}
