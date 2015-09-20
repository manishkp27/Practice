package com.serialize;

import java.io.*;
/*
Serializable
 the identity of all the classes, its superclasses, instance variables and then the contents for these items
  is written to the serialization stream
Externalizable  
  identity of the class is written in the serialization stream and it is the responsibility of the class to save and restore
   the contents of its instances which means you will have complete control of what to serialize and what not to serialize.
   you need a default public constructor.
   Externalizable interface is not a marker interface and it provides two methods - writeExternal and readExternal.
 */
public class ExtenralizeDemo {

	public static void main(String[] args) {
		Address2 addr = Address2.getInstance();
		Address2 addr2 = null;
		serialize(addr);
		addr2 = deserialize();
		
		if(addr2!=null){
			System.out.println(addr2);
		}
	}
	static void serialize(Address2 addr){
		System.out.println(">>>>>>>>>>>Serialization>>>>>>>>>>>");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("addr.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(addr);
		} catch (IOException e) {e.printStackTrace();}
		System.out.println(">>>>>>>>>>>Serialization>>>>>>>>>>>");
	}
	static Address2 deserialize(){
		System.out.println("<<<<<<Deserialization<<<<<<<<");
		Address2 addr=null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("addr.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			addr = (Address2)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
		System.out.println("<<<<<<Deserialization<<<<<<<<");
		return addr;
	}
}

class Address2 implements Externalizable{  
	 String addressLine,city,state;
	 int doorNum;
	 public static final Address2 addrInstance = new Address2("sesadripuram risaldar","bangalore","karnataka",341);
	
	 {
		 System.out.println("non static block");
	 }
	 public Address2 (){
	   //super();
	   System.out.println("constructor()");
	 }
	 private Address2(String addressLine, String city, String state,int doorNum) { 
		 System.out.println("constructor(String addressLine, String city, String state)");
	  this.addressLine=addressLine;  
	  this.city=city;  
	  this.state=state; 
	  this.doorNum=doorNum;
	 }  
	 public static final Address2 getInstance(){
		 return addrInstance;
	 }
	 
	 public void writeExternal(ObjectOutput oo) throws IOException{
		 System.out.println("--writeExternal--");
		 oo.writeObject(addressLine);oo.writeObject(city);
		 //oo.writeObject(state);
		 oo.writeInt(doorNum);
	 }
	 public void readExternal(ObjectInput oi) throws ClassNotFoundException, IOException{
		 System.out.println("--readExternal--");
		 addressLine = (String)oi.readObject();
		 city = (String)oi.readObject();
		// state = (String)oi.readObject();
		 doorNum = oi.readInt();
	 }
	 public String toString(){
		 return addressLine+", "+state+", "+doorNum;
	 }
	}  
	
	/*class Student implements Serializable{  
	 int id;  
	 String name;  
	 Address2 address;//HAS-A  
	 public Student(int id, String name) {  
	  this.id = id;  
	  this.name = name;
	  address = new Address2();
	 }  
	}  
*/
