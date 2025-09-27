package com.dsa.arrays.leetcode.lc53;

public class Solve {
	
	private static int maxSubArray(int[] nums) {
		
		final int n = nums.length;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			maxSum = Math.max(maxSum, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		final int[] nums = {-1};
		System.out.println(maxSubArray(nums));
	}
}
