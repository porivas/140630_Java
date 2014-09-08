package sync1;

public class SyncEx implements Runnable {

	// Java���� ���������� �����带 �����Ѵٶ�� ���Ѵ�.  synchronized�� ��ü�� �ɸ��� ��(lock)�̶�� �Ѵ�.
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
		// ������迡 �ִ�. racecondition. ��ü �ϳ��� ���������� �����尡 
		t0.start();
		t1.start();
		t2.start();

	}



}
