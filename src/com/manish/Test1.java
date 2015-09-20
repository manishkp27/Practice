package com.manish;

import java.util.Comparator;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cc1 c1 = new Cc1();
		Cc2 c2 = new Cc2(5);
/*		System.out.println(c1 instanceof cc1);
		System.out.println(c1 instanceof cc2);

		System.out.println(c2 instanceof cc1);
		System.out.println(c2 instanceof cc2);*/
		
		//System.out.println(c1.equals(null));
		
		/*Class myClassObj1 = Intf1.class;
		System.out.println(myClassObj1.isInterface());*/
		
		/*Class myClassObj = Cc1.class;
		System.out.println(myClassObj.isInstance(c1));*/
		
	}

}

class Cc1{
	
}
class Cc2 extends Cc1{
	Cc2(){
		//super().this();
		System.out.println("Cc2() construcor");
	}
	Cc2(int i){
		this();
		System.out.println("Cc2(int i) construcor");
	}
	void func(){
		
	}
}
interface Intf1{
	
}
class Equal{

	@Override
	public boolean equals(Object arg0) {
		return false;
	}
	
}
class ComparatorTest implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}