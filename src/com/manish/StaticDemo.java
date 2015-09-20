package com.manish;

public class StaticDemo {
	public static void main(String[] args) {
		
	}
}
class Student{
	final int f1;//=1;
	int i;
	static final int statFinal;
	static{
		statFinal=1;
	}
	Student(){
		f1=1;
	}
	final void func1(){
		final int f2;
		int j=10;
		this.i=10;
		//System.out.println(f2);
	}
}
class Student1 {
	void func1(int a){
		
	}
}
final class Steudent2{
	
}