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
			return this.name1+"의 시계: "+ this.watch1.whatTime();
		else
			return this.name1+"은/는 지금 시계가 없어요 ㅠ ㅠ";
	}
	public void setWatch(Watch watch){
		this.watch1 = watch;
		System.out.println(this.name1+"의 시계를 새로 샀습니다.");
//		return new watch();
	}

}


public class WatchTest {
	public static void main(String[]args){
		Person1 p = new Person1("홍길동", null);

		System.out.println(p.whatTime());
		//		
				p.setWatch(new Watch());
				System.out.println(p.whatTime());
		//
		Watch watch = new Watch();
		Person1 p1 = new Person1("사오정", watch);
		//		
		System.out.println(p1.whatTime());

		//		Watch watch = new Watch();
		//		System.out.println(watch.whatTime());
	}

}
