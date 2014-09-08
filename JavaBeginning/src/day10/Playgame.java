package day10;

abstract class Sports{
	String name;
	int age;
	String money;

	public Sports (String name, int age, String money){
		this.name = name;
		this.age = age;
		this.money = money;
	}
	public void printInfo(){
		System.out.println("name ="+name);
		System.out.println("age ="+ age);
		System.out.println("money = "+ money);
	}
	abstract void Playgame();
	// 바디가 없고 헤더만 있는 추상 메소드
}

class BasketBall extends Sports{
	public BasketBall(){
		super("gemini", 20, "100만 달러");
		printInfo();
	}

	// 추상 메소드의 구현 
	public void Playgame(){
		System.out.println("name"+"가 손으로 공을 던집니다.");
	}
}

class Soccer extends Sports{
	public Soccer(){
		super("johnharu",25, "150만 달러");
		printInfo();
	}
	public void Playgame(){
		System.out.println(name+"가 발로 공을 찹니다");
	}
}

public class Playgame {
	public static void main(String[] args){
		BasketBall gemini= new BasketBall();
		gemini.Playgame();

		Soccer johnharu = new Soccer();
		johnharu.Playgame();

	}
}
