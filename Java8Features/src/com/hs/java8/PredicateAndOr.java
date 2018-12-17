package com.hs.java8;

import java.util.function.Predicate;

public class PredicateAndOr {
	public static void main(String[] args) {
		int arr[] = { 10, 21, 35, 67, 54, 32, 76 };
		Predicate<Integer> p1 = i -> i % 2 == 0;
		Predicate<Integer> p2 = i -> i > 10;

		for (int i : arr) {
			if (p1.and(p2).test(i)) {
				System.out.println(i + " is even and greater than 10");
			}
		}
	}
}
