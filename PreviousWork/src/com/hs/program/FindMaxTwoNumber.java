package com.hs.program;

public class FindMaxTwoNumber {
	public int[] printTwoMaxNumbers(int[] nums) {
		int maxOne = 0;
		int maxTwo = 0;
		int[] arr=new int[2];
		for (int n : nums) {
			if (maxOne < n) {
				maxTwo = maxOne;
				maxOne = n;
			} else if (maxTwo < n) {
				maxTwo = n;
			}
			arr[0]=maxOne;
			arr[1]=maxTwo;
		}
		System.out.println("First Max Number: " + maxOne);
		System.out.println("Second Max Number: " + maxTwo);
		return arr;
	}

	public static void main(String a[]) {
		int num[] = { 5, 34, 78, 2, 45, 1, 99, 23 };
		FindMaxTwoNumber tmn = new FindMaxTwoNumber();
		tmn.printTwoMaxNumbers(num);
	}
}