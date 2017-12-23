package test;

public class TestDeadLock {

	public static void main(String[] args) throws InterruptedException {

		Object obj1 = new Object();
		Object obj2 = new Object();

		Thread t1 = new Thread(() -> {

			synchronized (obj1) {

				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
				synchronized (obj2) {

				}
			}

		});
		Thread t2 = new Thread(() -> {
			synchronized (obj2) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
				synchronized (obj1) {

				}
			}
		});
		t1.start();
		t2.start();
		t1.join(6000);
		t2.join();
	}

}
