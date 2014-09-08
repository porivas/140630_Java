package day7;

class Chef{
	private String chefName;
	private String foodName;
	private Server server;

	Chef (String name){
		this.chefName = name;
	}
	Chef (String name, Server server){
		this.chefName = name;
		this.server = server;
	}
	String getName(){
		return chefName;
	}
	void cookFood(String food){
		this.foodName = food;
		System.out.println("�ֹ��� "+this.chefName+"�� "+foodName+"�� �丮�մϴ�. ");
	}
	void finishFood(String food){
		System.out.println("�ֹ��� "+this.chefName+"�� "+foodName+"�� "+server.getName()+"���� �־����ϴ�.");
	}

}

/*	boolean Test(){
		System.out.println("�׽�Ʈ �޼����� �� ��µǾ����ϴ�.");
		return true;
	}*/

class Server{
	private String serverName;
	private String foodNote;
	private Chef chef;					// Ŭ���� ���� ������ �޸� �ּҰ�.
	Server (String name, Chef chef1){	// �����Ǿ� �ִ� Ŭ������ �ּҰ� �Է� ����
		this.serverName = name;
		this.chef= chef1;				// ������ Ŭ���� �ּҰ��� chef�� ����. 
		// ��°�� �̷�����? Ŭ������ �ؾ Ʋ. �ؾ�� ������ ������ �̸� �����ϰ� �;. 
	}
	String getName(){
		return serverName;
	}
	String deliverFoodName(String food){
		this.foodNote = food;
		System.out.println("���� "+this.serverName+"�� "+foodNote+"�� �ֹ濡 ��û�մϴ�.");
		chef.cookFood(foodNote);
		return food;
	}

	

}

public class Customer {
	private String customerName;

	Customer (String name){
		this.customerName = name;
	}
	String getName(){
		return customerName;
	}
	String order(Server s, String foodName){
		System.out.println("�� "+this.customerName+"�� "+ foodName +"�� �ֹ��մϴ�.");
		s.deliverFoodName(foodName);
		
		//ch.finishFood(foodName);
		return foodName;
	}

	public static void main(String[] args){
		Chef ch = new Chef("���ֹ�");
		Server s = new Server("Ȧ����",ch);
//		ch = new Chef("���ֹ�", s);
		Customer c = new Customer("���");
//		System.out.println("���̹� �׽�Ʈ: "+ch.getName()+s.getName()+c.getName());
		String food = c.order(s,"��������");
		System.out.println("�� "+c.getName()+"�� "+food+"�� ���ְ� �Խ��ϴ�.");
	}

}
