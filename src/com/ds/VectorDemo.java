package com.ds;

import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		//Vector vt1 = new Vector();//10,20,30,..
		Vector vt1 = new Vector(1);//1,2,4,8,16,32..
		Vector vt2 = new Vector(6);//6,12,24,48..
		Vector vt3 = new Vector(11);//12,48,96..
		Vector vt4 = new Vector(3,5);//3,8,13,18..
		vt4.add(new School()); vt4.add("one2");
		vt4.add("one3");
		vt4.add("one4");
		vt4.add("one5");
		vt4.add("one6");
		vt4.add("one7");
		vt4.add("one8");
		vt4.add("one9");
		vt4.add("one10");
		
		vt4.add("one1");
		vt4.add("one2");
		vt4.add("one3");
		vt4.add("one4");
		vt4.add("one5");/*
		vt4.add("one6");
		vt4.add("one7");
		vt4.add("one8");
		vt4.add("one9");
		vt4.add("one10");
		vt4.add("one11");
		vt4.add("one12");
		vt4.add("one13");*/
		
		System.out.println("Initial size: " + vt1.size()+" Initial capacity: " + vt1.capacity());
		System.out.println("Initial size: " + vt2.size()+" Initial capacity: " + vt2.capacity());
		System.out.println("Initial size: " + vt3.size()+" Initial capacity: " + vt3.capacity());
		System.out.println("Initial size: " + vt4.size()+" Initial capacity: " + vt4.capacity());
	}

}
class School{
	int id;
	String name;
}
