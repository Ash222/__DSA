package com.dsa.recursion.leetcode.lc2305;

public class Solve {
	
	public static void main(String[] args) {
		
		final int[] cookies = {8, 15, 10, 20, 8};
		final int k = 2; // number of children
		final int result = distributeCookies(cookies, k);
		System.out.println(result);
	}
	
	private static int distributeCookies(final int[] cookies, final int k) {
		
		final int[] children = new int[k];
		final int[] result = {Integer.MAX_VALUE};
		dfs(0, cookies, children, result);
		
		return result[0];
	}
	
	private static void dfs(final int index, final int[] cookies, final int[] children,
			final int[] result) {
		
		// base case
		if (index >= cookies.length) {
			
			int max = Integer.MIN_VALUE;
			// find the max
			for (int n : children) {
				max = Math.max(max, n);
			}
			
			result[0] = Math.min(result[0], max);
			return;
		}
		
		for (int i = 0; i < children.length; i++) {
			children[i] += cookies[index];
			dfs(index + 1, cookies, children, result);
			children[i] -= cookies[index];
		}
	}
}
