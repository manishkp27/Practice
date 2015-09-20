package com.thread;

public class ThreadLocalExample {

	//public 
	static class MyRunnable extends Thread{
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
		
		public void run(){
			threadLocal.set((int)(Math.random()*100D));
			try {Thread.sleep(2000);
            } catch (InterruptedException e) {}
			System.out.println(this.getName() + ", value=" + threadLocal.get());
			//System.out.println(threadLocal.get());
		}
	}
	
	public static void main(String[] arg){
		MyRunnable sharedRunnableInstance  = new MyRunnable();
		
		Thread t1 = new Thread(sharedRunnableInstance);
		System.out.println("create="+t1.getName());
		Thread t2 = new Thread(sharedRunnableInstance);
		System.out.println("create="+t2.getName());
		
		t1.start();t2.start();
	}
}
