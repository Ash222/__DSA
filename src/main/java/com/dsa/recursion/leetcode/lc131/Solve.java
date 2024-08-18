package com.dsa.recursion.leetcode.lc131;

import java.util.ArrayList;
import java.util.List;

public class Solve {
	
	public static void main(String[] args) {
		
		final String string = "aab";
		final List<List<String>> result = partition(string);
		System.out.println(result);
	}
	
	private static List<List<String>> partition(final String string) {
		
		List<List<String>> result = new ArrayList<>();
		dfs(0, string, new ArrayList<String>(), result);
		return result;
	}
	
	private static void dfs(final int index, final String string,
			final ArrayList<String> stack, final List<List<String>> result) {
		
		// base case
		if (index >= string.length()) {
			result.add(new ArrayList<>(stack));
			return;
		}
		
		for (int i = index; i < string.length(); i++) {
			
			if (isPalindrome(string, index, i)) {
				stack.add(string.substring(index, i + 1));
				dfs(i + 1, string, stack, result);
				stack.removeLast();
			}
		}
	}
	
	private static boolean isPalindrome(final String string, int start, int end) {
		
		while (start <= end) {
			
			if (string.charAt(start) != string.charAt(end)) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
}
