package com.java8;

import java.util.Arrays;
import java.util.List;

public class FindDouble {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Integer> values = Arrays.asList(arr);
		int x = run(values);
		System.out.println(x);
	}

	public static int run(List<Integer> values) {
		return values.stream().filter(value -> value > 3)
				.filter(value -> value % 2 == 0).map(value -> value * 2)
				.findFirst().get();
	}
}
