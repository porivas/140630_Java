package day6;


class Car{
	int velocity;
	int wheelNum;
	String carName;

	public void speedUp(){
		velocity = velocity+1;
	}

	public void speedDown(){
		velocity = velocity-1;
	}

	public void stop(){
		velocity = 0;
	}
}

public class CarTest{
	public static void main (String args[]){

		Car myCar;

		myCar = new Car();
		myCar.speedUp();
		myCar.carName = "소나타";
		System.out.println(myCar.carName+"의 속도는" + myCar.velocity);
	}
}
