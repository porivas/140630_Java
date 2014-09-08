package day6;

//public class Student1 {

class Student1{
	String name;
	int age;
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;	
	}
	public void set(String name, int age){
		setName(name);
		setAge(age);
	}
	public void set(int age, String name){
		setName(name);
		setAge(age);
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public void printInfo(){
		System.out.println("이름="+name);
		System.out.println("나이="+age);
	}

	public Student1(){

	}
	public Student1(String name, int age){
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args){
		Student1 a = new Student1();
		a.printInfo();
		a.setName("홍길동");
		a.setAge(20);
		a.printInfo();
		a.setName("홍기수");
		a.setAge(21);
		System.out.println("이름="+a.getName());
		System.out.println("나이="+a.getAge());
		
		Student1 b = new Student1("사오정", 22);
		b.printInfo();
		b.setAge(23);
		b.printInfo();
		
		Student1 c = new Student1("저팔계", 22);
		c.printInfo();
		c.set(23, "저구계");
		System.out.println("이름="+c.getName());
		System.out.println("나이="+c.getAge());
		
	}
}


//}
