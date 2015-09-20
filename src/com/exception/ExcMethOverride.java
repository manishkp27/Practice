package com.exception;

import java.io.IOException;

public class ExcMethOverride {

	//public static void main(String[] args) throws IOException {
	public static void main(String[] args) {
		try{
		Validate(12);
		}
		catch(InvalidAgeExc e){
			e.printStackTrace();
		}
		finally{
			System.out.println("completed");
		}
	}
	
	static void Validate(int age) throws InvalidAgeExc{
		if(age<18)
			throw new InvalidAgeExc("no vote");
	}
}

class InvalidAgeExc extends Exception{
	InvalidAgeExc (String s){
		super(s);
	}
}

class Parent{
	//void msg()throws IOException{
	//void msg()throws ArithmeticException{
	void msg(){
		System.out.println("parent");
	}
}

class TestChiled extends Parent {
//class TestChiled {
	//void msg()throws IOException{
	void msg()throws ArithmeticException{
	//void msg(){
		System.out.println("child");
	}
}

