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
	// �ٵ� ���� ����� �ִ� �߻� �޼ҵ�
}

class BasketBall extends Sports{
	public BasketBall(){
		super("gemini", 20, "100�� �޷�");
		printInfo();
	}

	// �߻� �޼ҵ��� ���� 
	public void Playgame(){
		System.out.println("name"+"�� ������ ���� �����ϴ�.");
	}
}

class Soccer extends Sports{
	public Soccer(){
		super("johnharu",25, "150�� �޷�");
		printInfo();
	}
	public void Playgame(){
		System.out.println(name+"�� �߷� ���� ���ϴ�");
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
