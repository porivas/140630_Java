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
		System.out.println("주방장 "+this.chefName+"이 "+foodName+"을 요리합니다. ");
	}
	void finishFood(String food){
		System.out.println("주방장 "+this.chefName+"이 "+foodName+"을 "+server.getName()+"에게 주었습니다.");
	}

}

/*	boolean Test(){
		System.out.println("테스트 메세지가 잘 출력되었습니다.");
		return true;
	}*/

class Server{
	private String serverName;
	private String foodNote;
	private Chef chef;					// 클래스 생성 예정인 메모리 주소값.
	Server (String name, Chef chef1){	// 생성되어 있는 클래스의 주소값 입력 받음
		this.serverName = name;
		this.chef= chef1;				// 생성된 클래스 주소값을 chef에 복사. 
		// 어째서 이런짓을? 클래스는 붕어빵 틀. 붕어빵이 구워진 다음에 이를 조작하고 싶어서. 
	}
	String getName(){
		return serverName;
	}
	String deliverFoodName(String food){
		this.foodNote = food;
		System.out.println("서버 "+this.serverName+"가 "+foodNote+"을 주방에 요청합니다.");
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
		System.out.println("고객 "+this.customerName+"이 "+ foodName +"을 주문합니다.");
		s.deliverFoodName(foodName);
		
		//ch.finishFood(foodName);
		return foodName;
	}

	public static void main(String[] args){
		Chef ch = new Chef("최주방");
		Server s = new Server("홀서버",ch);
//		ch = new Chef("최주방", s);
		Customer c = new Customer("김고객");
//		System.out.println("네이밍 테스트: "+ch.getName()+s.getName()+c.getName());
		String food = c.order(s,"낙지볶음");
		System.out.println("고객 "+c.getName()+"이 "+food+"을 맛있게 먹습니다.");
	}

}
