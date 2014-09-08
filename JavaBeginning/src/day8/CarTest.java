package day8;

class Car {
	private int speed; // 加档
	private int mileage; // 林青芭府
	private String color; // 祸惑

	public Car(){
		speed = mileage = 0;
		color = "red";
	}
	public void speedUp(){
		speed += 10;
	}
	public String toString(){
		return "加档: "+speed+"林青芭府: "+mileage+" 祸惑: "+color;
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


