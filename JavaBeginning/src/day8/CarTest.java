package day8;

class Car {
	private int speed; // �ӵ�
	private int mileage; // ����Ÿ�
	private String color; // ����

	public Car(){
		speed = mileage = 0;
		color = "red";
	}
	public void speedUp(){
		speed += 10;
	}
	public String toString(){
		return "�ӵ�: "+speed+"����Ÿ�: "+mileage+" ����: "+color;
	}
}
public class CarTest{
	public static void main(String[] args){
		Car[] cars = new Car[5];
		for (int i = 0; i < cars.length; i++)
			cars[i] = new Car();
		for(int i=0; i<cars.length; i++)
			cars[i].speedUp();
		for(int i =0; i< cars.length; i++)
			System.out.println(cars[i]);
	}

}


