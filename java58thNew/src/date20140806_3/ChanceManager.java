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
	
	//�ε����� �����ϸ� �ش� ������ ��ȯ�Ѵ�.
	public Chance getSelectedChance(int idx){
		return arr[idx-1];
	}
	
	
	
}
