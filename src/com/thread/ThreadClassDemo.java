package com.thread;

public class ThreadClassDemo {
	public static void main(String [] args)
	   {
	      Runnable hello = new DisplayMessage("Hello");
	      Thread thread1 = new Thread(hello);
	      thread1.setDaemon(true);
	      thread1.setName("Thhello");
	      System.out.println("Starting hello thread...");
	      thread1.start();
	      
	      Runnable bye = new DisplayMessage("Goodbye");
	      Thread thread2 = new Thread(bye);
	      thread2.setPriority(Thread.MIN_PRIORITY);
	      thread2.setDaemon(true);
	      thread1.setName("ThGoodbye");
	      System.out.println("Starting goodbye thread...");
	      thread2.start();

	      System.out.println("Starting threadGuess1...");
	      Thread thread3 = new GuessANumber(2);
	      thread3.setName("ThGuess1");
	      thread3.start();
	      try
	      {
	         thread3.join();
	      }catch(InterruptedException e)
	      {
	         System.out.println("Thread interrupted.");
	      }
	      System.out.println("Starting threadGuess2...");
	      Thread thread4 = new GuessANumber(3);
	      thread4.setName("ThGuess2");
		  thread4.start();
	      System.out.println("main() is ending...");
	   }
}
class GuessANumber extends Thread
{
   private int number;
   public GuessANumber(int number)
   {
      this.number = number;
   }
   public void run()
   {
      int counter = 0;
      int guess = 0;
      do
      {
          guess = (int) (Math.random() * 5 + 1);
          System.out.println("guess="+guess+", "+this.getName()
                       + " guesses " + guess);
          counter++;
          try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
      }while(guess != number);
      System.out.println("** Correct! " + this.getName()
                       + " in " + counter + " guesses.**");
   }
}
class DisplayMessage implements Runnable
{
   private String message;
   public DisplayMessage(String message)
   {
      this.message = message;
   }
   public void run()
   {
      while(true)
      {
         System.out.println(message);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
      }
   }
}
