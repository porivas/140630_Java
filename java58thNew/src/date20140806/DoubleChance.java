package date20140806;

public class DoubleChance extends Chance {
	
	public DoubleChance(){
		super("�ش� ������ ����� �ι�� �÷��ݴϴ�.");
	}

	@Override
	public void chanceEvent(Quiz quiz1) {
		// TODO Auto-generated method stub
		quiz1.setRewards((quiz1.getRewards())*2);
		System.out.println("����� ���� ��� �ι�" + quiz1.getRewards() + "������ ����Ǿ����ϴ�.");
	}

}
