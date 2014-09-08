package day9;

class NotebookComp extends Computer {
	private int battery;
	public NotebookComp(String name, int initChag){
		super(name);
		battery = initChag;
	}
	public void charge(){
		battery +=5;
	}
	public void useBattery(){
		battery -=1;
	}
	public void movingCar(){
		//		if(getBatteryInfo()<1){
		//		System.out.println("충전이 필요합니다.");
		//		return;			// 리턴이 있으면 이 필드에서 계산이 끝난다. 
		//		}
		if(batteryCheck() == true){
			System.out.println("이동하면서");
			calculate();
			useBattery();	
		}
	}
	public int getBatteryInfo(){
		return battery;
	}
	public boolean batteryCheck(){
		if(getBatteryInfo()<1){
			System.out.println("충전이 필요합니다.");
			return false;
		}
		else
				return true;
		}
}