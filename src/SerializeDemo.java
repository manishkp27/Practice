

import java.io.*;
public class SerializeDemo {

	public static void main(String[] args) {
		//Student st = new Student(3,"manish");
		//System.out.println(st.name);
		Address addr = Address.getInstance();
		Address addr2 = null;
		serialize(addr);
		addr2 = deserialize();
		if(addr2!=null){
			System.out.println(addr2.addressLine);
		}
		
		addr = Address.getInstance();
		serialize(addr);
		addr2 = deserialize();
		if(addr2!=null){
			System.out.println(addr2.addressLine);
		}
	}
	static void serialize(Address addr){
		FileOutputStream fis;
		try {
			fis = new FileOutputStream("addr.ser");
			ObjectOutputStream ois = new ObjectOutputStream(fis);
			ois.writeObject(addr);
		} catch (IOException e) {e.printStackTrace();}
		
	}
	static Address deserialize(){
		Address addr=null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("addr.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			addr = (Address)ois.readObject();
		} catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
		return addr;
	}
}

class Address implements Serializable{  
	 String addressLine,city,state;
	 public static final Address addrInstance = new Address("sesadripuram risaldar","bangalore","karnataka");
	 
	 {
		 System.out.println("non static block");
	 }
	 
	 /*private Address (){
		 System.out.println("constructor()");
	 }*/
	 private Address(String addressLine, String city, String state) { 
		 System.out.println("constructor(String addressLine, String city, String state)");
	  this.addressLine=addressLine;  
	  this.city=city;  
	  this.state=state;  
	 }  
	 public static final Address getInstance(){
		 return addrInstance;
	 }
	}  
	
	/*class Student implements Serializable{  
	 int id;  
	 String name;  
	 Address address;//HAS-A  
	 public Student(int id, String name) {  
	  this.id = id;  
	  this.name = name;
	  address = new Address();
	 }  
	}  
*/
