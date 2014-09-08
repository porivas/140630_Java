package day10;

public class Car {
	
	static int serialNum;
	String color;
	String model;
	String owner;
	
	Car(String color, String model, String owner){
		this.color = color;
		this.model = model;
		this.owner = owner;
		serialNum++;
	}
	static int getSerial(){
		return serialNum;
	}
	public static void main(String[] args){
		Car c1 = new Car("Red","Matiz","손오공");
		Car c2 = new Car("Blue", "Sonata", "저팔계");
		Car c3 = new Car("Green", "Rezzo", "사오정");
		System.out.println("지금까지의 시리얼넘버: "+ Car.serialNum);
		System.out.println("지금까지의 시리얼넘버: "+ Car.getSerial());

	}

}
