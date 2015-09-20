package com.designpattern;

public class PrototypeDemo {

	public static void main(String[] args) {
		CloneFactory animalMaker = new CloneFactory();
		Sheep sally = new Sheep();
		Animall clonedSheep = animalMaker.getClone(sally);
		
		//test
		System.out.println(sally);
		System.out.println(clonedSheep);
		System.out.println(sally.hashCode());
		System.out.println(clonedSheep.hashCode());
		
	}

}

interface Animall extends Cloneable{
	Animall makeCopy();
}

class Sheep implements Animall{
	Sheep(){
		System.out.println("Sheep is made");
	}
	public Animall makeCopy(){
		Sheep sheep=null;
		try {
			sheep = (Sheep) super.clone();
		} catch (CloneNotSupportedException e) {e.printStackTrace();}
		
		System.out.println("Sheep copy is being made");
		return sheep;
	}
	public String toString(){
		return "Dolly is my helo, Baaaa";
	}
}
class CloneFactory{
	public Animall getClone(Animall animal){
		return animal.makeCopy();
	}
}