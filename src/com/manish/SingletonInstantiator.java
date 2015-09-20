package com.manish;

public class SingletonInstantiator {

	public static void main(String[] args) {
		
		/*ClassicSingleton i1= new ClassicSingleton();
		if(ClassicSingleton.getInstance()==i1)
			System.out.println("same");*/
		
		if(ClassicSingleton.getInstance()==ClassicSingleton.getInstance())
			System.out.println("same");
	}

}

class ClassicSingleton {
	private static ClassicSingleton instance = null;

	//protected ClassicSingleton() {
	private ClassicSingleton() {
		System.out.println("constructor");
	}

	public static ClassicSingleton getInstance() {
		if (instance == null) {
			instance = new ClassicSingleton();
		}
		return instance;
	}
}