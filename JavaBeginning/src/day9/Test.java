package day9;
//자바의 모든 클래스는 Object 클래스를 상속받는다.
class Test {
	int a;
	Test(int a){
		this.a=a;
	}
	public static void main(String[] args){
		Test t= new Test(1);
		System.out.println(t.toString());
		Test t1 = new Test(10);
		Test t2 = new Test(10);
		if (t1.equals(t2))
			System.out.println("같음1");
		Test t3 = t1;
		if (t1 == t3)
			System.out.println("같음2");
		if(t1.equals(t3))
			System.out.println("같음3");
	}
}
class Student{
	private String name;
	private String id;
	public Student(String name, String id){
		this.name = name;
		this.id = id;
	}
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setId(String id){
		this.id = id;
	}
	public String toString(){
		return "이름 ="+name+", 학번="+id;
	}
	public boolean equals(Object obj){
		boolean ok = false;
		if (obj instanceof Student){
			Student s = (Student)obj;
			if(name.equals(s.getName()) && id.equals(s.getId()))
				ok = true;
			else
				ok = false;
		}
		return ok;
	}
}
class StudentTest{
	public static void main(String[] args){
		Student s1 = new Student("홍길동","1111");
		Student s2 = new Student("홍길동","1111");
		if(s1.equals(s2))
			System.out.println("같은 학생"+s1);
		s1.setName("홍길순");
		if(s1.equals(s2))
			System.out.println("같은 학생"+s1);

	}
}
