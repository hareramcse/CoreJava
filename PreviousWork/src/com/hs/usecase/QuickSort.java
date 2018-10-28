package com.hs.usecase;

import java.util.Arrays;

public class QuickSort {
	private void sort(int arr[], int start, int end) {
		if (start >= end) {
			return;
		}// other boundary condition can be, iterate all these three bellow lines
			// when start<end
		int pIndex = partition(arr, start, end);
		sort(arr, start, pIndex - 1);
		sort(arr, pIndex + 1, end);
	}

	private int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				int tmp = arr[i]; // bcoz of this swapping, max value which is
									// greater than pivot will be the pIndex
									// value.
				arr[i] = arr[pIndex];
				arr[pIndex] = tmp;
				pIndex++;
			}
		}
		int tmp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = tmp;
		return pIndex;
	}

	public static void main(String[] args) {
		int arr[] = { 17, 6, 5, 4, 3, 14, 15, 13, 18, 24, 26, 11 };
		QuickSort quickSort = new QuickSort();
		System.out.println("data Before sorting " + Arrays.toString(arr));
		quickSort.sort(arr, 0, arr.length - 1);
		System.out.println("data After sorting " + Arrays.toString(arr));
	}
}
