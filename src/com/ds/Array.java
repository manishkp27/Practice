package com.ds;

public class Array {

	public static void main(String[] args) {
		//String[] str = new String{"",""};
		String[] input = {"one","two","three","four","four"};
		System.out.println("\n Is Duplicatie:"+CheckDupllicate(input));
	}

	static boolean CheckDupllicate(String[] input){
		
		for(int i=0;i<input.length-1;i++){
			System.out.println("comp with:"+i);
			for(int j=i+1;j<input.length;j++){
				System.out.print(" "+j);
				if(input[i].equals(input[j]))
					return true;
			}
			System.out.println(" ");
		}
		return false;
	}
	
}
