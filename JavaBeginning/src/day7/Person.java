package day7;

public class Person {
	private String name;
	private Person friend;

	public Person(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setFriend(Person friend){
		this.friend = friend;
	}
	public Person getFriend(){
		return friend;
	}
	public String getFriendName(){
		return friend.getName();
	}

	public static void main(String[] args){
		Person hong = new Person("홍길동");
		Person sa = new Person("사오정");

		String hongName = hong.getName();
		System.out.println("내이름=>"+hongName);

		hong.setFriend(sa);
		Person friend = hong.getFriend();
		System.out.println("내친구이름=>"+friend.getName());
		System.out.println("내친구이름=>"+hong.getFriend().getName());
		System.out.println("내친구이름=>"+hong.getFriendName());

	}

}
