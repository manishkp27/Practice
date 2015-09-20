package com.ds;

public class Palindrom {

	public static void main(String[] args) {
		int num=12345;//4567654;
		System.out.println(reverse(num));

	}

	static boolean Palindrom(int num){
		System.out.println((int)(num/1000000)+","+num%10);
		return true;
	}
	static int reverse(int num){
		int res=0;
		while(num>=1){
			res=res*10+num%10;
			num=num/10;
		}
		return res;
	}
}
