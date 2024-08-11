package com.dsa.recursion.subsequence.p1;

import java.util.ArrayList;
import java.util.List;

public class Solve {
	
	public static void main(String[] args) {
		
		final int[] nums = {3, 2, 1};
		final List<List<Integer>> resultList = new ArrayList<>();
		solve(nums, 0, new ArrayList<>(), resultList);
		
		System.out.println(resultList);
	}
	
	private static void solve(final int[] nums, final int startIndex,
	                          final List<Integer> stack,
	                          final List<List<Integer>> result) {
		
		// base condition
		if (startIndex >= nums.length) {
			result.add(new ArrayList<>(stack));
			return;
		}
		
		// take
		stack.add(nums[startIndex]);
		solve(nums, startIndex + 1, stack, result);
		// not take
		stack.removeLast();
		solve(nums, startIndex + 1, stack, result);
	}
}
