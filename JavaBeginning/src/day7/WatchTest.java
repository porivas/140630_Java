package day7;

class Person1{

	String name1;
	Watch watch1;

	public Person1(String name, Watch watch)
	{
		this.name1 = name;
		this.watch1 = watch;
	}
	public String whatTime(){
		if (this.watch1 != null)
			return this.name1+"�� �ð�: "+ this.watch1.whatTime();
		else
			return this.name1+"��/�� ���� �ð谡 ����� �� ��";
	}
	public void setWatch(Watch watch){
		this.watch1 = watch;
		System.out.println(this.name1+"�� �ð踦 ���� ����ϴ�.");
//		return new watch();
	}

}


public class WatchTest {
	public static void main(String[]args){
		Person1 p = new Person1("ȫ�浿", null);

		System.out.println(p.whatTime());
		//		
				p.setWatch(new Watch());
				System.out.println(p.whatTime());
		//
		Watch watch = new Watch();
		Person1 p1 = new Person1("�����", watch);
		//		
		System.out.println(p1.whatTime());

		//		Watch watch = new Watch();
		//		System.out.println(watch.whatTime());
	}

}
