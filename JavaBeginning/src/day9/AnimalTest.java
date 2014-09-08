package day9;

class Animal{
	private int age;
	public Animal(int age){
		this.age = age;
	}
	public void eat(){
		System.out.println("생으로 먹었다. 어흥");
	}
	public void eat(String food){
		System.out.println(food+"의 맛이 좋다.");
	}
	public void breathe(){
		System.out.println("숨쉬기");
	}
	public void sleep(){
		System.out.println("나 잔다.");
	}
	public void showRace(){
		System.out.println("=== 동물 시뮬레이션 ===");
	}
}

class Person extends Animal{
	private String name;
	public Person(int age, String name){
		super(age);
		this.name = name;
	}
	public void eat(){
		System.out.println("익혀서 먹었다.");
	}
	public void eat(String food){
		System.out.println(food+"을 익혀먹으니 맛있다.");
	}
	public void breathe(){
		System.out.println("허파로 숨쉬기");
	}
	public void walk(){
		System.out.println("직립보행 우왕굳ㅋ");
	}
	public void showRace(){
		System.out.println("=== 사람 시뮬레이션 ===");
	}
}
public class AnimalTest {
	public static void main (String[] args){
		Animal lion = new Animal(2);
		lion.showRace();
		lion.eat();
		lion.eat("고기");
		lion.breathe();
		lion.sleep();
		Person hu = new Person(10, "홍길동");
		hu.showRace();
		hu.eat();
		hu.eat("고기");
		hu.breathe();
		hu.sleep();
		hu.walk();
		Animal b = new Person(10,"사오정");			// 동물에 사람객체를 넣었다. 
		b.showRace();
		b.eat();
		b.eat("고기");
		b.breathe();
		if(b instanceof Person){
			// if(b instanceof Person) true를 리턴
			// if(b instanceof Animal) true를 리턴 
			// if(b instanceof Object) true를 리턴 
			b.showRace();
			((Person)b).walk();						// 때문에 사람 메소드 호출방식이 바뀌었다. 
		}

	}

}
