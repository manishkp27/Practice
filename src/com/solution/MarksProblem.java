package com.solution;

import java.util.*;

public class MarksProblem {

	public static void main(String[] args) {
		Integer[]arr = {56,3,56,34,672,54,78};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		List lst = Arrays.asList(arr);
		System.out.println(lst.size()-lst.indexOf(78));
		//System.out.println(rank(arr));

	}
	static int rank(int[] arr){
		int res=0;
		
		return res;
	}

}
