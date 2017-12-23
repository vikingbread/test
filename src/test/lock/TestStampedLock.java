package test.lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class TestStampedLock {

	public static void main(String[] args) throws InterruptedException {

		final StampedLock lock = new StampedLock();

		new Thread() {

			public void run() {

				long readLong = lock.writeLock();

				LockSupport.parkNanos(61000000000L);

				lock.unlockWrite(readLong);

			}

		}.start();

		Thread.sleep(100);

		for (int i = 0; i < 3; ++i)

			new Thread(new OccupiedCPUReadThread(lock),"thread-"+i).start();

	}

	private static class OccupiedCPUReadThread implements Runnable {

		private StampedLock lock;

		public OccupiedCPUReadThread(StampedLock lock) {
			this.lock = lock;
		}

		public void run() {

			Thread currentThread = Thread.currentThread();
			currentThread.interrupt();
			Thread.interrupted();
			long lockr = lock.readLock();

			System.out.println(currentThread.getName()
					+ " get read lock");

			lock.unlockRead(lockr);

		}

	}

}