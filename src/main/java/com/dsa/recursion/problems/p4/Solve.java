package com.dsa.recursion.problems.p4;

import java.util.Arrays;

public class Solve {
	
	public static void main(String[] args) {
		
		final int[] arr = {3, 1, 2, 5, 8, 4, 7};
		final int high = arr.length - 1;
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, high);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void quickSort(final int[] arr, final int low, final int high) {
		
		// base case
		if (low >= high) {
			return;
		}
		
		final int pivotIndex = pivotIndex(arr, low, high);
		quickSort(arr, low, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, high);
	}
	
	private static int pivotIndex(final int[] arr, final int low, final int high) {
		
		final int pivotNumber = arr[low];
		int start = low;
		int end = high;
		
		while (start <= end) {
			
			// keep on incrementing start until we get an element bigger or equal
			// than pivotNumber.
			while (start <= high && arr[start] <= pivotNumber) {
				start++;
			}
			
			// keep on decrementing the end until we get an element smaller than
			// the pivotNumber
			while (end >= low && arr[end] > pivotNumber) {
				end--;
			}
			
			if (start < end) {
				swap(arr, start, end);
			}
		}
		
		swap(arr, low, end);
		return end;
	}
	
	private static void swap(final int[] arr, final int low, final int high) {
		final int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
