package com.dsa.recursion.leetcode.lc1601;

public class Solve {
	
	public static void main(String[] args) {
		
		final int n = 3;
		final int[][] request = {
				{0, 0},
				{1, 2},
				{2, 1}
		};
		// final int n = 5;
		// final int[][] request = {
		// 		{0, 1},
		// 		{1, 0},
		// 		{0, 1},
		// 		{1, 2},
		// 		{2, 0},
		// 		{3, 4}
		// };
		final int result = maximumRequests(n, request);
		System.out.println(result);
	}
	
	private static int maximumRequests(final int n, final int[][] request) {
		
		final int[] buildings = new int[n];
		final int[] maxRequest = {Integer.MIN_VALUE};
		dfs(0, 0, request, buildings, maxRequest);
		
		return maxRequest[0];
	}
	
	private static void dfs(final int index, final int count, final int[][] request,
			final int[] buildings, final int[] maxRequest) {
		
		// base case
		if (index >= request.length) {
			
			// check is the resultant of building is 0
			boolean isBuildingResultantZero = true;
			for (int n : buildings) {
				if (n != 0) {
					isBuildingResultantZero = false;
					break;
				}
			}
			
			if (isBuildingResultantZero) {
				maxRequest[0] = Math.max(maxRequest[0], count);
			}
			
			return;
		}
		
		final int[] fromTo = request[index];
		buildings[fromTo[0]]--; // take
		buildings[fromTo[1]]++; // take
		
		dfs(index + 1, count + 1, request, buildings, maxRequest);
		
		buildings[fromTo[0]]++; // not take
		buildings[fromTo[1]]--; // not take
		dfs(index + 1, count, request, buildings, maxRequest);
	}
}
