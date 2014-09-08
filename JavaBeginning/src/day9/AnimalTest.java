package day9;

class Animal{
	private int age;
	public Animal(int age){
		this.age = age;
	}
	public void eat(){
		System.out.println("������ �Ծ���. ����");
	}
	public void eat(String food){
		System.out.println(food+"�� ���� ����.");
	}
	public void breathe(){
		System.out.println("������");
	}
	public void sleep(){
		System.out.println("�� �ܴ�.");
	}
	public void showRace(){
		System.out.println("=== ���� �ùķ��̼� ===");
	}
}

class Person extends Animal{
	private String name;
	public Person(int age, String name){
		super(age);
		this.name = name;
	}
	public void eat(){
		System.out.println("������ �Ծ���.");
	}
	public void eat(String food){
		System.out.println(food+"�� ���������� ���ִ�.");
	}
	public void breathe(){
		System.out.println("���ķ� ������");
	}
	public void walk(){
		System.out.println("�������� ��ձ���");
	}
	public void showRace(){
		System.out.println("=== ��� �ùķ��̼� ===");
	}
}
public class AnimalTest {
	public static void main (String[] args){
		Animal lion = new Animal(2);
		lion.showRace();
		lion.eat();
		lion.eat("���");
		lion.breathe();
		lion.sleep();
		Person hu = new Person(10, "ȫ�浿");
		hu.showRace();
		hu.eat();
		hu.eat("���");
		hu.breathe();
		hu.sleep();
		hu.walk();
		Animal b = new Person(10,"�����");			// ������ �����ü�� �־���. 
		b.showRace();
		b.eat();
		b.eat("���");
		b.breathe();
		if(b instanceof Person){
			// if(b instanceof Person) true�� ����
			// if(b instanceof Animal) true�� ���� 
			// if(b instanceof Object) true�� ���� 
			b.showRace();
			((Person)b).walk();						// ������ ��� �޼ҵ� ȣ������ �ٲ����. 
		}

	}

}
