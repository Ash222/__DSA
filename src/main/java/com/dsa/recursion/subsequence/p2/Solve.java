package com.dsa.recursion.subsequence.p2;

import java.util.ArrayList;
import java.util.List;

public class Solve {
	
	public static void main(String[] args) {
		
		final String str = "abc";
		final List<List<Character>> resultList = new ArrayList<>();
		solve(str, 0, new ArrayList<Character>(), resultList);
		
		System.out.println(resultList);
	}
	
	private static void solve(final String str, final int startIndex,
	                          final ArrayList<Character> stack,
	                          final List<List<Character>> resultList) {
		
		// base case
		if (startIndex >= str.length()) {
			resultList.add(new ArrayList<>(stack));
			return;
		}
		
		// take
		stack.add(str.charAt(startIndex));
		solve(str, startIndex + 1, stack, resultList);
		// not take
		stack.removeLast();
		solve(str, startIndex + 1, stack, resultList);
	}
/*
	private static void solve2(final String str, final int startIndex,
	                           final ArrayList<Character> stack,
	                           final List<List<Character>> resultList) {
		
		// base case
		if (startIndex >= str.length()) {
			resultList.add(new ArrayList<>(stack));
			return;
		}
		
		for (int i = startIndex; i < str.length(); i++) {
			stack.add(str.charAt(startIndex));
			solve(str, startIndex + 1, stack, resultList);
			stack.removeLast();
		}
	}
	*/
}
