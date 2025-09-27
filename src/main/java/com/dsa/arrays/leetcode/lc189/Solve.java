package com.dsa.arrays.leetcode.lc189;

import java.util.Arrays;

public class Solve {
	
	public static void main(String[] args) {
		final int[] nums = {1, 2, 4, 10, 18};
		final int k = 3;
		System.out.println(Arrays.toString(leftRotate(nums, k)));
		// System.out.println(Arrays.toString(rightRotate(nums, k)));
	}
	
	private static int[] leftRotate(final int[] nums, int k) {
		final int n = nums.length;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		return nums;
	}
	
	private static int[] rightRotate(final int[] nums, int k) {
		final int n = nums.length;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
		return nums;
	}
	
	private static void reverse(final int[] nums, int low, int high) {
		while (low < high) {
			final int temp = nums[low];
			nums[low] = nums[high];
			nums[high] = temp;
			low++;
			high--;
		}
	}
}
