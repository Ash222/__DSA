package com.dsa.recursion.leetcode.lc491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solve {
	
	public static void main(String[] args) {
		
		final int[] nums = {4, 4, 3, 2, 1};//{4, 6, 7, 7};
		final List<List<Integer>> result = findSubsequences(nums);
		System.out.println(result);
	}
	
	private static List<List<Integer>> findSubsequences(final int[] nums) {
		
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> stack = new ArrayList<>();
		
		dfs(0, nums, stack, result);
		
		return new ArrayList<>(result);
	}
	
	private static void dfs(final int index, final int[] nums,
			final List<Integer> stack, final Set<List<Integer>> result) {
		
		// base case
		if (stack.size() >= 2) {
			result.add(new ArrayList<>(stack));
		}
		
		for (int i = index; i < nums.length; i++) {
			
			if (stack.isEmpty() || stack.getLast() <= nums[i]) {
				
				stack.add(nums[i]);
				dfs(i + 1, nums, stack, result);
				stack.removeLast();
			}
		}
	}
}
