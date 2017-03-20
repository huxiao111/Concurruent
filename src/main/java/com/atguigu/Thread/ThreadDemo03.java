package com.atguigu.Thread;

/**
 * 
 * @author wuxiaofei
 *  1	标准普通调用，先打印苹果还是android  p a   
 *2	新添加Thread.sleep(4000),先打印苹果还是android  p a  
 *3	新增加Hello方法，先打印苹果还是hello    h p   
 *4 有两部手机，先打印苹果还是android   a p  
 *5 两个静态同步方法，同一部手机，先打印苹果还是android  p a 
 *6 两个静态同步方法，有两部手机，先打印苹果还是android  p a  
 *7 一个静态同步方法，一个普通同步方法，同一部手机，先打印苹果还是android  a  p  
 *8 一个静态同步方法，一个普通同步方法，有两部手机，先打印苹果还是android  a p  
 */

class SharaSource{
	
	public static synchronized void getPhone() throws Exception{
		
		Thread.sleep(4000);
		
		System.out.println("----getPhone");
	}
	
	public static synchronized void getAndroid(){
		System.out.println("-----getAndroid");
	}
	
	public void getHello(){
		
		System.out.println("-----Hello");
	}

}

public class ThreadDemo03{
	
	public static void main(String[] args) {
		
		final SharaSource ss=new SharaSource();
		
		final SharaSource ss02=new SharaSource();
		
		new Thread(new Runnable() {
			
			public void run() {
			
				try {
					
					ss.getPhone();
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}
				
			}
		},"AA").start();
		
		new Thread(new Runnable() {
			
			public void run() {
				
				try {
					
					//ss.getAndroid();
					
					//ss.getHello();
					
					ss02.getAndroid();
					
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			}
		},"BB").start();
	}
}

