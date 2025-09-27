package com.dsa.arrays.leetcode.lc75;

import java.util.Arrays;

public class Solve {
	
	public static void main(String[] args) {
		final int[] nums = {2, 0, 2, 1, 1, 0};
		final int[] expectedResult = {0, 0, 1, 1, 2, 2};
		sortColors(nums);
		if (Arrays.equals(nums, expectedResult)) {
			System.out.println("Congratulations"); // NOSONAR
		} else {
			System.out.println("Boohoo"); // NOSONAR
		}
	}
	
	private static void swap(final int[] nums, final int firstIndex, final int secondIndex) {
		final int holder = nums[firstIndex];
		nums[firstIndex] = nums[secondIndex]; // NOSONAR
		nums[secondIndex] = holder; // NOSONAR
	}
	
	private static void sortColors(final int[] nums) {
		
		final int n = nums.length;
		int i = 0;
		int j = 0;
		int k = n - 1;
		
		while (j < k) {
			if (nums[j] == 0) {
				swap(nums, i, j);
				i++;
				j++;
			} else if (nums[j] == 2) {
				swap(nums, j, k);
				k--;
			} else {
				j++;
			}
		}
	}
}
