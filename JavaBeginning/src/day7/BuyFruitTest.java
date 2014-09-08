package day7;


class FruitSeller{
	private int applePrice;
	private int numOfApple;
	private int myMoney;

	public FruitSeller(int a, int b, int c)
	{
		this.applePrice = a;
		this.numOfApple = b;
		this.myMoney = c;
	}
	public void showSalesResult(){
		System.out.println("�������: "+this.applePrice+"\t ������: "+this.numOfApple+"\t �ܰ�: "+ this.myMoney);
	}
}
class FruitBuyer{
	private int applePrice;
	private int numOfApple;
	private int myMoney;

	public FruitBuyer(int c1)
	{
		this.myMoney = c1;
	}
	public FruitBuyer(int a, int b, int c2)
	{
		this.applePrice = a;
		this.numOfApple = b;
		this.myMoney = c2;
	}
	public void showBuyResult(){
		System.out.println("�������: "+this.applePrice+"\t ������: "+this.numOfApple+"\t �ܰ�: "+ this.myMoney);
	}
	public void BuyApples(FruitSeller seller, int price)
	{
//		seller.myMoney += price;
		System.out.println("����� ����ϴ�." );
		this.myMoney -= price;
//		seller.numOfApple--;
		this.numOfApple++;
	}
}

public class BuyFruitTest {
	public static void main(String[] args){
		FruitSeller seller = new FruitSeller(1000,20,0);
		FruitBuyer buyer = new FruitBuyer(5000);
		buyer.BuyApples(seller,2000);

		System.out.println("�����Ǹ����� ��Ȳ");
		seller.showSalesResult();
		System.out.println("���ϱ������� ��Ȳ");
		buyer.showBuyResult();
	}
}

