package com.atguigu.Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ThreadDemo6 {
	
	public static void main(String[] args) {
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
		
		ScheduledFuture <Integer> result = null;
		
		try {
			
			for (int i = 0; i < 20; i++) {
				
				result = service.schedule(new Callable<Integer>() {

					public Integer call() throws Exception {
						
						System.out.print(Thread.currentThread().getName());
						
						return new Random().nextInt(10);
					}
				}, 3, TimeUnit.SECONDS);
				
				System.out.println("----"+result.get());
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			
			service.shutdown();
		}
		
	}
	
	public static void ThreadTest(){
		
		
		
	}

}
