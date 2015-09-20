package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {  
    public static void main(String[] args) throws InterruptedException {  
       ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads  
       for (int i = 0; i < 5; i++) {  
           Runnable worker = new MyThread("" + i);  
           executor.execute(worker);//calling execute method of ExecutorService
           //worker.run();
         }  
       executor.shutdown();  
       System.out.println("shutDown() started");
       while (!executor.isTerminated()) {        System.out.println("isTerminated()"); Thread.sleep(10); }  
 
       System.out.println("Finished all threads");  
   }  
} 

class MyThread implements Runnable{
	String message;
	MyThread(String message){
		this.message=message;
	}
	
	public void run() {
		  try {
			  System.out.println(this.message);
			  Thread.sleep(200);  } catch (InterruptedException e) { e.printStackTrace(); }  
	}
}