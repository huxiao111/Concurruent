package com.atguigu.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {

	public Integer call() throws Exception {
		
		System.out.println("call()-----come on");;
		
		return 200;
	}

}

public class ThreadDemo01{
	
	  public static void main(String[] args) {
		
		  FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
		  
		  new Thread(futureTask).start();
		  
		  //可以运行其他线程  运行不影响callable这个线程运行
		  
		  try {
			  
			System.out.println(futureTask.get());
			
		} catch (InterruptedException e) {
	
			e.printStackTrace();
			
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
		
		  //结果相加
	}
	
}
