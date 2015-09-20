package com.ds;

import java.util.Stack;

public class StackDEmo {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.add("manish");
		stack.add(5);
		stack.add("satish");
		
		//System.out.println(stack.);
	}

}

//class MyStack<T> implements Comparable {
class MyStack<T> {
	int maxSize;
	int top=-1;
	T[] stackArray;

	void MyStack(int size) {
		maxSize = size;
		stackArray = (T[])new Object[maxSize];

	}
	void push(T data){
		stackArray[++top]=data;
	}
	Object Pop(){
		return stackArray[top--];
	}
	
	/*@Override
	public int compareTo(Object arg0) {
		
		return 0;
	}*/
}
