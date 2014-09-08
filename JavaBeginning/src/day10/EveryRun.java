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
		System.out.println("Park 2�ÿ� �ι߷� �ٱ� �����Ѵ�.");
	}
	public void running(){
		System.out.println("Park 1�ð�° �ι߷� �ٰ� �ִ�.");
	}
	public void stop(){
		System.out.println("Park 3�� 10�п� �ι߷� ���߾���.");
	}
}

class Buldog implements Runnable2{
	public void start(){
		System.out.println("Buldog�� �׹߷� ����Ѵ�.");
	}
	public void running(){
		System.out.println("Buldog �ְ� �ӵ��� 4�߷� �ڴ�.");
	}
	public void stop(){
		System.out.println("Buldog ���̸� ���� ���߾���.");
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
