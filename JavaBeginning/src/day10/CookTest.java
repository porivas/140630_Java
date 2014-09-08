package day10;

interface ICook{
	public void makeRice();
	public void makeSoup();
	public void makeSource();
	public void makeSalad();
}

class KoreanCook implements ICook{
	public void makeRice(){
		System.out.println("ÇÑ½Ä ¹äÀ» Áþ½À´Ï´Ù.");
	}
	public void makeSoup(){
		System.out.println("°í±â±¹¹°À» ¸¸µì´Ï´Ù. ");
	}
	public void makeSalad(){
		System.out.println("ÇÑ½Ä ¹«Ä§À» ¸¸µì´Ï´Ù.");
	}
	public void makeSource(){
		System.out.println("°íÃßÀå ¾Ó³äÀåÀ» ¸¸µì´Ï´Ù.");
	}
}

class ChineseCook implements ICook{
	public void makeRice(){
		System.out.println("Áß½Ä ¹äÀ» Áþ½À´Ï´Ù.");
	}
	public void makeSoup(){
		System.out.println("Â«»Í±¹¹°À» ¸¸µì´Ï´Ù. ");
	}
	public void makeSalad(){
		System.out.println("Áß½Ä ¹«Ä§À» ¸¸µì´Ï´Ù.");
	}
	public void makeSource(){
		System.out.println("ÅÁ¼öÀ° ¾Ó³äÀåÀ» ¸¸µì´Ï´Ù.");
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
