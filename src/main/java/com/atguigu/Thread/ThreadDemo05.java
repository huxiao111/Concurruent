package com.atguigu.Thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyQueue{

	  private Object obj;
	  
	  private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

     public void set(Object obj){
    	 
    	 readWriteLock.writeLock().lock();
    	 
    	 try {
    		 
    		 this.obj=obj;
    		 
    		 System.out.println(Thread.currentThread().getName()+"------"+obj);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			
			 readWriteLock.writeLock().unlock();
		}
     }
     
     public void get(){
    	 
    	 readWriteLock.writeLock().lock();
    	 
    	 try {
    		 
    		 System.out.println(Thread.currentThread().getName()+"======"+obj);
			
		} catch (Exception e) {
   
         e.printStackTrace(); 
         
		}finally{
			
			readWriteLock.writeLock().unlock();
		}
    	 
     }
}

public class ThreadDemo05{
	
	public static void main(String[] args) {
		
		final MyQueue myQueue = new MyQueue();
		
		
		
		new Thread(new Runnable() {
			
			public void run() {
			
				 myQueue.set(new Random().nextInt(10));
			}
		},"AA").start();
		
		
		
		for (int i = 1; i <=100; i++) {
			
			new Thread(new Runnable() {
				
				public void run() {
					
					myQueue.get();
		
				}
			},String.valueOf(i)).start();
			
		}
		
	}
}
