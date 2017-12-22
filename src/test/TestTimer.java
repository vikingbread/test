package test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestTimer {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<20;i++){
			
			pool.submit(()->{
				
				
				Timer t = new Timer();
				
				t.scheduleAtFixedRate(new TimerTask() {
					public void run() {
						System.out.println(Thread.currentThread().getName());
						
					}
				}, 1000L, 2000L);
				
				try {
					Thread.sleep(10000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.cancel();
			});
		}
		
		Thread thread = new Thread(()->{
			
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread.start();
		thread.join();
		pool.execute(()->{
			
			System.out.println("game over");
			
		});
	}

}
