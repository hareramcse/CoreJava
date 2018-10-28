package com.hs.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinProcessor extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private static final Random random = new Random(42);
	private final int[] array;
	private final int start;
	private final int end;

	ForkJoinProcessor(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}

	public void compute() {
		int size = end - start;
		if (size <= 8) {
			Arrays.sort(array, start, end);
		} else {
			int middle = start + (size >> 1);
			invokeAll(new ForkJoinProcessor(array, start, middle),
					new ForkJoinProcessor(array, middle, end));
			merge(middle);
		}
	}

	private void merge(int middle) {
		if (array[middle - 1] < array[middle]) {
			return;
		}
		int copySize = end - start;
		int copyMiddle = middle - start;
		int[] copy = new int[copySize];
		System.arraycopy(array, start, copy, 0, copy.length);
		int p = 0;
		int q = copyMiddle;
		for (int i = start; i < end; ++i) {
			if (q >= copySize || (p < copyMiddle && copy[p] < copy[q])) {
				array[i] = copy[p++];
			} else {
				array[i] = copy[q++];
			}
		}
	}

	// Creates an array of the given length, fills it with random
	// non-negative integers, and returns it.
	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(1000000);
		}
		return a;
	}

	// Returns true if the given array is in sorted ascending order.
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int LENGTH = 1000; // initial length of array to sort
		int RUNS = 16; // how many times to grow by 2?
		ForkJoinPool pool = new ForkJoinPool();
		for (int i = 1; i <= RUNS; i++) {
			int[] array = createRandomArray(LENGTH);

			// run the algorithm and time how long it takes
			long startTime = System.currentTimeMillis();
			pool.submit(new ForkJoinProcessor(array, 0, array.length)).join();
			long endTime = System.currentTimeMillis();

			if (!isSorted(array)) {
				throw new RuntimeException("not sorted afterward: "
						+ Arrays.toString(array));
			}

			System.out.printf("%10d elements  =>  %6d ms \n", LENGTH, endTime
					- startTime);
			LENGTH *= 2; // double size of array for next time
		}
	}
}