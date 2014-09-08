package day10;

interface ICook{
	public void makeRice();
	public void makeSoup();
	public void makeSource();
	public void makeSalad();
}

class KoreanCook implements ICook{
	public void makeRice(){
		System.out.println("�ѽ� ���� �����ϴ�.");
	}
	public void makeSoup(){
		System.out.println("��ⱹ���� ����ϴ�. ");
	}
	public void makeSalad(){
		System.out.println("�ѽ� ��ħ�� ����ϴ�.");
	}
	public void makeSource(){
		System.out.println("������ �ӳ����� ����ϴ�.");
	}
}

class ChineseCook implements ICook{
	public void makeRice(){
		System.out.println("�߽� ���� �����ϴ�.");
	}
	public void makeSoup(){
		System.out.println("«�ͱ����� ����ϴ�. ");
	}
	public void makeSalad(){
		System.out.println("�߽� ��ħ�� ����ϴ�.");
	}
	public void makeSource(){
		System.out.println("������ �ӳ����� ����ϴ�.");
	}
}

class CookManager{
	private ICook cook;

	public CookManager(ICook cook){
		this.cook = cook;
	}
	public void setCook(ICook cook){
		this.cook = cook;
	}
	public void orderRice(){
		cook.makeRice();
	}
	public void orderSoup(){
		cook.makeSoup();
	}
}

public class CookTest {
	public static void main(String[] args){
		ICook cook = new KoreanCook();
		CookManager manager = new CookManager(cook);
		manager.orderRice();
		manager.orderSoup();

		ICook cook1 = new ChineseCook();
		manager.setCook(cook1);
		manager.orderRice();
		manager.orderSoup();
	}

}
