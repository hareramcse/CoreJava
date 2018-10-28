package com.hs.durga;

import java.util.function.IntPredicate;

public class MyIntPredicate {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		IntPredicate intPredicate = i -> i % 2 == 0;
		for (int i : arr) {
			if (intPredicate.test(i)) {
				System.out.println(i + " this is even number ");
			}
		}
	}
}
