package com.atguigu.Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo06 {
	
	
    public static void main(String[] args) {
		  
    	//ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
    	
    	//ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
    	
    	ExecutorService threadPool = Executors.newCachedThreadPool();
    	
    	Future <Integer> result=null;
    	
    	try {
			
    		for (int i = 0; i < 20; i++) {
    			
    		result  = threadPool.submit(new Callable<Integer>() {

					public Integer call() throws Exception {
						
						Thread.sleep(1000);
						
						System.out.print(Thread.currentThread().getName()+"----");
						
						return new Random().nextInt(10);
					}
				});
    		
    		    System.out.println("-----"+result.get());
				
			}
    		
    		
		} catch (Exception e) {

            e.printStackTrace();
            
		}finally{
			
			threadPool.shutdown();
		}
    	
	}
    
    
}



