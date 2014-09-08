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
		Person hong = new Person("ȫ�浿");
		Person sa = new Person("�����");

		String hongName = hong.getName();
		System.out.println("���̸�=>"+hongName);

		hong.setFriend(sa);
		Person friend = hong.getFriend();
		System.out.println("��ģ���̸�=>"+friend.getName());
		System.out.println("��ģ���̸�=>"+hong.getFriend().getName());
		System.out.println("��ģ���̸�=>"+hong.getFriendName());

	}

}
