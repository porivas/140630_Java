package date20140806_3;

public class ChanceManager {
	
	private Chance[] arr;
	
	public ChanceManager(){
		
		super();
		
		arr = new Chance[3];
		
		arr[0] = new ARSChance();
		arr[1] = new DoubleChance();
		arr[2] = new EraserChance();

	}

	public Chance[] getArr() {
		return arr;
	}
	
	//인덱스를 선택하면 해당 찬스를 반환한다.
	public Chance getSelectedChance(int idx){
		return arr[idx-1];
	}
	
	
	
}
