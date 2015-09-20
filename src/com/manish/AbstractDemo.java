package com.manish;

public class AbstractDemo {
	
	public static void main(String[] arg){
	
		Employee emp1 = new Salary("nam1","ad1",1,10);
		Salary emp2 = new Salary("nam2","ad2",2,20);
		
		emp1.mailCheck();
		emp2.mailCheck();
	};
}
interface intrfce{
	int i=0;
	abstract int fuc();
}

//Filename: Sports.java
interface Sports
{
 public void setHomeTeam(String name);
 public void setVisitingTeam(String name);
}

//Filename: Football.java
interface Football extends Sports
{
 public void homeTeamScored(int points);
 public void visitingTeamScored(int points);
 public void endOfQuarter(int quarter);
}
class Salary extends Employee implements intrfce
{
   private double salary; //Annual salary
   
   public int fuc(){return i;}
   
   public Salary(String name, String address, int number, double
      salary)
   {
       super(name, address, number);
       setSalary(salary);
   }
   public void mailCheck()
   {
       System.out.println("Within mailCheck of Salary class ");
       System.out.println("Mailing check to " + getName()
       + " with salary " + salary);
   }
   public double getSalary()
   {
       return salary;
   }
   public void setSalary(double newSalary)
   {
       if(newSalary >= 0.0)
       {
          salary = newSalary;
       }
   }
   public double computePay()
   {
      System.out.println("Computing salary pay for " + getName());
      return salary/52;
   }
}

abstract class 

{
   private String name;
   private String address;
   private int number;
   public Employee(String name, String address, int number)
   {
      System.out.println("Constructing an Employee");
      this.name = name;
      this.address = address;
      this.number = number;
   }
   public double computePay()
   {
     System.out.println("Inside Employee computePay");
     return 0.0;
   }
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + this.name
       + " " + this.address);
   }
   public String toString()
   {
      return name + " " + address + " " + number;
   }
   public String getName()
   {
      return name;
   }
   public String getAddress()
   {
      return address;
   }
   public void setAddress(String newAddress)
   {
      address = newAddress;
   }
   public int getNumber()
   {
     return number;
   }
}