package com.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

//https://dzone.com/articles/how-analyze-java-thread-dumps

//Coding for Easy Thread Dump Naming Threads
 class MyThreadFactory implements ThreadFactory {
	private static final ConcurrentHashMap<String, AtomicInteger> POOL_NUMBER = new ConcurrentHashMap<String, AtomicInteger>();
	private final ThreadGroup group;
	private final AtomicInteger threadNumber = new AtomicInteger(1);
	private final String namePrefix;

	public MyThreadFactory(String threadPoolName) {
		if (threadPoolName == null) {
			throw new NullPointerException("threadPoolName");
		}
		POOL_NUMBER.putIfAbsent(threadPoolName, new AtomicInteger());
		SecurityManager securityManager = System.getSecurityManager();
		group = (securityManager != null) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
		AtomicInteger poolCount = POOL_NUMBER.get(threadPoolName);
		if (poolCount == null) {
			namePrefix = threadPoolName + " pool-00-thread-";
		} else {
			namePrefix = threadPoolName + " pool-" + poolCount.getAndIncrement() + "-thread-";
		}
	}

	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(group, runnable, namePrefix + threadNumber.getAndIncrement(), 0);
		if (thread.isDaemon()) {
			thread.setDaemon(false);
		}
		if (thread.getPriority() != Thread.NORM_PRIORITY) {
			thread.setPriority(Thread.NORM_PRIORITY);
		}
		return thread;
	}
}

 public class ThreadDumps {

	public static void main(String[] args) throws InterruptedException {
		MyThreadFactory mtf = new MyThreadFactory("myThFact1A");
		mtf.newThread(new MyRunnable()).start();
		
		mtf = new MyThreadFactory("myThFact1B");
		mtf.newThread(new MyRunnable()).start();
		
		mtf = new MyThreadFactory("myThFact1B");
		mtf.newThread(new MyRunnable()).start();
		
		ThreadGroup tg = new ThreadGroup("myTG1");
		Thread t2 = new Thread(tg, new MyRunnable());
		t2.start();
		
		//Obtaining More Detailed Information by Using MBean
		getMoredetails();
		
		//Thread pool
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.execute(new MyRunnable());
		es.shutdown();

		es = Executors.newFixedThreadPool(5);
		es.execute(new MyRunnable());
		
		t2.join();
		//Obtaining More Detailed Information by Using MBean
		getMoredetails();
		
		es.shutdown();
	}
	static void getMoredetails(){
		ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = mxBean.getAllThreadIds();
		ThreadInfo[] threadInfos = mxBean.getThreadInfo(threadIds);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.print(" "+threadInfo.getThreadName());
			System.out.print("\t BlockedCount="+threadInfo.getBlockedCount());
			System.out.print("\t BlockedTime="+threadInfo.getBlockedTime());
			System.out.print("\t WaitedCount="+threadInfo.getWaitedCount());
			System.out.println("\t WaitedTime="+threadInfo.getWaitedTime());
		}
	}

}

class MyRunnable implements Runnable{
	public void run(){
		try {
			synchronized(this){wait(10);wait(10);}
		} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("MyRunnable thread name:"+Thread.currentThread().getName());
	}
}
