package date20140806;

public class ARSChance extends Chance {
	
	public ARSChance(){
		super("전화 찬스입니다.");
	}

	@Override
	public void chanceEvent(Quiz quiz1){
		System.out.println("전화찬스를 씁니다.");
	}


}
