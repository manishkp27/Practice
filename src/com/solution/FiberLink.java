package com.solution;

import java.util.*;

public class FiberLink {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		
		int[]arr=new int[n];//={1,5,7,11,13};
		for(int t=0;t<n;t++){
			arr[t]=sc.nextInt();
		}
		
		/*System.out.println(Arrays.toString(arr));
		for(int t=1;t<n;t++){
			System.out.println(arr[t]-arr[t-1]);
		}*/
		
		int diff=0;
		
		int length=arr.length;
		
		int diff1=arr[1]-arr[0];
		int diff2=arr[length-1]-arr[length-2];
		
		diff=diff1<diff2?diff1:diff2;
		//System.out.println("diff"+diff);
		
		for(int i=1;i<arr.length;i++){
			if(arr[i]!=(arr[i-1]+diff)){
				System.out.println("missing "+(arr[i-1]+diff));
			}
		}
		
		/*
		
		/*int a=arr[1]-arr[0],b=arr[2]-arr[1],c=arr[3]-arr[2];
		if(a==b)
			System.out.println(diff=a);//c
		else if(a==c)
			System.out.println(diff=a);//b
		else if(b==c)
			System.out.println(diff=b);//a
*/	}

	static void func(){
		
	}
}
