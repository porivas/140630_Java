package sync1;

public class SyncEx implements Runnable {

	// Java에서 문법적으로 쓰레드를 지원한다라고 말한다.  synchronized는 객체에 걸리는 락(lock)이라고 한다.
	//	public synchronized void doJob(){
	//		for (int i = 0; i < 100; i++) {
	//			System.out.println(Thread.currentThread().getName()+":"+i);
	//		}
	//	}

	public void doJob(){
		synchronized(this){
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		doJob();

	}

	public static void main(String[] args) {
		SyncEx obj = new SyncEx();

		Thread t0 = new Thread(obj);
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		// 경쟁관계에 있다. racecondition. 객체 하나에 여러가지의 쓰레드가 
		t0.start();
		t1.start();
		t2.start();

	}



}
