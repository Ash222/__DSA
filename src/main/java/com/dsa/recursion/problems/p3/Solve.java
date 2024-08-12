package com.dsa.recursion.problems.p3;

import java.util.Arrays;

public class Solve {
	
	public static void main(String[] args) {
		
		final int[] arr = {3, 1, 2, 5, 8, 4, 7};
		final int high = arr.length - 1;
		System.out.println(Arrays.toString(arr));
		mergeSort(arr, 0, high);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void mergeSort(final int[] arr, final int low, final int high) {
		
		// base case
		if (low >= high) {
			return;
		}
		
		final int mid = low + (high - low) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
	
	private static void merge(final int[] arr, final int low, final int mid,
	                          final int high) {
		
		final int leftArrSize = mid - low + 1;
		final int rightArrSize = high - mid;
		final int[] left = new int[leftArrSize];
		final int[] right = new int[rightArrSize];
		int k = low;
		
		// fill the left array
		for (int i = 0; i < leftArrSize; i++, k++) {
			left[i] = arr[k];
		}
		
		// fill the right array
		for (int i = 0; i < rightArrSize; i++, k++) {
			right[i] = arr[k];
		}
		
		// now we will sort the arr
		int i = 0, j = 0;
		k = low;
		
		while (i < leftArrSize && j < rightArrSize) {
			
			if (left[i] <= right[j]) {
				arr[k] = left[i++];
			} else {
				arr[k] = right[j++];
			}
			
			k++;
		}
		
		// now we will add the remaining elements from the left
		// and right array to the arr.
		while (i < leftArrSize) {
			arr[k++] = left[i++];
		}
		
		while (j < rightArrSize) {
			arr[k++] = right[j++];
		}
	}
}
