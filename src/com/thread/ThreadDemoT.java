package com.thread;

public class ThreadDemoT extends Thread {
	Thread t;
	
	ThreadDemoT(String ThName){
		t = new Thread(this,ThName);
		System.out.println("Thread created:"+t.getName());
	}
	
	public void run(){
		System.out.println("Thread Running:"+t.getName()+" Priority"+t.getPriority());
		
		for (int i=0;i<4;i++){
			System.out.println(t.getName()+": i= " +  i );
			try{
				/*if(t.getName().contains("1"))
				{
					Thread.sleep(100);
				}*/
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Exiting " +  t.getName());
	}
	
	public static void main(String[] arg){
		ThreadDemoT t1= new ThreadDemoT("Thread-11");
		
		ThreadDemoT t2= new ThreadDemoT("Thread-22");
		//t1.t.setDaemon(true);
		t1.t.setPriority(MIN_PRIORITY);
		
		t1.t.start();
		t2.t.start();
		
		//System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
