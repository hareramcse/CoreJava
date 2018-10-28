package com.hs.training;

public class QuickSortDoublePivot {
	public void sort(int[] input) {
		// input=shuffle(input);
		sort(input, 0, input.length - 1);
	}

	private void sort(int[] input, int lowIndex, int highIndex) {

		if (highIndex <= lowIndex)
			return;

		int pivot1 = input[lowIndex];
		int pivot2 = input[highIndex];

		if (pivot1 > pivot2) {
			// exchange(input, lowIndex, highIndex);
			pivot1 = input[lowIndex];
			pivot2 = input[highIndex];
			// sort(input, lowIndex, highIndex);
		} else if (pivot1 == pivot2) {
			while (pivot1 == pivot2 && lowIndex < highIndex) {
				lowIndex++;
				pivot1 = input[lowIndex];
			}
		}

		int i = lowIndex + 1;
		int lt = lowIndex + 1;
		int gt = highIndex - 1;

		while (i <= gt) {

			/*
			 * if (less(input[i], pivot1)) { exchange(input, i++, lt++); } else
			 * if (less(pivot2, input[i])) { exchange(input, i, gt--); } else {
			 * i++; }
			 */

		}

		// exchange(input, lowIndex, --lt);
		// exchange(input, highIndex, ++gt);

		sort(input, lowIndex, lt - 1);
		sort(input, lt + 1, gt - 1);
		sort(input, gt + 1, highIndex);

	}

	public static void main(String[] args) {
		int arr[] = { 12, 34, 65, 1, 2, 6, 36, 7, 32 };
		QuickSortDoublePivot qsdp = new QuickSortDoublePivot();
		qsdp.sort(arr);
		for (int i : arr) {
			System.out.println(arr[i]);
		}
	}
}
