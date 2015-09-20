package com.thread;

public class ThreadVsRunnable {
	public static void main(String args[]) throws Exception {
	     //Multiple threads share the same object.
	     ImplementsRunnable rc = new ImplementsRunnable();
	     Thread t1 = new Thread(rc);
	     t1.start();
	     Thread.sleep(1000); // Waiting for 1 second before starting next thread
	     Thread t2 = new Thread(rc);
	     t2.start();
	     Thread.sleep(1000); // Waiting for 1 second before starting next thread
	     Thread t3 = new Thread(rc);
	     t3.start();

	     //Creating new instance for every thread access.
	     ExtendsThread tc1 = new ExtendsThread();
	     tc1.start();
	     Thread.sleep(1000); // Waiting for 1 second before starting next thread
	     ExtendsThread tc2 = new ExtendsThread();
	     tc2.start();
	     Thread.sleep(1000); // Waiting for 1 second before starting next thread
	     ExtendsThread tc3 = new ExtendsThread();
	     tc3.start();
	   }
	
	/*public static void main(String args[]) throws Exception {
	    //Multiple threads share the same object.
	    ImplementsRunnable rc = new ImplementsRunnable();
	    Thread t1 = new Thread(rc);
	    t1.start();
	    Thread.sleep(1000); // Waiting for 1 second before starting next thread
	    Thread t2 = new Thread(rc);
	    t2.start();
	    Thread.sleep(1000); // Waiting for 1 second before starting next thread
	    Thread t3 = new Thread(rc);
	    t3.start();

	    //Modification done here. Only one object is shered by multiple threads here also.
	    ExtendsThread extendsThread = new ExtendsThread();
	    Thread thread11 = new Thread(extendsThread);
	    thread11.start();
	    Thread.sleep(1000);
	    Thread thread12 = new Thread(extendsThread);
	    thread12.start();
	    Thread.sleep(1000);
	    Thread thread13 = new Thread(extendsThread);
	    thread13.start();
	    Thread.sleep(1000);
	  }*/
}
class ImplementsRunnable implements Runnable {

	  private int counter = 0;

	  public void run() {
	    counter++;
	    System.out.println("ImplementsRunnable : Counter : " + counter);
	  }
	}

class ExtendsThread extends Thread {

	  private int counter = 0;

	  public void run() {
	    counter++;
	    System.out.println("ExtendsThread : Counter : " + counter);
	  }
	}