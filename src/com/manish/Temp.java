package com.manish;

import java.util.*;
import java.lang.Class;

public class Temp {  
	 public static void main(String... ar) throws CloneNotSupportedException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		 /*Employee1 e1= new Employee1();
		 Class class1=e1.getClass();
		 System.out.println(" getName():"+class1.getName());
		 System.out.println(" getSuperclass()"+class1.getSuperclass());
		 
		 Class class11=class1.getClass();
		 System.out.println(" getName():"+class11.getName());
		 System.out.println(" getSuperclass()"+class11.getSuperclass());
		 
		 Class c1 = Class.forName("com.manish.Employee1");
		 Object e2=c1.newInstance();
		 
		 Class c2= Employee.class;
		 System.out.println(c2.getClass());
		 
		 Employee1 o1 = new Employee1();
		 if(o1.getClass()==Employee1.class){
			 System.out.println("o1.getClass()==Employee.class");
		 }*/
		 
		 /*Object  str = new Integer("2000");
		 if(str.getClass() == Integer.class){
	            System.out.println("its integer");
	        }*/
		 Byte b=0b00000011;
		 //System.out.println((b||b));
	  }
	  
}	
class Employee1 {
	
	public void finalize(){
		System.out.println("finalize()");
	}
	native public void func1();
	protected  native Object clone() throws CloneNotSupportedException;
}

class Emp2 extends Employee1{
	Emp2(){
		System.out.println("Emp2");
	}
}


 