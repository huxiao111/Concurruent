package com.atguigu.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyResource{

	 private int number=1;
	 
	 private Lock lock=new ReentrantLock();
	 
	 private Condition condition01=lock.newCondition();
	 
	 private Condition condition02=lock.newCondition();
	 
	 private Condition condition03=lock.newCondition();
	 
	 public void LoopAA(int totalLoop){
		 
		 lock.lock();
		 
		 try {
			 
			 while (number!=1) {
				
				 condition01.await();
			}
			 
			 for (int i = 1; i <=5; i++) {
				
				 System.out.println(Thread.currentThread().getName()+"--"+i+"第:"+totalLoop+"轮");
			}
			 
			 number=2;
			 
			 condition02.signal();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			
			lock.unlock();
		}
	 }
	 
	public void LoopBB(int totalLoop){
		
		lock.lock();
		
		try {
			
			while (number!=2) {
				
				condition02.await();
			}
			
			for (int i = 1; i <=10; i++) {
				
				System.out.println(Thread.currentThread().getName()+"---"+i+"第"+totalLoop);
			}
			     number=3;
			   
			   condition03.signal();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			
			lock.unlock();
		}
	}
	
	public void LoopCC(int totalLoop){
		
		lock.lock();
		
		try {
			
			while (number!=3) {
				
				condition03.await();
			}
			
			for (int i = 1; i <=15; i++) {
				
				System.out.println(Thread.currentThread().getName()+"---"+i+"第"+totalLoop);
			}
			
			number=1;
			
			condition01.signal();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally{
			
			lock.unlock();
		}
	}
	
}

public class ThreadDemo04{
	
	public static void main(String[] args) {
		
	  final MyResource myResource = new MyResource();
		
		new Thread(new Runnable() {
			
			public void run() {
				
				for (int i = 1; i <=20; i++) {
					
					myResource.LoopAA(i);
				}
			
			}
		},"AA").start();
		
		new Thread(new Runnable() {
			
			public void run() {
				
				for (int i = 1; i <= 20; i++) {
					
					myResource.LoopBB(i);
				}
			}
		},"BB").start();
		
		new Thread(new Runnable() {
			
			public void run() {
				
				for (int i =1; i <= 20; i++) {
					
					myResource.LoopCC(i);
				}
			}
		},"CC").start();
	}
}
