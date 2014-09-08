package day10;

class Animal{
	String food ="��";
	public void eat(){
		System.out.println(food+"�� �Դ�");
	}
	public void bark(){
		System.out.println("¢��");
	}
}

interface Swimmable{
	String pool = "��";
	
	public void swim();
}

interface Runnable{
	final static int MAXSPEED = 50;
	int MINSPEED = 10;
	
	public void start();
	public void running();
	public void stop();
}

public class Dog extends Animal implements Swimmable, Runnable{
	public void start(){
		System.out.println("�����");
	}
	public void running(){
		System.out.println("���޸�");
	}
	public void stop(){
		System.out.println("������");
	}
	public void swim(){
		System.out.println("���� "+ pool+"�� �����ġ�� �ִ�.");
	}
	
	public static void main(String[] args){
		Dog d = new Dog();
		d.food = "���";
		d.eat();
		d.bark();
		d.start();
		d.running();
		d.stop();
		d.swim();
		
		Animal a = new Dog();
		a.food = "���";
		a.eat();
		a.bark();
		((Swimmable)a).swim();
		((Runnable)a).start();
		((Runnable)a).running();
		((Runnable)a).stop();
		
		Runnable r = new Dog();
		((Animal)r).food = "��";
		((Animal)r).eat();
		((Animal)r).bark();
		((Swimmable)r).swim();
		r.start();
		r.running();
		r.stop();
		
		Swimmable s = new Dog();
		((Animal)s).food = "��";
		((Animal)s).eat();
		((Animal)s).bark();
		s.swim();
		((Runnable)s).start();
		((Runnable)s).running();
		((Runnable)s).stop();
	}

}
