package com.thread;

public class ThreadPractice  implements Runnable {
		private Thread t;
		private String threadName;
		static int s2;
		static int s1;
		ThreadPractice(String threadName){
			this.threadName = threadName;
			System.out.println("Thread Created:"+this.threadName);			
		}
		
		public void run(){
			System.out.println("Running " +  threadName +" s1="+s1+ " s2="+s2);
			
			for (int i=0;i<5;i++){
				if(threadName.contains("1"))
					s1++;
				else
					s2++;
				System.out.println(threadName+": i= " +  i +" s1="+ s1+" s2="+s2+" s1+s2="+(s1+s2));
				try{
					Thread.sleep(50);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println("Exiting " +  threadName +" s1="+s1+ " s2="+s2);
		}
		
		void begin(){
			if(t == null){
				t= new Thread(this, this.threadName);
				t.start();
			}
			
		}
		static String x;
		  static char y;
		  static Integer z;
		  static double r;
		  static int q;
		  static int s3;
			static int s4;
	public static void main(String[] var){
		ThreadPractice R1 = new ThreadPractice( "Thread-1");
		R1.begin();
		
		
		ThreadPractice R2 = new ThreadPractice("Thread-2");
		R2.begin();
		
		
		 /* 
		  
		  System.out.println(x);
		  System.out.println(y);
		  System.out.println(z);
		  System.out.println(r);
		  System.out.println(q);
		  System.out.println(q=='\u0000');
		  
		  System.out.println(s3);
		  System.out.println(s4);*/
	}
}
