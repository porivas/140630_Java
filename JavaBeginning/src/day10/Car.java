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
		Car c1 = new Car("Red","Matiz","�տ���");
		Car c2 = new Car("Blue", "Sonata", "���Ȱ�");
		Car c3 = new Car("Green", "Rezzo", "�����");
		System.out.println("���ݱ����� �ø���ѹ�: "+ Car.serialNum);
		System.out.println("���ݱ����� �ø���ѹ�: "+ Car.getSerial());

	}

}
