package com.dsa.recursion.problems.p1;

import java.util.Deque;
import java.util.LinkedList;

public class Solve {
	
	public static void main(String[] args) {
		
		Deque<Integer> stack = new LinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		displayStack(stack);
		reverse(stack);
		System.out.println();
		displayStack(stack);
	}
	
	// reverse the stack
	private static void reverse(final Deque<Integer> stack) {
		// base case
		if(stack.isEmpty()){
			return;
		}
		
		int element = stack.pop();
		reverse(stack);
		insertAtBottom(stack,element);
	}
	
	// insert an element at the bottom of the stack
	private static void insertAtBottom(final Deque<Integer> stack, int element) {
		
		// base case
		if(stack.isEmpty()){
			stack.push(element);
			return;
		}
		
		int e = stack.pop();
		insertAtBottom(stack,element);
		stack.push(e);
	}
	
	// displaying the stack from top to bottom using recursion
	private static void displayStack(final Deque<Integer> stack){
		
		// base case
		if(stack.isEmpty()){
			return;
		}
		
		int element = stack.pop();
		System.out.println(element);
		displayStack(stack);
		stack.push(element);
	}
}
