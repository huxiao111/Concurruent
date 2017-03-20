package com.atguigu.Thread;

class B implements Runnable
{
    int i;
    
	public void run() {
		
		try {
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("11111");
		
		i=100;
	}

}

public class Test01{
	
	public static void main(String[] args) throws InterruptedException{
		
		B b = new B();
		
		Thread t = new Thread(b);
		
		t.start();
		
		t.join();
		
		Thread.sleep(1000);
		
		int j=b.i;
		
		System.out.println(j);
	}
	
}
