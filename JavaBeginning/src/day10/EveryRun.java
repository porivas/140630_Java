package day10;

interface Runnable2{
	final static int MAXSPEED = 50;
	int MINSPEED = 10;

	public void start();
	public void running();
	public void stop();
}

class Park implements Runnable2{
	public void start(){
		System.out.println("Park MAXSPEED= "+MAXSPEED);
		System.out.println("Park 2시에 두발로 뛰기 시작한다.");
	}
	public void running(){
		System.out.println("Park 1시간째 두발로 뛰고 있다.");
	}
	public void stop(){
		System.out.println("Park 3시 10분에 두발로 멈추었다.");
	}
}

class Buldog implements Runnable2{
	public void start(){
		System.out.println("Buldog이 네발로 출발한다.");
	}
	public void running(){
		System.out.println("Buldog 최고 속도로 4발로 뛴다.");
	}
	public void stop(){
		System.out.println("Buldog 먹이를 보고 멈추었다.");
	}
}

public class EveryRun {
	public static void main(String[] args){
//		Park pk = new Park();
		Runnable2 pk = new Park();
		pk.start();
		
		Buldog bd = new Buldog();
		bd.stop();
	}

}
