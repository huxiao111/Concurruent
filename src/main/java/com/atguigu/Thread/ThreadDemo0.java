package com.atguigu.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
	
	private int number = 30;
	
	private Lock lock=new ReentrantLock();
	
	public void sale(){
		
		lock.lock();
		
		try {
			
			if (number>0) {
				
				Thread.sleep(500);
				
				System.out.println(Thread.currentThread().getName()+":卖出第"+(number)--+"还剩:"+number);
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}finally{
			
			lock.unlock();
		}
	}

}

public class ThreadDemo0{
	
	public static void main(String[] args) {
		
		final Ticket ticket = new Ticket();
		
		new Thread(new Runnable() {
			
			public void run() {
				
				for (int i = 0; i < 40; i++) {
					
					ticket.sale();
				}
				
			}
			
		},"AA").start();
		
		
		 new Thread(new Runnable() {
			
			public void run() {
				
				for (int i = 0; i < 40; i++) {
					
					ticket.sale();
				}
				
			}
		},"BB").start();
		 
		 
		 new Thread(new Runnable() {
			
			public void run() {
				
				for (int i = 0; i < 40; i++) {
					
					ticket.sale();
				}
			}
		},"CC").start();
		
	}
	
}
