package thread1;

public class Horse extends Thread {
	
	private String name;
	private int pos;
	
	public Horse(String name) {
		super();
		this.name = name;
		this.pos = 0;
	}

	public void gallop(){
		for (int i =0; i<100; i++){
			pos += (int)(Math.random()*10);
			System.out.println(name+":"+pos);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		gallop();
		// TODO Auto-generated method stub
		super.run();
	}
	
	
}
