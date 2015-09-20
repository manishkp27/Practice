package com.ds;

public class SortBubble {

	public static void main(String[] args) {
		int[] arr = {32, 39,21, 45, 23, 3};//{ 5, 3, 2, 1};;//{3,8,1,5,4,8,2,6,7};
		arr=Bubble(arr);
		for(int i:arr)
		System.out.println(i);
	}
	static int[] Bubble(int[] arr){
		int temp;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j])
				{	
					temp=arr[i];arr[i]=arr[j];arr[j]=temp;
				}
			}
		}
		
		return arr;
	}

}
