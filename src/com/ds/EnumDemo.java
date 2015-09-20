package com.ds;
import java.util.*;

public class EnumDemo {
	public static void main(String[] arg){
	/*List content = TodoDao.instance.getModel();
	System.out.println(content.get(0));
	System.out.println(TodoDao.instance);*/
	
	//System.out.println(Arrays.toString(Company.values()));
	//Company a = new Company();//compilation error, Enum constructure is private	
	
	Company c;
	c =Company.Ebay;
	String s = c.name();
	System.out.println(Company.Ebay+" "+Company.Ebay.i);
	System.out.println(Company.Paypal+" "+Company.Paypal.i);
	}
}
enum TodoDao{
	instance;
	private List content;
	TodoDao(){
		content=new ArrayList();
		content.add("one");
		content.add("two");
		
	}
	public List getModel(){
		return content; 
	}
}
enum Company{
	Ebay(10),Google(20),Yahoo("Y"),Facebook(30),Whatsapp(Facebook),Paypal;
	Company(){//Construtcure is by default private
		System.out.println("Company.Company() name:"+this.name());
	}
	int i;
	String code;
	Company parentCmp;
	Company(int i){//Construtcure is by default private
		this.i=i;
		System.out.println("Company.Company() name:"+this.name()+" "+i);
	}
	Company(String code){//Construtcure is by default private
		this.code=code;
		System.out.println("Company.Company() name:"+this.name()+" "+i);
	}
	Company(Company parent){//Construtcure is by default private
		this.parentCmp=parent;
		System.out.println("Company.Company() name:"+this.name()+" "+i);
	}
	@Override
	public String toString(){
		System.out.println("Company.toString()");
		return this.name()+"+";
	}
}