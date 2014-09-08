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
		//		System.out.println("������ �ʿ��մϴ�.");
		//		return;			// ������ ������ �� �ʵ忡�� ����� ������. 
		//		}
		if(batteryCheck() == true){
			System.out.println("�̵��ϸ鼭");
			calculate();
			useBattery();	
		}
	}
	public int getBatteryInfo(){
		return battery;
	}
	public boolean batteryCheck(){
		if(getBatteryInfo()<1){
			System.out.println("������ �ʿ��մϴ�.");
			return false;
		}
		else
				return true;
		}
}