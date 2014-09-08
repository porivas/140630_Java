package day10;

final class Parents{}
// class Child extends Parents{}
class Parents1 {
	public final void method(){}
}

class Animal2{

}
class Person extends Animal2{

}
class Student extends Person{

}
public class InstanceOfTest{
	public static void main(String[] args){
		Animal2 t = new Student();
		if(t instanceof Student)
			System.out.println("Student");
		else if (t instanceof Person)
			System.out.println("Person");
		else if (t instanceof Animal2)
			System.out.println("Animal");

		if (t instanceof Animal2)
			System.out.println("Animal");
		else if (t instanceof Person)
			System.out.println("Person");
		else if(t instanceof Student)
			System.out.println("Student");
	}
}